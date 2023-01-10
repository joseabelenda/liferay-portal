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

package com.liferay.pblink.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PBLinkEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PBLinkEntryLocalService
 * @generated
 */
public class PBLinkEntryLocalServiceWrapper
	implements PBLinkEntryLocalService,
			   ServiceWrapper<PBLinkEntryLocalService> {

	public PBLinkEntryLocalServiceWrapper() {
		this(null);
	}

	public PBLinkEntryLocalServiceWrapper(
		PBLinkEntryLocalService pbLinkEntryLocalService) {

		_pbLinkEntryLocalService = pbLinkEntryLocalService;
	}

	/**
	 * Adds the pb link entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PBLinkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pbLinkEntry the pb link entry
	 * @return the pb link entry that was added
	 */
	@Override
	public com.liferay.pblink.model.PBLinkEntry addPBLinkEntry(
		com.liferay.pblink.model.PBLinkEntry pbLinkEntry) {

		return _pbLinkEntryLocalService.addPBLinkEntry(pbLinkEntry);
	}

	@Override
	public com.liferay.pblink.model.PBLinkEntry addPBLinkEntry(
			String name, String description, String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.addPBLinkEntry(
			name, description, link, serviceContext);
	}

	/**
	 * Creates a new pb link entry with the primary key. Does not add the pb link entry to the database.
	 *
	 * @param pbLinkEntryId the primary key for the new pb link entry
	 * @return the new pb link entry
	 */
	@Override
	public com.liferay.pblink.model.PBLinkEntry createPBLinkEntry(
		long pbLinkEntryId) {

		return _pbLinkEntryLocalService.createPBLinkEntry(pbLinkEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pb link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PBLinkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry that was removed
	 * @throws PortalException if a pb link entry with the primary key could not be found
	 */
	@Override
	public com.liferay.pblink.model.PBLinkEntry deletePBLinkEntry(
			long pbLinkEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.deletePBLinkEntry(pbLinkEntryId);
	}

	/**
	 * Deletes the pb link entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PBLinkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pbLinkEntry the pb link entry
	 * @return the pb link entry that was removed
	 */
	@Override
	public com.liferay.pblink.model.PBLinkEntry deletePBLinkEntry(
		com.liferay.pblink.model.PBLinkEntry pbLinkEntry) {

		return _pbLinkEntryLocalService.deletePBLinkEntry(pbLinkEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _pbLinkEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _pbLinkEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pbLinkEntryLocalService.dynamicQuery();
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

		return _pbLinkEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.pblink.model.impl.PBLinkEntryModelImpl</code>.
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

		return _pbLinkEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.pblink.model.impl.PBLinkEntryModelImpl</code>.
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

		return _pbLinkEntryLocalService.dynamicQuery(
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

		return _pbLinkEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pbLinkEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.pblink.model.PBLinkEntry fetchPBLinkEntry(
		long pbLinkEntryId) {

		return _pbLinkEntryLocalService.fetchPBLinkEntry(pbLinkEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pbLinkEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pbLinkEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pbLinkEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the pb link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.pblink.model.impl.PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @return the range of pb link entries
	 */
	@Override
	public java.util.List<com.liferay.pblink.model.PBLinkEntry>
		getPBLinkEntries(int start, int end) {

		return _pbLinkEntryLocalService.getPBLinkEntries(start, end);
	}

	/**
	 * Returns the number of pb link entries.
	 *
	 * @return the number of pb link entries
	 */
	@Override
	public int getPBLinkEntriesCount() {
		return _pbLinkEntryLocalService.getPBLinkEntriesCount();
	}

	/**
	 * Returns the pb link entry with the primary key.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry
	 * @throws PortalException if a pb link entry with the primary key could not be found
	 */
	@Override
	public com.liferay.pblink.model.PBLinkEntry getPBLinkEntry(
			long pbLinkEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.getPBLinkEntry(pbLinkEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.pblink.model.PBLinkEntry>
		listPBLinkEntries() {

		return _pbLinkEntryLocalService.listPBLinkEntries();
	}

	@Override
	public com.liferay.pblink.model.PBLinkEntry updatePBLinkEntry(
			long pbLinkEntryId, String name, String description, String link,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pbLinkEntryLocalService.updatePBLinkEntry(
			pbLinkEntryId, name, description, link, serviceContext);
	}

	/**
	 * Updates the pb link entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PBLinkEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pbLinkEntry the pb link entry
	 * @return the pb link entry that was updated
	 */
	@Override
	public com.liferay.pblink.model.PBLinkEntry updatePBLinkEntry(
		com.liferay.pblink.model.PBLinkEntry pbLinkEntry) {

		return _pbLinkEntryLocalService.updatePBLinkEntry(pbLinkEntry);
	}

	@Override
	public PBLinkEntryLocalService getWrappedService() {
		return _pbLinkEntryLocalService;
	}

	@Override
	public void setWrappedService(
		PBLinkEntryLocalService pbLinkEntryLocalService) {

		_pbLinkEntryLocalService = pbLinkEntryLocalService;
	}

	private PBLinkEntryLocalService _pbLinkEntryLocalService;

}