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

package com.liferay.dc.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsLocalService
 * @generated
 */
public class DocumentsLocalServiceWrapper
	implements DocumentsLocalService, ServiceWrapper<DocumentsLocalService> {

	public DocumentsLocalServiceWrapper() {
		this(null);
	}

	public DocumentsLocalServiceWrapper(
		DocumentsLocalService documentsLocalService) {

		_documentsLocalService = documentsLocalService;
	}

	@Override
	public com.liferay.dc.model.Documents addDocument(
			String name, String description, String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.addDocument(
			name, description, link, serviceContext);
	}

	/**
	 * Adds the documents to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documents the documents
	 * @return the documents that was added
	 */
	@Override
	public com.liferay.dc.model.Documents addDocuments(
		com.liferay.dc.model.Documents documents) {

		return _documentsLocalService.addDocuments(documents);
	}

	/**
	 * Creates a new documents with the primary key. Does not add the documents to the database.
	 *
	 * @param documentId the primary key for the new documents
	 * @return the new documents
	 */
	@Override
	public com.liferay.dc.model.Documents createDocuments(long documentId) {
		return _documentsLocalService.createDocuments(documentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.dc.model.Documents deleteDocument(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.deleteDocument(documentId);
	}

	/**
	 * Deletes the documents from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documents the documents
	 * @return the documents that was removed
	 */
	@Override
	public com.liferay.dc.model.Documents deleteDocuments(
		com.liferay.dc.model.Documents documents) {

		return _documentsLocalService.deleteDocuments(documents);
	}

	/**
	 * Deletes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents that was removed
	 * @throws PortalException if a documents with the primary key could not be found
	 */
	@Override
	public com.liferay.dc.model.Documents deleteDocuments(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.deleteDocuments(documentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _documentsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _documentsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _documentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.dc.model.impl.DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _documentsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.dc.model.impl.DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _documentsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _documentsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _documentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.dc.model.Documents fetchDocuments(long documentId) {
		return _documentsLocalService.fetchDocuments(documentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the documents with the primary key.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents
	 * @throws PortalException if a documents with the primary key could not be found
	 */
	@Override
	public com.liferay.dc.model.Documents getDocuments(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.getDocuments(documentId);
	}

	/**
	 * Returns a range of all the documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.dc.model.impl.DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of documentses
	 */
	@Override
	public java.util.List<com.liferay.dc.model.Documents> getDocumentses(
		int start, int end) {

		return _documentsLocalService.getDocumentses(start, end);
	}

	/**
	 * Returns the number of documentses.
	 *
	 * @return the number of documentses
	 */
	@Override
	public int getDocumentsesCount() {
		return _documentsLocalService.getDocumentsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.dc.model.Documents> listDocuments() {
		return _documentsLocalService.listDocuments();
	}

	@Override
	public com.liferay.dc.model.Documents updateDocument(
			long documentId, String name, String description, String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentsLocalService.updateDocument(
			documentId, name, description, link, serviceContext);
	}

	/**
	 * Updates the documents in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documents the documents
	 * @return the documents that was updated
	 */
	@Override
	public com.liferay.dc.model.Documents updateDocuments(
		com.liferay.dc.model.Documents documents) {

		return _documentsLocalService.updateDocuments(documents);
	}

	@Override
	public DocumentsLocalService getWrappedService() {
		return _documentsLocalService;
	}

	@Override
	public void setWrappedService(DocumentsLocalService documentsLocalService) {
		_documentsLocalService = documentsLocalService;
	}

	private DocumentsLocalService _documentsLocalService;

}