/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ai.hub.internal.memory;

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
		MessageWindowChatMemory messageWindowChatMemory1 =
			ChatMemoryProviderUtil.provide("testEvict-id-1");

		messageWindowChatMemory1.add(UserMessage.from("first"));

		MessageWindowChatMemory messageWindowChatMemory2 =
			ChatMemoryProviderUtil.provide("testEvict-id-2");

		messageWindowChatMemory2.add(UserMessage.from("second"));

		ChatMemoryProviderUtil.evict("testEvict-id-1");

		Assert.assertTrue(
			messageWindowChatMemory1.messages(
			).isEmpty());
		Assert.assertFalse(
			messageWindowChatMemory2.messages(
			).isEmpty());
	}

	@Test
	public void testEvictRemovesMessages() {
		MessageWindowChatMemory messageWindowChatMemory =
			ChatMemoryProviderUtil.provide("testEvictRemovesMessages-id");

		messageWindowChatMemory.add(UserMessage.from("Hello"));

		Assert.assertFalse(
			messageWindowChatMemory.messages(
			).isEmpty());

		ChatMemoryProviderUtil.evict("testEvictRemovesMessages-id");

		Assert.assertTrue(
			messageWindowChatMemory.messages(
			).isEmpty());
	}

	@Test
	public void testEvictUnknownMemoryIdDoesNotThrow() {
		ChatMemoryProviderUtil.evict("testEvictUnknownMemoryId-id");

		MessageWindowChatMemory messageWindowChatMemory =
			ChatMemoryProviderUtil.provide("testEvictUnknownMemoryId-id");

		Assert.assertTrue(
			messageWindowChatMemory.messages(
			).isEmpty());
	}

}