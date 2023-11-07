/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.sample;

import java.net.URI;

import java.util.function.Function;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

/**
 * @author José Abelenda
 */
@RequestMapping("/lug/order/status/update")
@RestController
public class ObjectAction1RestController extends BaseRestController {

	@PostMapping
	public ResponseEntity<String> post(
		@AuthenticationPrincipal Jwt jwt, @RequestBody String json) {

		JSONObject jsonObject = new JSONObject(json);

		long commerceOrderId = jsonObject.getLong("commerceOrderId");

		JSONObject commerceOrderItemsJSONObject = _getCommerceOrderItems(
			commerceOrderId, jwt);

		JSONArray orderItemsJSONArray =
			commerceOrderItemsJSONObject.getJSONArray("items");

		JSONObject commerceOrderJSONObject = jsonObject.getJSONObject(
			"commerceOrder");

		String creatorEmailAddress = commerceOrderJSONObject.getString(
			"creatorEmailAddress");

		if (orderItemsJSONArray != null) {
			JSONObject orderItemJSONObject = orderItemsJSONArray.getJSONObject(
				0);

			if (orderItemJSONObject != null) {
				String sku = orderItemJSONObject.getString("sku");

				if (sku != null) {
					System.out.println("\n\n\t\t*****SKU: " + sku);

					long organizationId = 0;

					if (sku.equals("BASIC")) {
						organizationId = _getOrganizationId("BASIC", jwt);
					}
					else if (sku.equals("PREMIUM")) {
						organizationId = _getOrganizationId("PREMIUM", jwt);
					}

					long finalOrganizationId = organizationId;

					_post(
						null, jwt,
						uriBuilder -> uriBuilder.path(
							"o/headless-admin-user/v1.0/organizations/" +
								finalOrganizationId +
									"/user-accounts/by-email-address/" +
										creatorEmailAddress
						).build());
				}
			}
		}

		return new ResponseEntity<>(json, HttpStatus.OK);
	}

	private JSONObject _get(Function<UriBuilder, URI> uriFunction, Jwt jwt) {
		return new JSONObject(
			_getWebClient(
			).get(
			).uri(
				uriBuilder -> uriFunction.apply(uriBuilder)
			).accept(
				MediaType.APPLICATION_JSON
			).header(
				HttpHeaders.AUTHORIZATION, "Bearer " + jwt.getTokenValue()
			).retrieve(
			).bodyToMono(
				String.class
			).block());
	}

	private JSONObject _getCommerceOrderItems(long commerceOrderId, Jwt jwt) {
		return _get(
			uriBuilder -> uriBuilder.path(
				"/o/headless-commerce-admin-order/v1.0/orders/" +
					commerceOrderId + "/orderItems"
			).queryParam(
				"page", "1"
			).queryParam(
				"pageSize", "-1"
			).build(),
			jwt);
	}

	private long _getOrganizationId(String externalReferenceCode, Jwt jwt) {
		JSONObject jsonObject = _get(
			uriBuilder -> uriBuilder.path(
				"/o/headless-admin-user/v1.0/organizations/by-external-reference-code/" +
					externalReferenceCode
			).queryParam(
				"page", "1"
			).queryParam(
				"pageSize", "-1"
			).build(),
			jwt);

		return jsonObject.getLong("id");
	}

	private WebClient _getWebClient() {
		return WebClient.builder(
		).baseUrl(
			lxcDXPServerProtocol + "://" + lxcDXPMainDomain
		).exchangeStrategies(
			ExchangeStrategies.builder(
			).codecs(
				clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs(
				).maxInMemorySize(
					5 * 1024 * 1024
				)
			).build()
		).build();
	}

	private void _post(
		Object bodyValue, Jwt jwt, Function<UriBuilder, URI> uriFunction) {

		_getWebClient(
		).post(
		).uri(
			uriBuilder -> uriFunction.apply(uriBuilder)
		).accept(
			MediaType.APPLICATION_JSON
		).contentType(
			MediaType.APPLICATION_JSON
		).header(
			HttpHeaders.AUTHORIZATION, "Bearer " + jwt.getTokenValue()
		).retrieve(
		).bodyToMono(
			Void.class
		).block();
	}

	private static final Log _log = LogFactory.getLog(
		ObjectAction1RestController.class);

}