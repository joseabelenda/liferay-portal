/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.learn;

import com.liferay.client.extension.util.spring.boot.BaseRestController;
import com.liferay.client.extension.util.spring.boot.LiferayOAuth2AccessTokenManager;

import java.nio.charset.Charset;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Nilton Vieira
 */
@Component
public class LearnCommandLineRunner
	extends BaseRestController implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		String dev = get(
			_liferayOAuth2AccessTokenManager.getAuthorization(
				"a7855d10-6a20-1f0e-7e21-53d8654a09d2"),
			"https://www-dev.liferay.com/o/headless-delivery/v1.0" +
				"/content-structures/2354659" +
					"/structured-contents?sort=dateModified:asc&pageSize=1");

		System.out.println("dev: " + dev);

		String prd = get(
			_getPRDOAuthAuthorization(),
			"https://www.liferay.com/o/headless-delivery/v1.0" +
				"/content-structures/2354659" +
					"/structured-contents?sort=dateModified:asc&pageSize=1");

		System.out.println("prd: " + prd);
	}

	@Override
	protected String getWebClientBaseURL() {
		return "";
	}

	private String _getPRDOAuthAuthorization() throws Exception {
		HttpPost httpPost = new HttpPost(
			"https://www.liferay.com/o/oauth2/token");

		httpPost.setEntity(
			new UrlEncodedFormEntity(
				Arrays.asList(
					new BasicNameValuePair(
						"client_id", "id-3776f94e-fe51-feca-fed8-2426609187"),
					new BasicNameValuePair(
						"client_secret",
						"secret-10a5e713-2426-7bda-04bd-930f44247ca"),
					new BasicNameValuePair(
						"grant_type", "client_credentials"))));
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		try (CloseableHttpClient closeableHttpClient =
				httpClientBuilder.build();
			CloseableHttpResponse closeableHttpResponse =
				closeableHttpClient.execute(httpPost)) {

			StatusLine statusLine = closeableHttpResponse.getStatusLine();

			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				JSONObject jsonObject = new JSONObject(
					EntityUtils.toString(
						closeableHttpResponse.getEntity(),
						Charset.defaultCharset()));

				_oauthExpirationMillis =
					jsonObject.getLong("expires_in") * 1000;

				return jsonObject.getString("token_type") + " " +
					jsonObject.getString("access_token");
			}

			throw new Exception("Unable to get OAuth authorization");
		}
	}

	@Autowired
	private LiferayOAuth2AccessTokenManager _liferayOAuth2AccessTokenManager;

	@Value("${liferay.oauth.application.external.reference.codes}")
	private String _liferayOAuthApplicationExternalReferenceCodes;

	private long _oauthExpirationMillis;

}