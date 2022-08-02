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
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MBSuspiciousActivityTypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityTypeService
 * @generated
 */
public class MBSuspiciousActivityTypeServiceWrapper
	implements MBSuspiciousActivityTypeService,
			   ServiceWrapper<MBSuspiciousActivityTypeService> {

	public MBSuspiciousActivityTypeServiceWrapper() {
		this(null);
	}

	public MBSuspiciousActivityTypeServiceWrapper(
		MBSuspiciousActivityTypeService mbSuspiciousActivityTypeService) {

		_mbSuspiciousActivityTypeService = mbSuspiciousActivityTypeService;
	}

	@Override
	public MBSuspiciousActivityType addSuspiciousActivityType(
			String description)
		throws Exception {

		return _mbSuspiciousActivityTypeService.addSuspiciousActivityType(
			description);
	}

	@Override
	public void deleteSuspiciousActivityType(long suspiciousActivityTypeId)
		throws Exception {

		_mbSuspiciousActivityTypeService.deleteSuspiciousActivityType(
			suspiciousActivityTypeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mbSuspiciousActivityTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public MBSuspiciousActivityType getSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws Exception {

		return _mbSuspiciousActivityTypeService.getSuspiciousActivityType(
			suspiciousActivityTypeId);
	}

	@Override
	public MBSuspiciousActivityType updateSuspiciousActivityType(
			long suspiciousActivityTypeId, String description)
		throws Exception {

		return _mbSuspiciousActivityTypeService.updateSuspiciousActivityType(
			suspiciousActivityTypeId, description);
	}

	@Override
	public MBSuspiciousActivityTypeService getWrappedService() {
		return _mbSuspiciousActivityTypeService;
	}

	@Override
	public void setWrappedService(
		MBSuspiciousActivityTypeService mbSuspiciousActivityTypeService) {

		_mbSuspiciousActivityTypeService = mbSuspiciousActivityTypeService;
	}

	private MBSuspiciousActivityTypeService _mbSuspiciousActivityTypeService;

}