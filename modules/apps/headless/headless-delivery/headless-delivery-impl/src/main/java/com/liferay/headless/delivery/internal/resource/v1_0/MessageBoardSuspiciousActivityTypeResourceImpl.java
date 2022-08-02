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

package com.liferay.headless.delivery.internal.resource.v1_0;

import com.liferay.headless.delivery.dto.v1_0.MessageBoardSuspiciousActivity;
import com.liferay.headless.delivery.dto.v1_0.MessageBoardSuspiciousActivityType;
import com.liferay.headless.delivery.internal.dto.v1_0.converter.MessageBoardSuspiciousActivityDTOConverter;
import com.liferay.headless.delivery.internal.dto.v1_0.converter.MessageBoardSuspiciousActivityTypeDTOConverter;
import com.liferay.headless.delivery.resource.v1_0.MessageBoardSuspiciousActivityTypeResource;

import com.liferay.message.boards.model.MBSuspiciousActivity;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.message.boards.service.MBSuspiciousActivityTypeService;
import com.liferay.portal.vulcan.dto.converter.DTOConverterRegistry;
import com.liferay.portal.vulcan.dto.converter.DefaultDTOConverterContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Gamarra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/message-board-suspicious-activity-type.properties",
	scope = ServiceScope.PROTOTYPE,
	service = MessageBoardSuspiciousActivityTypeResource.class
)
public class MessageBoardSuspiciousActivityTypeResourceImpl
	extends BaseMessageBoardSuspiciousActivityTypeResourceImpl {


	@Override
	public Page<MessageBoardSuspiciousActivityType> getMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage(
		Long suspiciousTypeId)
	throws Exception{
		List<MBSuspiciousActivityType> mbSuspiciousActivityType = new ArrayList<>();
		mbSuspiciousActivityType.add(_mbSuspiciousActivityTypeService.getSuspiciousActivityType(
			suspiciousTypeId));
		System.out.println("PASSOU AQUI!");

		return  Page.of(
			TransformUtil.transform(
				mbSuspiciousActivityType,
				this::_toMessageSuspiciousActivityType
			));
	}

	@Override
	public MessageBoardSuspiciousActivityType putMessageBoardSuspiciousActivityTypeMessageBoardSuspiciousActivityType(
		Long suspiciousTypeId, MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType)
	throws Exception{

		List<MBSuspiciousActivityType> mbSuspiciousActivityType = new ArrayList<>();

		mbSuspiciousActivityType.add(_mbSuspiciousActivityTypeService.updateSuspiciousActivityType(
			suspiciousTypeId,
			messageBoardSuspiciousActivityType.getDescription()));

		return TransformUtil.transform(
				mbSuspiciousActivityType,
				this::_toMessageSuspiciousActivityType
			).get(0);

	}

	@Override
	public void deleteMessageBoardSuspiciousActivityTypeMessageBoardSuspiciousActivityType(Long suspiciousTypeId)
		throws Exception{
			_mbSuspiciousActivityTypeService.deleteSuspiciousActivityType(suspiciousTypeId);
	}

	@Override
	public Page<MessageBoardSuspiciousActivityType> postMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage(MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType)
		throws Exception{
		List<MBSuspiciousActivityType> mbSuspiciousActivityType = new ArrayList<>();
		System.out.println("PASSOU AQUI");
		mbSuspiciousActivityType.add(_mbSuspiciousActivityTypeService.addSuspiciousActivityType(
			messageBoardSuspiciousActivityType.getDescription()));

		return  Page.of(
			TransformUtil.transform(
				mbSuspiciousActivityType,
				this::_toMessageSuspiciousActivityType
			));

	}




	private MessageBoardSuspiciousActivityType _toMessageSuspiciousActivityType(MBSuspiciousActivityType mbSuspiciousActivityType)
		throws Exception {


		return _messageBoardSuspiciousActivityTypeDTOConverter.toDTO(
			new DefaultDTOConverterContext(false,
				null,
				_dtoConverterRegistry, mbSuspiciousActivityType.getPrimaryKey(),
				contextAcceptLanguage.getPreferredLocale(), contextUriInfo,
				contextUser));
	}





@Reference
private MBSuspiciousActivityTypeService _mbSuspiciousActivityTypeService;

@Reference
private MessageBoardSuspiciousActivityTypeDTOConverter
	_messageBoardSuspiciousActivityTypeDTOConverter;

@Reference
private DTOConverterRegistry _dtoConverterRegistry;
}