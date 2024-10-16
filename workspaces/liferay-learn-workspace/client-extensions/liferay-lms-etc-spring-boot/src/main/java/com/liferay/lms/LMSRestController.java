/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.lms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.liferay.lms.service.LearnService;

/**
 * @author José Abelenda
 */
@RequestMapping("/lms")
@RestController
public class LMSRestController extends BaseRestController {

	@GetMapping("/courses")
	public String getCourses() {
		JSONObject responseJSONObject = new JSONObject(
			WebClient.create(
				_lxcDXPServerProtocol + "://" + _lxcDXPMainDomain
			).get(
			).uri(
				"/o/c/courses/scopes/20117"
			).accept(
				MediaType.APPLICATION_JSON
			).header(
				HttpHeaders.AUTHORIZATION,
				"Bearer " + "xxx"
			).retrieve(
			).bodyToMono(
				String.class
			).block());

		if (_log.isInfoEnabled()) {
			_log.info(responseJSONObject.toString(4));
		}

		JSONArray itemsJSONArray = responseJSONObject.getJSONArray("items");

		System.out.println(itemsJSONArray);

		return "TEST";
	}

	@Value("${com.liferay.lxc.dxp.mainDomain}")
	private String _lxcDXPMainDomain;

	@Value("${com.liferay.lxc.dxp.server.protocol}")
	private String _lxcDXPServerProtocol;

	private static final Log _log = LogFactory.getLog(
		LMSRestController.class);

	@Autowired
	private LearnService _learnService;
}