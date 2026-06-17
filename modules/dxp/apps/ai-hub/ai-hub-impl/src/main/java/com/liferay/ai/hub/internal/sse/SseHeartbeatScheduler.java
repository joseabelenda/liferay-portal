/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ai.hub.internal.sse;

import com.liferay.ai.hub.internal.memory.ChatMemoryProviderUtil;
import com.liferay.ai.hub.rest.resource.v1_0.util.SseUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Jose Abelenda
 */
@Component(service = {})
public class SseHeartbeatScheduler {

	@Activate
	protected void activate() {
		_scheduledExecutorService =
			Executors.newSingleThreadScheduledExecutor();

		_scheduledExecutorService.scheduleWithFixedDelay(
			this::_sendHeartbeats, _HEARTBEAT_INTERVAL, _HEARTBEAT_INTERVAL,
			TimeUnit.SECONDS);
	}

	@Deactivate
	protected void deactivate() {
		_scheduledExecutorService.shutdownNow();
	}

	private void _sendHeartbeats() {
		try {
			Set<String> reapedSseEventSinkKeys = SseUtil.sendHeartbeats();

			for (String reapedSseEventSinkKey : reapedSseEventSinkKeys) {
				ChatMemoryProviderUtil.evict(reapedSseEventSinkKey);
			}
		}
		catch (Exception exception) {
			_log.error(exception);
		}
	}

	private static final long _HEARTBEAT_INTERVAL = 15;

	private static final Log _log = LogFactoryUtil.getLog(
		SseHeartbeatScheduler.class);

	private ScheduledExecutorService _scheduledExecutorService;

}