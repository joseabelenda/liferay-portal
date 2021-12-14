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

package com.liferay.webhook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liferay.digital.signature.rest.client.resource.v1_0.DSEnvelopeResource;
import com.liferay.digital.signature.rest.client.dto.v1_0.DSEnvelope;


import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.headless.delivery.client.resource.v1_0.DocumentResource;
import com.liferay.headless.delivery.client.dto.v1_0.Document;

import com.liferay.headless.delivery.client.pagination.Page;
import com.liferay.headless.delivery.client.pagination.Pagination;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Base64;
import java.net.URL;

import java.io.InputStream;

/**
 * @author Nícolas Moura
 */
@RequestMapping("/raylife")
@RestController
public class RaylifeWebhookRestController {

	@GetMapping("{value}")
	public String getValue(@PathVariable(required = false) String value) {

		return value;
	}

	@PostMapping("{siteId}")
	public void postValue(@PathVariable(required = true) Long siteId, @RequestBody String body) {
		try {
			DSEnvelopeResource dsEnvelopeResource = DSEnvelopeResource.builder(
			).authentication(
				"test@liferay.com", "test"
			).endpoint(
				"localhost", 8080, "http"
			).build();

			DSEnvelope dsEnvelope = DSEnvelope.toDTO(body);

			dsEnvelopeResource.postSiteDSEnvelope(siteId, dsEnvelope);
		}
		catch (Exception exception) {
			_log.info("Exception: " + exception);
		}
	}

	private static final Log _log = LogFactory.getLog(
		RaylifeWebhookRestController.class);
}