/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.learn.service;

import com.liferay.client.extension.util.spring.boot3.service.BaseService;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.HashMapBuilder;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

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
		String friendlyUrlPath, String name) {

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
			).append(
				"link to documentation: "+ document.getMetadata().get("friendlyUrlPath")
			);

			references.add(document.getMetadata());
		}

		String system_prompt = """
You are the Liferay Learn search assistant.
Your primary goal is to help users understand how to use Liferay DXP.

Your task is NOT just to answer the query, but to SYNTHESIZE a structured "Learn AI Overview" using ONLY the provided DOCUMENTS as your source.

### MANDATORY OUTPUT FORMAT

1.  **Overview:**
    Start with a concise, 1-2 sentence description of what the user are searching for, directly addressing the intent of the QUERY. (e.g., "Liferay DXP... enables you to build, manage, and optimize digital experiences...")

2.  **Get Started Guide (Step-by-Step):**
    If the QUERY is broad (like "how to use," "get started," "what is"), generate a logical, numbered list of steps to get started.
    * Use Markdown for the list (e.g., `1. `, `2. `, `3. `).
    * Each list item MUST have a short, bolded title starting with an action verb. (e.g., "**1. Install Liferay DXP**", "**2. Understand the Platform Architecture**", "**3. Create and Manage Sites**").
    * Below the title, provide a brief 1-2 sentence description for that step.

3.  **Suggested Questions (Follow-ups):**
    After the guide, include a final section named "You Might Also Be Looking For:".
    * List exactly 4 relevant follow-up questions, based on the DOCUMENTS, that help the user take the next step.

### RULES AND CONSTRAINTS

* **DOCUMENT-FOCUSED:** Base your response *exclusively* on the `DOCUMENTS`. Do not invent steps or features not present in them.
* **FORBIDDEN PHRASES:** NEVER use phrases like "Based on the information," "In the provided documents," "According to your search," or similar terms. Act as a direct expert.
* **FALLBACK:** If the `DOCUMENTS` do not contain enough information to create this guide, or if the `QUERY` is too specific for a general guide, simply state that you cannot find an overview for that query.
Here it's all related documents:
""" + sb + "   Here it's the user query: " + question;

		StringBundler.concat(
				"You are a Liferay Learn assistant specialized in Liferay DXP and its official documentation." +
						"You are the Liferay Learn search assistant to provide accurate and detailed ",
				"answers to the query in the QUERY section helping users to find that they are looking for, ",
				"providing guidance and descriptions about the desired feature. Consider that all users are searching for something related to ",
				"liferay and if ",
				"unsure, simply state that you do not know and please avoid statements like ",
				"'Based on the given information' or similar terms. DOCUMENTS: ", sb,
				"QUERY: ", question);


		String markdownResponse = _chatClient.prompt(
		).user(
			system_prompt
		).call(
		).content();

		Parser parser = Parser.builder(
		).build();
		HtmlRenderer renderer = HtmlRenderer.builder(
		).build();

		String render = renderer.render(parser.parse(markdownResponse));

		return HashMapBuilder.<String, Object>put(
			"references", references
		).put(
			"summary", markdownResponse
		).build();
	}

	@Autowired
	private ChatClient _chatClient;

	@Autowired
	private EmbeddingModel _embeddingModel;

	@Autowired
	private QdrantVectorStore _vectorStore;

}