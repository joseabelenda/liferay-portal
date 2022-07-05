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

import com.liferay.headless.delivery.dto.v1_0.Field;
import com.liferay.headless.delivery.dto.v1_0.MessageBoardSuspiciousActivity;
import com.liferay.headless.delivery.internal.dto.v1_0.converter.MessageBoardSuspiciousActivityDTOConverter;
import com.liferay.headless.delivery.resource.v1_0.MessageBoardSuspiciousActivityResource;

import com.liferay.message.boards.constants.MBConstants;
import com.liferay.message.boards.model.MBSuspiciousActivity;
import com.liferay.message.boards.service.MBSuspiciousActivityLocalService;
import com.liferay.message.boards.service.MBSuspiciousActivityService;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.vulcan.aggregation.Aggregation;
import com.liferay.portal.vulcan.dto.converter.DTOConverterRegistry;
import com.liferay.portal.vulcan.dto.converter.DefaultDTOConverterContext;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Javier Gamarra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/message-board-suspicious-activity.properties",
	scope = ServiceScope.PROTOTYPE,
	service = MessageBoardSuspiciousActivityResource.class
)
public class MessageBoardSuspiciousActivityResourceImpl
	extends BaseMessageBoardSuspiciousActivityResourceImpl {



	@Override
	public Page<MessageBoardSuspiciousActivity> getMessageBoardThreadMessageBoardSuspiciousActivityPage(
		Long messageBoardThreadId, String search, Aggregation aggregation,
		Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception{

		List<MBSuspiciousActivity> dados = _mbSuspiciousActivityService.getThreadSuspiciousActivities(messageBoardThreadId);


		Page teste = Page.of(TransformUtil.transform(dados,this::_toMessageSuspiciousActivity));


		return teste;
	}

	@Override
	public Page<MessageBoardSuspiciousActivity> getMessageBoardMessageMessageBoardSuspiciousActivityPage(
		Long messageBoardMessageId, String search, Aggregation aggregation,
		Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception{

		List<MBSuspiciousActivity> dados = _mbSuspiciousActivityService.getMessageSuspiciousActivities(messageBoardMessageId);


		Page teste = Page.of(TransformUtil.transform(dados,this::_toMessageSuspiciousActivity));


		return teste;
	}

//  @Override
//  public MessageBoardSuspiciousActivity postMessageBoardMessageMessageBoardSuspiciousActivityPage()
//      throws Exception{
//
//
//  }
//
//  @Override
//  public MessageBoardSuspiciousActivity postMessageBoardThreadMessageBoardSuspiciousActivity()
//      throws Exception{
//
//
//
//  }


//  public Page<MessageBoardSuspiciousActivity> getMessageBoardSuspiciousActivitiesMessageBoardSuspiciousActivityPage(
//      Long messageBoardSuspiciousActivityId, String search, Aggregation aggregation,
//      Filter filter, Pagination pagination, Sort[] sorts)
//      throws Exception{
//
//      ArrayList<MBSuspiciousActivity > dados = new ArrayList<>();
//      MBSuspiciousActivity data = _mbSuspiciousActivityService.getSuspiciousActivity(messageBoardSuspiciousActivityId);
//      System.out.println(data);
//      dados.add(data);
//      System.out.println(dados);
//      Page teste = Page.of(TransformUtil.transform(dados,this::_toMessageSuspiciousActivity));
//
//
//      return teste;
//  }

	private MessageBoardSuspiciousActivity _toMessageSuspiciousActivity(MBSuspiciousActivity mbSuspiciousActivity)
		throws Exception {


		return _messageBoardSuspiciousActivityDTOConverter.toDTO(
			new DefaultDTOConverterContext(false,
				HashMapBuilder.put(
					"delete",
					addAction(
						ActionKeys.DELETE, mbSuspiciousActivity,
						"deleteMessageBoardSuspiciousActivity")
				).put(
					"get",
					addAction(
						ActionKeys.VIEW, mbSuspiciousActivity, "getMessageBoardSuspiciousActivity")
				).put(
					"replace",
					addAction(
						ActionKeys.UPDATE, mbSuspiciousActivity, "putMessageBoardSuspiciousActivity")
				).put(
					"update",
					addAction(
						ActionKeys.UPDATE, mbSuspiciousActivity,
						"patchMessageBoardSuspiciousActivity")
				).build(),
				_dtoConverterRegistry, mbSuspiciousActivity.getPrimaryKey(),
				contextAcceptLanguage.getPreferredLocale(), contextUriInfo,
				contextUser));
	}
	@Reference
	private MBSuspiciousActivityService _mbSuspiciousActivityService;


	@Reference
	private MessageBoardSuspiciousActivityDTOConverter
		_messageBoardSuspiciousActivityDTOConverter;

	@Reference
	private DTOConverterRegistry _dtoConverterRegistry;

}