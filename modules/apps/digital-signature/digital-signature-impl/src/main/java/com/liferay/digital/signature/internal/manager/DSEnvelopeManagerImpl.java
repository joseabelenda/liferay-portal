/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.digital.signature.internal.manager;

import org.osgi.service.component.annotations.Component;

import com.liferay.digital.signature.manager.DSEnvelopeManager;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = DSEnvelopeManager.class)
public class DSEnvelopeManagerImpl implements DSEnvelopeManager {

	public void addDSEnvelope() {
		if (_log.isDebugEnabled()) {
			_log.debug("Invoking #addDSEnvelope nicolas");
			String errorMessage = null;
			String identificationToken = null;
			try {
				Http.Options options = new Http.Options();
				String JWT = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiI0YWM5OTNmOS1hNGQ2LTQwODYtOGM1OS01YzRiNTNiM2U0ZWMiLCJzdWIiOiJkNWJiMTJmYy0xNDYwLTRhOGYtYjMzZS0xMzk2MDg4NmQwYTkiLCJhdWQiOiJhY2NvdW50LWQuZG9jdXNpZ24uY29tIiwiaWF0IjoxNjIwMzk3NTkyLCJleHAiOjE2MjA2Njc1OTIsInNjb3BlIjoic2lnbmF0dXJlIGltcGVyc29uYXRpb24ifQ.kvV4D1Vi2oBvzcC6FUac-8dgjobrLBbqbqDQft0S-NRFd79SMx9uMuuVRLH5_sBk9uTIYh0AwVyK0PMRHggAHmoEEi-YMvYHfI2XvFMKYux_h7s6eDaVONKdo0A9TwV23b6R_EB1StsUPfzal5ju1wjx1msIupAYXFKbV46yRqNUSJYicKq3UeqEZ0oKWSkpq3lD8eBnMZrq_dIEh09TX6wQR8fvm8gdJykCazGydx2hszBJMSSJnAQ3xvBqzocrCK-Q02_uP9FDEyUfvyVgvNXkom3Q8V2wyYHrdcCBe6CEpM7KFKtYU-5Y758oPE8U3VSuiO3R9oKetxNFhGxurA";

				options.addHeader(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
				options.setBody(
					JSONUtil.put(
						"grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer"
					).put(
						"assertion", JWT
					).toJSONString(),
					ContentTypes.APPLICATION_JSON, StringPool.UTF8);

				options.setLocation("https://account-d.docusign.com/oauth/token");
				options.setPost(true);

				String responseJSON = HttpUtil.URLtoString(options);

				JSONObject responseJSONObject = JSONFactoryUtil.createJSONObject(responseJSON);

				errorMessage = HtmlUtil.escapeJS(responseJSONObject.getString("message"));

				identificationToken = responseJSONObject.getString("access_token");

				_log.debug("Este é o TOKEN: " + identificationToken);

			}
			catch (Exception exception) {
				if (_log.isWarnEnabled()) {
					_log.warn(exception, exception);
				}
			}
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(
		DSEnvelopeManagerImpl.class);

}