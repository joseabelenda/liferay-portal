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

package com.liferay.message.boards.service.impl;

import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.message.boards.service.base.MBSuspiciousActivityTypeServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.scripting.ExecutionException;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=mb",
		"json.web.service.context.path=MBSuspiciousActivityType"
	},
	service = AopService.class
)
public class MBSuspiciousActivityTypeServiceImpl
	extends MBSuspiciousActivityTypeServiceBaseImpl {



	@Override
	public MBSuspiciousActivityType addSuspiciousActivityType(
		String description)
		throws Exception{
			return mbSuspiciousActivityTypeLocalService.addSuspiciousActivityType(
				description,getUserId());
	}

	@Override
	public MBSuspiciousActivityType getSuspiciousActivityType(
		long suspiciousActivityTypeId)
		throws Exception{

		return mbSuspiciousActivityTypeLocalService.getSuspiciousActivityType(
			suspiciousActivityTypeId);

	}


	@Override
	public MBSuspiciousActivityType updateSuspiciousActivityType(
		long suspiciousActivityTypeId, String description
	)
	throws Exception {

		return mbSuspiciousActivityTypeLocalService.updateSuspiciousActivityType(
			suspiciousActivityTypeId, description);

		}


	@Override
	public void deleteSuspiciousActivityType(long suspiciousActivityTypeId)
	throws Exception{
		mbSuspiciousActivityTypeLocalService.deleteSuspiciousActivityType(
			suspiciousActivityTypeId);

	}

	}

