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

import com.liferay.message.boards.model.MBSuspiciousActivity;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.message.boards.service.base.MBSuspiciousActivityTypeLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.message.boards.model.MBSuspiciousActivityType",
	service = AopService.class
)
public class MBSuspiciousActivityTypeLocalServiceImpl
	extends MBSuspiciousActivityTypeLocalServiceBaseImpl {

	@Override
	public MBSuspiciousActivityType addSuspiciousActivityType(
		String description, Long userId)
		throws Exception{

		long suspiciousActivityTypeId = counterLocalService.increment();

		MBSuspiciousActivityType mbSuspiciousActivityType =
			mbSuspiciousActivityTypePersistence.create(suspiciousActivityTypeId);

		User user = _userLocalService.getUser(userId);

		mbSuspiciousActivityType.setCompanyId(user.getCompanyId());
		mbSuspiciousActivityType.setUserId(user.getUserId());
		mbSuspiciousActivityType.setUserName(user.getFullName());

		mbSuspiciousActivityType.setDescription(description);

		return mbSuspiciousActivityType;

	}

	@Override
	public MBSuspiciousActivityType getSuspiciousActivityType(
		long suspiciousActivityTypeId)
		throws Exception{

		return mbSuspiciousActivityTypePersistence.findByPrimaryKey(suspiciousActivityTypeId);

	}


	@Override
	public MBSuspiciousActivityType updateSuspiciousActivityType(long suspiciousActivityTypeId, String description)
		throws Exception{
		MBSuspiciousActivityType mbSuspiciousActivityType =
			mbSuspiciousActivityTypePersistence.findByPrimaryKey(
				suspiciousActivityTypeId);
		mbSuspiciousActivityType.setDescription(description);

		return mbSuspiciousActivityType;


	}

	@Override
	public void deleteSuspiciousActivityType(long suspiciousActivityTypeId)
		throws Exception{

			mbSuspiciousActivityTypePersistence.remove(suspiciousActivityTypeId);

	}


	@Reference
	private UserLocalService _userLocalService;
}