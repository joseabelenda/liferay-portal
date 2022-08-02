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

package com.liferay.message.boards.service;

import com.liferay.message.boards.model.MBSuspiciousActivityType;

/**
 * Provides the remote service utility for MBSuspiciousActivityType. This utility wraps
 * <code>com.liferay.message.boards.service.impl.MBSuspiciousActivityTypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityTypeService
 * @generated
 */
public class MBSuspiciousActivityTypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.message.boards.service.impl.MBSuspiciousActivityTypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MBSuspiciousActivityType addSuspiciousActivityType(
			String description)
		throws Exception {

		return getService().addSuspiciousActivityType(description);
	}

	public static void deleteSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws Exception {

		getService().deleteSuspiciousActivityType(suspiciousActivityTypeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MBSuspiciousActivityType getSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws Exception {

		return getService().getSuspiciousActivityType(suspiciousActivityTypeId);
	}

	public static MBSuspiciousActivityType updateSuspiciousActivityType(
			long suspiciousActivityTypeId, String description)
		throws Exception {

		return getService().updateSuspiciousActivityType(
			suspiciousActivityTypeId, description);
	}

	public static MBSuspiciousActivityTypeService getService() {
		return _service;
	}

	private static volatile MBSuspiciousActivityTypeService _service;

}