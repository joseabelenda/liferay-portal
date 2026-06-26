/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ai.hub.rest.resource.v1_0.util;

import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import jakarta.ws.rs.sse.OutboundSseEvent;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseEventSink;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author José Abelenda
 */
public class SseUtilTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Before
	public void setUp() {
		_sseEventSinks = new ConcurrentHashMap<>();
		_sses = new ConcurrentHashMap<>();

		ReflectionTestUtil.setFieldValue(
			SseUtil.class, "_sseEventSinks", _sseEventSinks);
		ReflectionTestUtil.setFieldValue(SseUtil.class, "_sses", _sses);
	}

	@Test
	public void testSendHeartbeatsKeepsLiveSink() {
		String sseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink sseEventSink = _mockLiveSseEventSink();

		_sseEventSinks.put(sseEventSinkKey, sseEventSink);

		_sses.put(sseEventSinkKey, _mockSse());

		Set<String> reapedSseEventSinkKeys = new HashSet<>();

		SseUtil.sendHeartbeats(reapedSseEventSinkKeys::add);

		Assert.assertTrue(reapedSseEventSinkKeys.isEmpty());

		Assert.assertTrue(_sseEventSinks.containsKey(sseEventSinkKey));

		Mockito.verify(
			sseEventSink
		).send(
			Mockito.any(OutboundSseEvent.class)
		);

		Mockito.verify(
			sseEventSink, Mockito.never()
		).close();
	}

	@Test
	public void testSendHeartbeatsReapsClosedSink() {
		String sseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink sseEventSink = Mockito.mock(SseEventSink.class);

		Mockito.when(
			sseEventSink.isClosed()
		).thenReturn(
			true
		);

		_sseEventSinks.put(sseEventSinkKey, sseEventSink);

		_sses.put(sseEventSinkKey, _mockSse());

		Set<String> reapedSseEventSinkKeys = new HashSet<>();

		SseUtil.sendHeartbeats(reapedSseEventSinkKeys::add);

		Assert.assertTrue(reapedSseEventSinkKeys.contains(sseEventSinkKey));

		Assert.assertFalse(_sseEventSinks.containsKey(sseEventSinkKey));

		Mockito.verify(
			sseEventSink, Mockito.never()
		).send(
			Mockito.any(OutboundSseEvent.class)
		);

		Mockito.verify(
			sseEventSink, Mockito.never()
		).close();
	}

	@Test
	public void testSendHeartbeatsReapsOnlyDeadSinks() {
		String liveSseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink liveSseEventSink = _mockLiveSseEventSink();

		_sseEventSinks.put(liveSseEventSinkKey, liveSseEventSink);

		_sses.put(liveSseEventSinkKey, _mockSse());

		String closedSseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink closedSseEventSink = Mockito.mock(SseEventSink.class);

		Mockito.when(
			closedSseEventSink.isClosed()
		).thenReturn(
			true
		);

		_sseEventSinks.put(closedSseEventSinkKey, closedSseEventSink);

		_sses.put(closedSseEventSinkKey, _mockSse());

		Set<String> reapedSseEventSinkKeys = new HashSet<>();

		SseUtil.sendHeartbeats(reapedSseEventSinkKeys::add);

		Assert.assertEquals(
			Collections.singleton(closedSseEventSinkKey),
			reapedSseEventSinkKeys);

		Assert.assertTrue(_sseEventSinks.containsKey(liveSseEventSinkKey));
		Assert.assertFalse(_sseEventSinks.containsKey(closedSseEventSinkKey));
	}

	@Test
	public void testSendHeartbeatsReapsSinkMissingSse() {
		String sseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink sseEventSink = Mockito.mock(SseEventSink.class);

		_sseEventSinks.put(sseEventSinkKey, sseEventSink);

		Set<String> reapedSseEventSinkKeys = new HashSet<>();

		SseUtil.sendHeartbeats(reapedSseEventSinkKeys::add);

		Assert.assertTrue(reapedSseEventSinkKeys.contains(sseEventSinkKey));

		Assert.assertFalse(_sseEventSinks.containsKey(sseEventSinkKey));

		Mockito.verify(
			sseEventSink
		).close();
	}

	@Test
	public void testSendHeartbeatsReapsSinkOnAsynchronousFailure() {
		String sseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink sseEventSink = Mockito.mock(SseEventSink.class);

		CompletableFuture<Object> completableFuture = new CompletableFuture<>();

		completableFuture.completeExceptionally(new RuntimeException());

		Mockito.doReturn(
			completableFuture
		).when(
			sseEventSink
		).send(
			Mockito.any(OutboundSseEvent.class)
		);

		_sseEventSinks.put(sseEventSinkKey, sseEventSink);

		_sses.put(sseEventSinkKey, _mockSse());

		Set<String> reapedSseEventSinkKeys = new HashSet<>();

		SseUtil.sendHeartbeats(reapedSseEventSinkKeys::add);

		Assert.assertFalse(_sseEventSinks.containsKey(sseEventSinkKey));

		Assert.assertTrue(reapedSseEventSinkKeys.contains(sseEventSinkKey));

		Mockito.verify(
			sseEventSink
		).close();
	}

	@Test
	public void testSendHeartbeatsReapsSinkOnSynchronousFailure() {
		String sseEventSinkKey = RandomTestUtil.randomString();

		SseEventSink sseEventSink = Mockito.mock(SseEventSink.class);

		Mockito.when(
			sseEventSink.send(Mockito.any(OutboundSseEvent.class))
		).thenThrow(
			new RuntimeException()
		);

		_sseEventSinks.put(sseEventSinkKey, sseEventSink);

		_sses.put(sseEventSinkKey, _mockSse());

		Set<String> reapedSseEventSinkKeys = new HashSet<>();

		SseUtil.sendHeartbeats(reapedSseEventSinkKeys::add);

		Assert.assertTrue(reapedSseEventSinkKeys.contains(sseEventSinkKey));

		Assert.assertFalse(_sseEventSinks.containsKey(sseEventSinkKey));

		Mockito.verify(
			sseEventSink
		).close();
	}

	private SseEventSink _mockLiveSseEventSink() {
		SseEventSink sseEventSink = Mockito.mock(SseEventSink.class);

		Mockito.doReturn(
			CompletableFuture.completedFuture(null)
		).when(
			sseEventSink
		).send(
			Mockito.any(OutboundSseEvent.class)
		);

		return sseEventSink;
	}

	private Sse _mockSse() {
		OutboundSseEvent.Builder builder = Mockito.mock(
			OutboundSseEvent.Builder.class);

		Mockito.when(
			builder.comment(Mockito.anyString())
		).thenReturn(
			builder
		);

		Mockito.when(
			builder.build()
		).thenReturn(
			Mockito.mock(OutboundSseEvent.class)
		);

		Sse sse = Mockito.mock(Sse.class);

		Mockito.when(
			sse.newEventBuilder()
		).thenReturn(
			builder
		);

		return sse;
	}

	private Map<String, SseEventSink> _sseEventSinks;
	private Map<String, Sse> _sses;

}