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

package com.liferay.click.to.chat.web.internal.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import java.nio.charset.StandardCharsets;

/**
 * @author Alejo Ceballos
 */
public class HubspotConnectionUtil {

	public static String fetchToken(User user, String hubSpotApiKey) {
		try {
			URL url = new URL(
				"https://api.hubspot.com/conversations/v3" +
					"/visitor-identification/tokens/create?hapikey=" +
						hubSpotApiKey);

			HttpURLConnection httpURLConnection =
				(HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod(HttpMethods.POST);
			httpURLConnection.setRequestProperty(
				HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
			httpURLConnection.setDoOutput(true);

			try (OutputStream requestOutputStream =
					httpURLConnection.getOutputStream()) {

				JSONObject requestJSONObject = JSONUtil.put(
					"email", user.getEmailAddress()
				).put(
					"firstName", user.getFirstName()
				).put(
					"lastName", user.getLastName()
				);

				byte[] jsonInput = requestJSONObject.toString(
				).getBytes(
					StandardCharsets.UTF_8
				);

				requestOutputStream.write(jsonInput, 0, jsonInput.length);
			}

			try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
						httpURLConnection.getInputStream(),
						StandardCharsets.UTF_8))) {

				StringBuilder responseStringBuilder = new StringBuilder();
				String responseLine;

				while ((responseLine = bufferedReader.readLine()) != null) {
					responseStringBuilder.append(responseLine.trim());
				}

				JSONObject responseJSONObject =
					JSONFactoryUtil.createJSONObject(
						responseStringBuilder.toString());

				return (String)responseJSONObject.get("token");
			}
		}
		catch (IOException | JSONException exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}

			throw new SystemException(exception);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		HubspotConnectionUtil.class);

}