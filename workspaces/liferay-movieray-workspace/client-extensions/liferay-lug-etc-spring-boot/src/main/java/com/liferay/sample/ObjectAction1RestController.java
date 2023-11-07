/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.sample;

import com.liferay.petra.string.StringBundler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author José Abelenda
 */
@RequestMapping("/lug/order/status/update")
@RestController
public class ObjectAction1RestController extends BaseRestController {

	@PostMapping
	public ResponseEntity<String> post(
			@AuthenticationPrincipal Jwt jwt, @RequestBody String json) {

		// System.out.println("post");

		JSONObject jsonObject = new JSONObject(json);

		JSONObject commerceOrderJSONObject = jsonObject.getJSONObject("commerceOrder");

		System.out.println("commerceOrderJSONObject: " + commerceOrderJSONObject);

		long accountId = commerceOrderJSONObject.getLong("accountId");

		System.out.println("accountId: " + accountId);

		JSONArray orderItemsJSONArray = commerceOrderJSONObject.getJSONArray("orderItems");

		if (orderItemsJSONArray != null) {
			JSONObject orderItemJSONObject = orderItemsJSONArray.getJSONObject(0);

			if (orderItemJSONObject != null) {
				String sku = orderItemJSONObject.getString("sku");

				if (sku != null) {
					System.out.println("\n\n\t\t*****SKU: " + sku);

					WebClient.Builder builder = WebClient.builder();

					WebClient webClient = builder.baseUrl(
							lxcDXPServerProtocol + "://" + lxcDXPMainDomain).defaultHeader(
									HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
							.defaultHeader(
									HttpHeaders.AUTHORIZATION, "Bearer " + jwt.getTokenValue())
							.defaultHeader(
									HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
							.build();

					long organizationId = 0;

					if (sku.equals("BASIC")) {
						organizationId = 33420;
					} else if (sku.equals("PREMIUM")) {
						organizationId = 33414;

					}

					webClient.post().uri(
							"o/headless-admin-user/v1.0/accounts/" + accountId + "/organizations/" + organizationId);
				}
			}

		}

		return new ResponseEntity<>(json, HttpStatus.OK);
	}

	private static final Log _log = LogFactory.getLog(
			ObjectAction1RestController.class);

}