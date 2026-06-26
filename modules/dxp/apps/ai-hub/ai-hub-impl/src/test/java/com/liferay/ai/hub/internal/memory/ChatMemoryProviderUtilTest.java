/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ai.hub.internal.memory;

import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.test.rule.LiferayUnitTestRule;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author José Abelenda
 */
public class ChatMemoryProviderUtilTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testEvictDoesNotAffectOtherMemoryIds() {
		String memoryId1 = RandomTestUtil.randomString();

		MessageWindowChatMemory messageWindowChatMemory1 =
			ChatMemoryProviderUtil.provide(memoryId1);

		messageWindowChatMemory1.add(
			UserMessage.from(RandomTestUtil.randomString()));

		String memoryId2 = RandomTestUtil.randomString();

		MessageWindowChatMemory messageWindowChatMemory2 =
			ChatMemoryProviderUtil.provide(memoryId2);

		messageWindowChatMemory2.add(
			UserMessage.from(RandomTestUtil.randomString()));

		ChatMemoryProviderUtil.evict(memoryId1);

		Assert.assertTrue(
			messageWindowChatMemory1.messages(
			).isEmpty());
		Assert.assertFalse(
			messageWindowChatMemory2.messages(
			).isEmpty());
	}

	@Test
	public void testEvictRemovesMessages() {
		String memoryId = RandomTestUtil.randomString();

		MessageWindowChatMemory messageWindowChatMemory =
			ChatMemoryProviderUtil.provide(memoryId);

		messageWindowChatMemory.add(
			UserMessage.from(RandomTestUtil.randomString()));

		Assert.assertFalse(
			messageWindowChatMemory.messages(
			).isEmpty());

		ChatMemoryProviderUtil.evict(memoryId);

		Assert.assertTrue(
			messageWindowChatMemory.messages(
			).isEmpty());
	}

	@Test
	public void testEvictUnknownMemoryIdDoesNotThrow() {
		String memoryId = RandomTestUtil.randomString();

		ChatMemoryProviderUtil.evict(memoryId);

		MessageWindowChatMemory messageWindowChatMemory =
			ChatMemoryProviderUtil.provide(memoryId);

		Assert.assertTrue(
			messageWindowChatMemory.messages(
			).isEmpty());
	}

}