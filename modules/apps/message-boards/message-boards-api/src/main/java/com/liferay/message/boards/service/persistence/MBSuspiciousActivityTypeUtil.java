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

package com.liferay.message.boards.service.persistence;

import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the message boards suspicious activity type service. This utility wraps <code>com.liferay.message.boards.service.persistence.impl.MBSuspiciousActivityTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityTypePersistence
 * @generated
 */
public class MBSuspiciousActivityTypeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		getPersistence().clearCache(mbSuspiciousActivityType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MBSuspiciousActivityType>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MBSuspiciousActivityType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MBSuspiciousActivityType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MBSuspiciousActivityType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MBSuspiciousActivityType update(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		return getPersistence().update(mbSuspiciousActivityType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MBSuspiciousActivityType update(
		MBSuspiciousActivityType mbSuspiciousActivityType,
		ServiceContext serviceContext) {

		return getPersistence().update(
			mbSuspiciousActivityType, serviceContext);
	}

	/**
	 * Returns all the message boards suspicious activity types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the message boards suspicious activity types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @return the range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findByUuid_First(
			String uuid,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchByUuid_First(
		String uuid,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findByUuid_Last(
			String uuid,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchByUuid_Last(
		String uuid,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the message boards suspicious activity types before and after the current message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param suspiciousActivityTypeId the primary key of the current message boards suspicious activity type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public static MBSuspiciousActivityType[] findByUuid_PrevAndNext(
			long suspiciousActivityTypeId, String uuid,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			suspiciousActivityTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the message boards suspicious activity types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching message boards suspicious activity types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSuspiciousActivityTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findByUUID_G(
			String uuid, long groupId)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the message boards suspicious activity type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the message boards suspicious activity type that was removed
	 */
	public static MBSuspiciousActivityType removeByUUID_G(
			String uuid, long groupId)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching message boards suspicious activity types
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @return the range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the message boards suspicious activity types before and after the current message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the primary key of the current message boards suspicious activity type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public static MBSuspiciousActivityType[] findByUuid_C_PrevAndNext(
			long suspiciousActivityTypeId, String uuid, long companyId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			suspiciousActivityTypeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the message boards suspicious activity types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching message boards suspicious activity types
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @return the matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId) {

		return getPersistence().findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId);
	}

	/**
	 * Returns a range of all the message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @return the range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId, int start, int end) {

		return getPersistence().findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findBySuspiciousActivityTypeId_First(
			long suspiciousActivityTypeId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findBySuspiciousActivityTypeId_First(
			suspiciousActivityTypeId, orderByComparator);
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType
		fetchBySuspiciousActivityTypeId_First(
			long suspiciousActivityTypeId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().fetchBySuspiciousActivityTypeId_First(
			suspiciousActivityTypeId, orderByComparator);
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType findBySuspiciousActivityTypeId_Last(
			long suspiciousActivityTypeId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findBySuspiciousActivityTypeId_Last(
			suspiciousActivityTypeId, orderByComparator);
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public static MBSuspiciousActivityType fetchBySuspiciousActivityTypeId_Last(
		long suspiciousActivityTypeId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().fetchBySuspiciousActivityTypeId_Last(
			suspiciousActivityTypeId, orderByComparator);
	}

	/**
	 * Removes all the message boards suspicious activity types where suspiciousActivityTypeId = &#63; from the database.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 */
	public static void removeBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId) {

		getPersistence().removeBySuspiciousActivityTypeId(
			suspiciousActivityTypeId);
	}

	/**
	 * Returns the number of message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @return the number of matching message boards suspicious activity types
	 */
	public static int countBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId) {

		return getPersistence().countBySuspiciousActivityTypeId(
			suspiciousActivityTypeId);
	}

	/**
	 * Caches the message boards suspicious activity type in the entity cache if it is enabled.
	 *
	 * @param mbSuspiciousActivityType the message boards suspicious activity type
	 */
	public static void cacheResult(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		getPersistence().cacheResult(mbSuspiciousActivityType);
	}

	/**
	 * Caches the message boards suspicious activity types in the entity cache if it is enabled.
	 *
	 * @param mbSuspiciousActivityTypes the message boards suspicious activity types
	 */
	public static void cacheResult(
		List<MBSuspiciousActivityType> mbSuspiciousActivityTypes) {

		getPersistence().cacheResult(mbSuspiciousActivityTypes);
	}

	/**
	 * Creates a new message boards suspicious activity type with the primary key. Does not add the message boards suspicious activity type to the database.
	 *
	 * @param suspiciousActivityTypeId the primary key for the new message boards suspicious activity type
	 * @return the new message boards suspicious activity type
	 */
	public static MBSuspiciousActivityType create(
		long suspiciousActivityTypeId) {

		return getPersistence().create(suspiciousActivityTypeId);
	}

	/**
	 * Removes the message boards suspicious activity type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was removed
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public static MBSuspiciousActivityType remove(long suspiciousActivityTypeId)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().remove(suspiciousActivityTypeId);
	}

	public static MBSuspiciousActivityType updateImpl(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		return getPersistence().updateImpl(mbSuspiciousActivityType);
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key or throws a <code>NoSuchSuspiciousActivityTypeException</code> if it could not be found.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public static MBSuspiciousActivityType findByPrimaryKey(
			long suspiciousActivityTypeId)
		throws com.liferay.message.boards.exception.
			NoSuchSuspiciousActivityTypeException {

		return getPersistence().findByPrimaryKey(suspiciousActivityTypeId);
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type, or <code>null</code> if a message boards suspicious activity type with the primary key could not be found
	 */
	public static MBSuspiciousActivityType fetchByPrimaryKey(
		long suspiciousActivityTypeId) {

		return getPersistence().fetchByPrimaryKey(suspiciousActivityTypeId);
	}

	/**
	 * Returns all the message boards suspicious activity types.
	 *
	 * @return the message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the message boards suspicious activity types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @return the range of message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findAll(
		int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the message boards suspicious activity types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MBSuspiciousActivityTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards suspicious activity types
	 * @param end the upper bound of the range of message boards suspicious activity types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of message boards suspicious activity types
	 */
	public static List<MBSuspiciousActivityType> findAll(
		int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the message boards suspicious activity types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of message boards suspicious activity types.
	 *
	 * @return the number of message boards suspicious activity types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MBSuspiciousActivityTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MBSuspiciousActivityTypePersistence _persistence;

}