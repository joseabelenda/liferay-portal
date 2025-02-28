/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.learn;

import com.liferay.client.extension.util.spring.boot.BaseRestController;
import com.liferay.client.extension.util.spring.boot.LiferayOAuth2AccessTokenManager;

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
//		String dev = get(
//				_liferayOAuth2AccessTokenManager.getAuthorization(
//						"a7855d10-6a20-1f0e-7e21-53d8654a09d2"),
//				"https://www-dev.liferay.com/o/headless-delivery/v1.0/content-structures/2354659/" +
//						"structured-contents?sort=dateModified:asc&pageSize=1");
//
//		System.out.println("dev: " + dev);

		String prd = get(
				_liferayOAuth2AccessTokenManager.getAuthorization(
						"9fc0c45b-d42f-1fcd-09c3-a4b8e6ec4268"),
				"https://www.liferay.com/o/headless-delivery/v1.0/content-structures/2354659/" +
						"structured-contents?sort=dateModified:asc&pageSize=1");

		System.out.println("prd: " + prd);
	}
	

	@Autowired
	private LiferayOAuth2AccessTokenManager _liferayOAuth2AccessTokenManager;

	@Value("${liferay.oauth.application.external.reference.codes}")
	private String _liferayOAuthApplicationExternalReferenceCodes;

	@Override
	protected String getWebClientBaseURL() {
		return "";
	}
}