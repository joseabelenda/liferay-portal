/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.learn.service;

import com.liferay.client.extension.util.spring.boot3.service.BaseService;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.HashMapBuilder;

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

		List<Document> splittedDocuments = new TokenTextSplitter(
		).split(
			document
		);

		_vectorStore.doAdd(splittedDocuments);
	}

	public Map<String, Object> search(String question) {
		List<Document> vectorStoreResult = _vectorStore.doSimilaritySearch(
			SearchRequest.builder(
			).query(
				question
			).topK(
				3
			).similarityThreshold(
				0.8
			).build());

		List<Map<String, Object>> references = new ArrayList<>();
		StringBundler sb = new StringBundler();

		for (Document document : vectorStoreResult) {
			sb.append(
				document.getText()
			).append(
				System.lineSeparator()
			);

			references.add(document.getMetadata());
		}

		String system_prompt = """
You are the Liferay Learn search assistant.
Your primary goal is to help users understand how to use Liferay DXP and find what
they are looking for on Liferay Learn site.

Your task is NOT just to answer the query, but to SYNTHESIZE a structured overview
about the desired Liferay feature in the QUESTION section using ONLY the provided DOCUMENTS as your source.
You can also provide steps to guide the user about what they are searching for,
and you can also include a final section named "You Might Also Be Looking For:"
that you can list up to 4 relevant follow-up questions

### RULES AND CONSTRAINTS

* DOCUMENT-FOCUSED: Base your response *exclusively* on the `DOCUMENTS`. Do not invent steps or features not present in them.
* FORBIDDEN PHRASES: NEVER use phrases like "Based on the information," "In the provided documents," "According to your search," or similar terms. Act as a direct expert.
* FALLBACK: If the `DOCUMENTS` do not contain enough information to create this guide, or if the `QUERY` is too specific for a general guide, simply state that you cannot find an what they are looking for.
* LIFERAY-ONLY: Consider that all questions are related only to Liferay DXP

DOCUMENTS: """ + sb + "\nQUESTION: " + question;

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