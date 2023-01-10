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

package com.liferay.pblink.service.impl;

import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.pblink.service.base.PBLinkEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.pblink.model.PBLinkEntry",
	service = AopService.class
)
public class PBLinkEntryLocalServiceImpl
	extends PBLinkEntryLocalServiceBaseImpl {


	private void updateAsset(
		PBLinkEntry pbLinkEntry, ServiceContext serviceContext)
		throws PortalException {
		assetEntryLocalService.updateEntry(
			serviceContext.getUserId(), serviceContext.getScopeGroupId(),
			pbLinkEntry.getCreateDate(), pbLinkEntry.getModifiedDate(),
			PBLinkEntry.class.getName(), pbLinkEntry.getPbLinkEntryId(),
			pbLinkEntry.getUserUuid(), 0, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(), true, true,
			pbLinkEntry.getCreateDate(), null, null, null,
			ContentTypes.TEXT_HTML,
			pbLinkEntry.getName(),
			pbLinkEntry.getDescription(), null, pbLinkEntry.getLink(), null, 0, 0,
			serviceContext.getAssetPriority());
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PBLinkEntry addPBLinkEntry(String name, String description, String link, ServiceContext serviceContext) throws PortalException {
		long documentId = counterLocalService.increment();
		PBLinkEntry pbLinkEntry = pbLinkEntryPersistence.create(documentId);
		pbLinkEntry.setName(name);
		pbLinkEntry.setDescription(description);
		pbLinkEntry.setLink(link);

		updateAsset(pbLinkEntry, serviceContext);

		return pbLinkEntryPersistence.update(pbLinkEntry);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public PBLinkEntry deletePBLinkEntry(long documentId) throws PortalException {
		assetEntryLocalService.deleteEntry(PBLinkEntry.class.getName(), documentId);
		return pbLinkEntryPersistence.remove(documentId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PBLinkEntry updatePBLinkEntry(long pbLinkEntryId, String name, String description, String link, ServiceContext serviceContext) throws
		PortalException {

		PBLinkEntry pbLinkEntry = fetchPBLinkEntry(pbLinkEntryId);

		pbLinkEntry.setName(name);
		pbLinkEntry.setDescription(description);
		pbLinkEntry.setLink(link);

		updateAsset(pbLinkEntry, serviceContext);

		return pbLinkEntryPersistence.update(pbLinkEntry);
	}

	public List<PBLinkEntry> listPBLinkEntries(){
		List<PBLinkEntry> pbLinkEntry = pbLinkEntryPersistence.findAll();
		return pbLinkEntry;
	}
}