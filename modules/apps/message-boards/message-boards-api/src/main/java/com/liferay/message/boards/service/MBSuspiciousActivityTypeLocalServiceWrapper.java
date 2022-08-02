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
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.change.tracking.CTPersistence;

/**
 * Provides a wrapper for {@link MBSuspiciousActivityTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityTypeLocalService
 * @generated
 */
public class MBSuspiciousActivityTypeLocalServiceWrapper
	implements MBSuspiciousActivityTypeLocalService,
			   ServiceWrapper<MBSuspiciousActivityTypeLocalService> {

	public MBSuspiciousActivityTypeLocalServiceWrapper() {
		this(null);
	}

	public MBSuspiciousActivityTypeLocalServiceWrapper(
		MBSuspiciousActivityTypeLocalService
			mbSuspiciousActivityTypeLocalService) {

		_mbSuspiciousActivityTypeLocalService =
			mbSuspiciousActivityTypeLocalService;
	}

	/**
	 * Adds the message boards suspicious activity type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MBSuspiciousActivityTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mbSuspiciousActivityType the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was added
	 */
	@Override
	public MBSuspiciousActivityType addMBSuspiciousActivityType(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		return _mbSuspiciousActivityTypeLocalService.
			addMBSuspiciousActivityType(mbSuspiciousActivityType);
	}

	@Override
	public MBSuspiciousActivityType addSuspiciousActivityType(
			String description, Long userId)
		throws Exception {

		return _mbSuspiciousActivityTypeLocalService.addSuspiciousActivityType(
			description, userId);
	}

	/**
	 * Creates a new message boards suspicious activity type with the primary key. Does not add the message boards suspicious activity type to the database.
	 *
	 * @param suspiciousActivityTypeId the primary key for the new message boards suspicious activity type
	 * @return the new message boards suspicious activity type
	 */
	@Override
	public MBSuspiciousActivityType createMBSuspiciousActivityType(
		long suspiciousActivityTypeId) {

		return _mbSuspiciousActivityTypeLocalService.
			createMBSuspiciousActivityType(suspiciousActivityTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbSuspiciousActivityTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the message boards suspicious activity type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MBSuspiciousActivityTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was removed
	 * @throws PortalException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType deleteMBSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbSuspiciousActivityTypeLocalService.
			deleteMBSuspiciousActivityType(suspiciousActivityTypeId);
	}

	/**
	 * Deletes the message boards suspicious activity type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MBSuspiciousActivityTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mbSuspiciousActivityType the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was removed
	 */
	@Override
	public MBSuspiciousActivityType deleteMBSuspiciousActivityType(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		return _mbSuspiciousActivityTypeLocalService.
			deleteMBSuspiciousActivityType(mbSuspiciousActivityType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbSuspiciousActivityTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public void deleteSuspiciousActivityType(long suspiciousActivityTypeId)
		throws Exception {

		_mbSuspiciousActivityTypeLocalService.deleteSuspiciousActivityType(
			suspiciousActivityTypeId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _mbSuspiciousActivityTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _mbSuspiciousActivityTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mbSuspiciousActivityTypeLocalService.dynamicQuery();
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

		return _mbSuspiciousActivityTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.message.boards.model.impl.MBSuspiciousActivityTypeModelImpl</code>.
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

		return _mbSuspiciousActivityTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.message.boards.model.impl.MBSuspiciousActivityTypeModelImpl</code>.
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

		return _mbSuspiciousActivityTypeLocalService.dynamicQuery(
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

		return _mbSuspiciousActivityTypeLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _mbSuspiciousActivityTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public MBSuspiciousActivityType fetchMBSuspiciousActivityType(
		long suspiciousActivityTypeId) {

		return _mbSuspiciousActivityTypeLocalService.
			fetchMBSuspiciousActivityType(suspiciousActivityTypeId);
	}

	/**
	 * Returns the message boards suspicious activity type matching the UUID and group.
	 *
	 * @param uuid the message boards suspicious activity type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType
		fetchMBSuspiciousActivityTypeByUuidAndGroupId(
			String uuid, long groupId) {

		return _mbSuspiciousActivityTypeLocalService.
			fetchMBSuspiciousActivityTypeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mbSuspiciousActivityTypeLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _mbSuspiciousActivityTypeLocalService.
			getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mbSuspiciousActivityTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type
	 * @throws PortalException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType getMBSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbSuspiciousActivityTypeLocalService.
			getMBSuspiciousActivityType(suspiciousActivityTypeId);
	}

	/**
	 * Returns the message boards suspicious activity type matching the UUID and group.
	 *
	 * @param uuid the message boards suspicious activity type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching message boards suspicious activity type
	 * @throws PortalException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType getMBSuspiciousActivityTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbSuspiciousActivityTypeLocalService.
			getMBSuspiciousActivityTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the message boards suspicious activity types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.message.boards.model.impl.MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @return the range of message boards suspicious activity types
	 */
	@Override
	public java.util.List<MBSuspiciousActivityType>
		getMBSuspiciousActivityTypes(int start, int end) {

		return _mbSuspiciousActivityTypeLocalService.
			getMBSuspiciousActivityTypes(start, end);
	}

	/**
	 * Returns all the message boards suspicious activity types matching the UUID and company.
	 *
	 * @param uuid the UUID of the message boards suspicious activity types
	 * @param companyId the primary key of the company
	 * @return the matching message boards suspicious activity types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<MBSuspiciousActivityType>
		getMBSuspiciousActivityTypesByUuidAndCompanyId(
			String uuid, long companyId) {

		return _mbSuspiciousActivityTypeLocalService.
			getMBSuspiciousActivityTypesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of message boards suspicious activity types matching the UUID and company.
	 *
	 * @param uuid the UUID of the message boards suspicious activity types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching message boards suspicious activity types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<MBSuspiciousActivityType>
		getMBSuspiciousActivityTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator) {

		return _mbSuspiciousActivityTypeLocalService.
			getMBSuspiciousActivityTypesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of message boards suspicious activity types.
	 *
	 * @return the number of message boards suspicious activity types
	 */
	@Override
	public int getMBSuspiciousActivityTypesCount() {
		return _mbSuspiciousActivityTypeLocalService.
			getMBSuspiciousActivityTypesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mbSuspiciousActivityTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mbSuspiciousActivityTypeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public MBSuspiciousActivityType getSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws Exception {

		return _mbSuspiciousActivityTypeLocalService.getSuspiciousActivityType(
			suspiciousActivityTypeId);
	}

	/**
	 * Updates the message boards suspicious activity type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MBSuspiciousActivityTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mbSuspiciousActivityType the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was updated
	 */
	@Override
	public MBSuspiciousActivityType updateMBSuspiciousActivityType(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		return _mbSuspiciousActivityTypeLocalService.
			updateMBSuspiciousActivityType(mbSuspiciousActivityType);
	}

	@Override
	public MBSuspiciousActivityType updateSuspiciousActivityType(
			long suspiciousActivityTypeId, String description)
		throws Exception {

		return _mbSuspiciousActivityTypeLocalService.
			updateSuspiciousActivityType(suspiciousActivityTypeId, description);
	}

	@Override
	public CTPersistence<MBSuspiciousActivityType> getCTPersistence() {
		return _mbSuspiciousActivityTypeLocalService.getCTPersistence();
	}

	@Override
	public Class<MBSuspiciousActivityType> getModelClass() {
		return _mbSuspiciousActivityTypeLocalService.getModelClass();
	}

	@Override
	public <R, E extends Throwable> R updateWithUnsafeFunction(
			UnsafeFunction<CTPersistence<MBSuspiciousActivityType>, R, E>
				updateUnsafeFunction)
		throws E {

		return _mbSuspiciousActivityTypeLocalService.updateWithUnsafeFunction(
			updateUnsafeFunction);
	}

	@Override
	public MBSuspiciousActivityTypeLocalService getWrappedService() {
		return _mbSuspiciousActivityTypeLocalService;
	}

	@Override
	public void setWrappedService(
		MBSuspiciousActivityTypeLocalService
			mbSuspiciousActivityTypeLocalService) {

		_mbSuspiciousActivityTypeLocalService =
			mbSuspiciousActivityTypeLocalService;
	}

	private MBSuspiciousActivityTypeLocalService
		_mbSuspiciousActivityTypeLocalService;

}