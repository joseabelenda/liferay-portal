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
import com.liferay.dc.service.persistence.DocumentsPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import org.osgi.service.component.annotations.Component;
import com.liferay.dc.model.Documents;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.dc.model.Documents",
	service = AopService.class
)
public class DocumentsLocalServiceImpl extends DocumentsLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Documents addDocument(String name, String description, String link) throws PortalException {
		long documentId = counterLocalService.increment(Documents.class.getName());

		Documents documents = createDocuments(documentId);
		documents.setName(name);
		documents.setDescription(description);
		documents.setLink(link);

		return _documentsPersistence.update(documents);
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public Documents deleteDocument(long documentId) throws PortalException {
		return _documentsPersistence.remove(documentId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Documents updateDocument(long documentId, String name, String description, String link) {

		Documents documents = fetchDocuments(documentId);

		documents.setName(name);
		documents.setDescription(description);
		documents.setLink(link);

		return _documentsPersistence.update(documents);
	}

	protected DocumentsPersistence _documentsPersistence;
}