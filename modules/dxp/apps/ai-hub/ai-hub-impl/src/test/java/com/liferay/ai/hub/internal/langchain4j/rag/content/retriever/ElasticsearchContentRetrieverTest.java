/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ai.hub.internal.langchain4j.rag.content.retriever;

import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.engine.adapter.SearchEngineAdapter;
import com.liferay.portal.search.engine.adapter.search.SearchSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SearchSearchResponse;
import com.liferay.portal.search.highlight.FieldConfigBuilderFactory;
import com.liferay.portal.search.highlight.HighlightBuilderFactory;
import com.liferay.portal.search.highlight.HighlightField;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

<<<<<<< HEAD
import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.data.segment.TextSegment;
=======
>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.query.Query;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

<<<<<<< HEAD
import org.mockito.ArgumentCaptor;
=======
>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
import org.mockito.Mockito;

/**
 * @author Iliyan Peychev
 */
public class ElasticsearchContentRetrieverTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
<<<<<<< HEAD
	public void testSearch() {
		SearchEngineAdapter searchEngineAdapter = Mockito.mock(
			SearchEngineAdapter.class);

		SearchHit lowScoreSearchHit = Mockito.mock(SearchHit.class);

		Mockito.when(
			lowScoreSearchHit.getScore()
		).thenReturn(
			0.5F
		);

		SearchHit highScoreSearchHit = Mockito.mock(SearchHit.class);

		HighlightField highlightField = Mockito.mock(HighlightField.class);

		String fragment = RandomTestUtil.randomString();

=======
	public void testSearchSkipsHitsScoringBelowMinScore() {
		String fragment = RandomTestUtil.randomString();

		HighlightField highlightField = Mockito.mock(HighlightField.class);

>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
		Mockito.when(
			highlightField.getFragments()
		).thenReturn(
			List.of(fragment)
		);

<<<<<<< HEAD
=======
		SearchHit highScoreSearchHit = Mockito.mock(SearchHit.class);

>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
		Mockito.when(
			highScoreSearchHit.getHighlightFieldsMap()
		).thenReturn(
			Map.of("text_embedding", highlightField)
		);

		Mockito.when(
			highScoreSearchHit.getScore()
		).thenReturn(
			0.9F
		);

<<<<<<< HEAD
		String url = RandomTestUtil.randomString();

		Mockito.when(
			highScoreSearchHit.getSourcesMap()
		).thenReturn(
			Map.of(_URL, url)
=======
		SearchHit lowScoreSearchHit = Mockito.mock(SearchHit.class);

		Mockito.when(
			lowScoreSearchHit.getScore()
		).thenReturn(
			0.5F
>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
		);

		SearchHits searchHits = Mockito.mock(SearchHits.class);

		Mockito.when(
			searchHits.getSearchHits()
		).thenReturn(
			List.of(lowScoreSearchHit, highScoreSearchHit)
		);

		SearchSearchResponse searchSearchResponse = Mockito.mock(
			SearchSearchResponse.class);

		Mockito.when(
			searchSearchResponse.getSearchHits()
		).thenReturn(
			searchHits
		);

<<<<<<< HEAD
=======
		SearchEngineAdapter searchEngineAdapter = Mockito.mock(
			SearchEngineAdapter.class);

>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
		Mockito.when(
			searchEngineAdapter.execute((SearchSearchRequest)Mockito.any())
		).thenReturn(
			searchSearchResponse
		);

<<<<<<< HEAD
=======
		Query query = Mockito.mock(Query.class);

		Mockito.when(
			query.text()
		).thenReturn(
			RandomTestUtil.randomString()
		);

>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
		ElasticsearchContentRetriever elasticsearchContentRetriever =
			new ElasticsearchContentRetriever(
				Mockito.mock(
					FieldConfigBuilderFactory.class,
					Mockito.RETURNS_DEEP_STUBS),
				Mockito.mock(
					HighlightBuilderFactory.class, Mockito.RETURNS_DEEP_STUBS),
				new String[] {RandomTestUtil.randomString()},
				searchEngineAdapter, RandomTestUtil.randomLong(),
				RandomTestUtil.randomLong());

<<<<<<< HEAD
		Query query = Mockito.mock(Query.class);

		Mockito.when(
			query.text()
		).thenReturn(
			RandomTestUtil.randomString()
		);

=======
>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
		List<Content> contents = elasticsearchContentRetriever.search(query);

		Assert.assertEquals(contents.toString(), 1, contents.size());

		Content content = contents.get(0);

<<<<<<< HEAD
		TextSegment textSegment = content.textSegment();

		Assert.assertEquals(fragment, textSegment.text());

		Metadata metadata = textSegment.metadata();

		Assert.assertEquals(url, metadata.getString(_URL));

		ArgumentCaptor<SearchSearchRequest> argumentCaptor =
			ArgumentCaptor.forClass(SearchSearchRequest.class);

		Mockito.verify(
			searchEngineAdapter
		).execute(
			argumentCaptor.capture()
		);

		SearchSearchRequest searchSearchRequest = argumentCaptor.getValue();

		Assert.assertTrue(searchSearchRequest.getFetchSource());
		Assert.assertArrayEquals(
			new String[] {_URL}, searchSearchRequest.getFetchSourceIncludes());
	}

	private static final String _URL = "url";

=======
		Assert.assertEquals(
			fragment,
			content.textSegment(
			).text());
	}

>>>>>>> b7523bdc2a261 (LPD-96487 Skip low-score chunks in the Elasticsearch RAG retriever)
}