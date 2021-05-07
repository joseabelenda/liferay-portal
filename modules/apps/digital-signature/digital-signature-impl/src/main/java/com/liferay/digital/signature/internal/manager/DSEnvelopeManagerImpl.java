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

import com.docusign.esign.client.ApiClient;
import com.liferay.digital.signature.manager.DSEnvelopeManager;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.util.HttpUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = DSEnvelopeManager.class)
public class DSEnvelopeManagerImpl implements DSEnvelopeManager {

	public void addDSEnvelope() {

		ApiClient apiClient = new ApiClient("account-d.docusign.com", "docusignAccessCode", "aa07ad8c-c09a-4c72-822b-ecfdc8ed8863", "549054fc-1016-4dcf-bfad-fe779294d762");
		String accessToken = apiClient.getAccessToken();
		System.out.println("accessToken: " + accessToken);


		if (_log.isDebugEnabled()) {
			_log.debug("Invoking #addDSEnvelope");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DSEnvelopeManagerImpl.class);

}