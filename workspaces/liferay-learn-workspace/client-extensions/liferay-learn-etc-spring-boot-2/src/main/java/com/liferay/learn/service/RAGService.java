/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.learn.service;

import com.liferay.client.extension.util.spring.boot3.service.BaseService;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Validator;

import java.time.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nilton Vieira
 */
@Service
public class RAGService extends BaseService {

	public void deleteDocument(long assetEntryId){
		_vectorStore.delete("assetEntryId == '" + assetEntryId + "'");
	}

	public void addOrUpdateDocument(
		long assetEntryId, String assetEntryType, String content,
		String description, String friendlyUrlPath, String name) {

		Document document = new Document(
			content,
			HashMapBuilder.<String, Object>put(
				"assetEntryId", assetEntryId
			).put(
				"assetEntryType", assetEntryType
			).put(
				"dateModified",
				OffsetDateTime.now(
				).toString()
			).put(
				"description", description
			).put(
				"friendlyUrlPath", friendlyUrlPath
			).put(
				"name", name
			).build());

		_vectorStore.delete("assetEntryId == '" + assetEntryId + "'");

		TokenTextSplitter tokenTextSplitter = new TokenTextSplitter();

		_vectorStore.doAdd(tokenTextSplitter.split(document));
	}

	public Map<String, Object> search(String question) throws Exception {
		if (Validator.isNull(question)) {
			return HashMapBuilder.<String, Object>put(
				"references", new ArrayList()
			).put(
				"summary", "No content was found for " + question
			).build();
		}

		List<Document> vectorStoreResult = _vectorStore.doSimilaritySearch(
			SearchRequest.builder(
			).query(
				question
			).topK(
				3
			).similarityThreshold(
				0.8
			).build());

		if (vectorStoreResult.isEmpty()) {
			return HashMapBuilder.<String, Object>put(
				"references", new ArrayList()
			).put(
				"summary", "No content was found for " + question
			).build();
		}

		List<Long> assetEntryIds = new ArrayList<>();
		List<Map<String, Object>> references = new ArrayList<>();
		StringBundler sb = new StringBundler();

		for (Document document : vectorStoreResult) {
			sb.append(document.getText());
			sb.append(System.lineSeparator());

			Map<String, Object> metadata = document.getMetadata();

			if (assetEntryIds.contains(metadata.get("assetEntryId"))) {
				continue;
			}

			references.add(document.getMetadata());
			assetEntryIds.add(GetterUtil.getLong(metadata.get("assetEntryId")));
		}

		String system_prompt = """
You are the Liferay Learn search assistant.
Your primary goal is to help users understand how to use Liferay DXP and help them to find what they are looking for.

You should be able to SYNTHESIZE a structured overview about the desired Liferay feature in the QUERY section using ONLY the provided DOCUMENTS as your source.
You can also provide steps to guide the user about what they are searching for

### RULES AND CONSTRAINTS

* DOCUMENT-FOCUSED: Base your response *exclusively* on the `DOCUMENTS`. Do not invent steps or features not present in them.
* FORBIDDEN PHRASES: NEVER use phrases like "Based on the information," "In the provided documents," "According to your search," or similar terms. Act as a direct expert.
* FALLBACK: If the `DOCUMENTS` do not contain enough information to create this guide, or if the `QUERY` is too specific for a general guide, simply state that you cannot find an what they are looking for.
* LIFERAY-ONLY: Consider that all queries are related only to Liferay DXP

DOCUMENTS: """ + sb + "\nQUERY: " + question;

		return HashMapBuilder.<String, Object>put(
			"references", references
		).put(
			"summary",
			_chatClient.prompt(
			).user(
				system_prompt
			).call(
			).content()
		).build();
	}

	@Autowired
	private ChatClient _chatClient;

	@Autowired
	private EmbeddingModel _embeddingModel;

	@Autowired
	private QdrantVectorStore _vectorStore;

}