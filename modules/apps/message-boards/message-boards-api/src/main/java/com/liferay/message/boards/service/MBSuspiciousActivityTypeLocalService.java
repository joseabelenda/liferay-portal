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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.change.tracking.CTAware;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.change.tracking.CTService;
import com.liferay.portal.kernel.service.persistence.change.tracking.CTPersistence;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MBSuspiciousActivityType. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityTypeLocalServiceUtil
 * @generated
 */
@CTAware
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MBSuspiciousActivityTypeLocalService
	extends BaseLocalService, CTService<MBSuspiciousActivityType>,
			PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.message.boards.service.impl.MBSuspiciousActivityTypeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the message boards suspicious activity type local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MBSuspiciousActivityTypeLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public MBSuspiciousActivityType addMBSuspiciousActivityType(
		MBSuspiciousActivityType mbSuspiciousActivityType);

	public MBSuspiciousActivityType addSuspiciousActivityType(
			String description, Long userId)
		throws Exception;

	/**
	 * Creates a new message boards suspicious activity type with the primary key. Does not add the message boards suspicious activity type to the database.
	 *
	 * @param suspiciousActivityTypeId the primary key for the new message boards suspicious activity type
	 * @return the new message boards suspicious activity type
	 */
	@Transactional(enabled = false)
	public MBSuspiciousActivityType createMBSuspiciousActivityType(
		long suspiciousActivityTypeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public MBSuspiciousActivityType deleteMBSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public MBSuspiciousActivityType deleteMBSuspiciousActivityType(
		MBSuspiciousActivityType mbSuspiciousActivityType);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteSuspiciousActivityType(long suspiciousActivityTypeId)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MBSuspiciousActivityType fetchMBSuspiciousActivityType(
		long suspiciousActivityTypeId);

	/**
	 * Returns the message boards suspicious activity type matching the UUID and group.
	 *
	 * @param uuid the message boards suspicious activity type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MBSuspiciousActivityType
		fetchMBSuspiciousActivityTypeByUuidAndGroupId(
			String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the message boards suspicious activity type with the primary key.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type
	 * @throws PortalException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MBSuspiciousActivityType getMBSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws PortalException;

	/**
	 * Returns the message boards suspicious activity type matching the UUID and group.
	 *
	 * @param uuid the message boards suspicious activity type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching message boards suspicious activity type
	 * @throws PortalException if a matching message boards suspicious activity type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MBSuspiciousActivityType getMBSuspiciousActivityTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MBSuspiciousActivityType> getMBSuspiciousActivityTypes(
		int start, int end);

	/**
	 * Returns all the message boards suspicious activity types matching the UUID and company.
	 *
	 * @param uuid the UUID of the message boards suspicious activity types
	 * @param companyId the primary key of the company
	 * @return the matching message boards suspicious activity types, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MBSuspiciousActivityType>
		getMBSuspiciousActivityTypesByUuidAndCompanyId(
			String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MBSuspiciousActivityType>
		getMBSuspiciousActivityTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator);

	/**
	 * Returns the number of message boards suspicious activity types.
	 *
	 * @return the number of message boards suspicious activity types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMBSuspiciousActivityTypesCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MBSuspiciousActivityType getSuspiciousActivityType(
			long suspiciousActivityTypeId)
		throws Exception;

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
	@Indexable(type = IndexableType.REINDEX)
	public MBSuspiciousActivityType updateMBSuspiciousActivityType(
		MBSuspiciousActivityType mbSuspiciousActivityType);

	public MBSuspiciousActivityType updateSuspiciousActivityType(
			long suspiciousActivityTypeId, String description)
		throws Exception;

	@Override
	@Transactional(enabled = false)
	public CTPersistence<MBSuspiciousActivityType> getCTPersistence();

	@Override
	@Transactional(enabled = false)
	public Class<MBSuspiciousActivityType> getModelClass();

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public <R, E extends Throwable> R updateWithUnsafeFunction(
			UnsafeFunction<CTPersistence<MBSuspiciousActivityType>, R, E>
				updateUnsafeFunction)
		throws E;

}