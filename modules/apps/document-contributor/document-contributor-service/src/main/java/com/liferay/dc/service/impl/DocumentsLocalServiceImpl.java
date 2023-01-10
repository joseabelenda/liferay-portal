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

package com.liferay.dc.service.impl;

import com.liferay.dc.service.base.DocumentsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;
import com.liferay.dc.model.Documents;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.dc.model.Documents",
	service = AopService.class
)
public class DocumentsLocalServiceImpl extends DocumentsLocalServiceBaseImpl {

	private void updateAsset(
		Documents documents, ServiceContext serviceContext)
		throws PortalException {
		assetEntryLocalService.updateEntry(
			serviceContext.getUserId(), serviceContext.getScopeGroupId(),
			documents.getCreateDate(), documents.getModifiedDate(),
			Documents.class.getName(), documents.getDocumentId(),
			documents.getUserUuid(), 0, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(), true, true,
			documents.getCreateDate(), null, null, null,
			ContentTypes.TEXT_HTML,
			documents.getName(),
			documents.getDescription(), null, documents.getLink(), null, 0, 0,
			serviceContext.getAssetPriority());
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Documents addDocument(String name, String description, String link, ServiceContext serviceContext) throws PortalException {
		long documentId = counterLocalService.increment();
		Documents documents = documentsPersistence.create(documentId);
		documents.setName(name);
		documents.setDescription(description);
		documents.setLink(link);

		updateAsset(documents, serviceContext);

		return documentsPersistence.update(documents);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Documents deleteDocument(long documentId) throws PortalException {
		assetEntryLocalService.deleteEntry(Documents.class.getName(), documentId);
		return documentsPersistence.remove(documentId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Documents updateDocument(long documentId, String name, String description, String link, ServiceContext serviceContext) throws PortalException {

		Documents documents = fetchDocuments(documentId);

		documents.setName(name);
		documents.setDescription(description);
		documents.setLink(link);

		updateAsset(documents, serviceContext);

		return documentsPersistence.update(documents);
	}

	public List<Documents> listDocuments(){
		List<Documents> documents = documentsPersistence.findAll();
		return documents;
	}
}
