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

import com.liferay.message.boards.exception.NoSuchSuspiciousActivityTypeException;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.change.tracking.CTPersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the message boards suspicious activity type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityTypeUtil
 * @generated
 */
@ProviderType
public interface MBSuspiciousActivityTypePersistence
	extends BasePersistence<MBSuspiciousActivityType>,
			CTPersistence<MBSuspiciousActivityType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MBSuspiciousActivityTypeUtil} to access the message boards suspicious activity type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the message boards suspicious activity types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching message boards suspicious activity types
	 */
	public java.util.List<MBSuspiciousActivityType> findByUuid(String uuid);

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
	public java.util.List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

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
	public java.util.List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

	/**
	 * Returns the message boards suspicious activity types before and after the current message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param suspiciousActivityTypeId the primary key of the current message boards suspicious activity type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public MBSuspiciousActivityType[] findByUuid_PrevAndNext(
			long suspiciousActivityTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Removes all the message boards suspicious activity types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching message boards suspicious activity types
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSuspiciousActivityTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findByUUID_G(String uuid, long groupId)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the message boards suspicious activity type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the message boards suspicious activity type that was removed
	 */
	public MBSuspiciousActivityType removeByUUID_G(String uuid, long groupId)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching message boards suspicious activity types
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching message boards suspicious activity types
	 */
	public java.util.List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

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
	public java.util.List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

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
	public MBSuspiciousActivityType[] findByUuid_C_PrevAndNext(
			long suspiciousActivityTypeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Removes all the message boards suspicious activity types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching message boards suspicious activity types
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @return the matching message boards suspicious activity types
	 */
	public java.util.List<MBSuspiciousActivityType>
		findBySuspiciousActivityTypeId(long suspiciousActivityTypeId);

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
	public java.util.List<MBSuspiciousActivityType>
		findBySuspiciousActivityTypeId(
			long suspiciousActivityTypeId, int start, int end);

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
	public java.util.List<MBSuspiciousActivityType>
		findBySuspiciousActivityTypeId(
			long suspiciousActivityTypeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator);

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
	public java.util.List<MBSuspiciousActivityType>
		findBySuspiciousActivityTypeId(
			long suspiciousActivityTypeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findBySuspiciousActivityTypeId_First(
			long suspiciousActivityTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchBySuspiciousActivityTypeId_First(
		long suspiciousActivityTypeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType findBySuspiciousActivityTypeId_Last(
			long suspiciousActivityTypeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	public MBSuspiciousActivityType fetchBySuspiciousActivityTypeId_Last(
		long suspiciousActivityTypeId,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

	/**
	 * Removes all the message boards suspicious activity types where suspiciousActivityTypeId = &#63; from the database.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 */
	public void removeBySuspiciousActivityTypeId(long suspiciousActivityTypeId);

	/**
	 * Returns the number of message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @return the number of matching message boards suspicious activity types
	 */
	public int countBySuspiciousActivityTypeId(long suspiciousActivityTypeId);

	/**
	 * Caches the message boards suspicious activity type in the entity cache if it is enabled.
	 *
	 * @param mbSuspiciousActivityType the message boards suspicious activity type
	 */
	public void cacheResult(MBSuspiciousActivityType mbSuspiciousActivityType);

	/**
	 * Caches the message boards suspicious activity types in the entity cache if it is enabled.
	 *
	 * @param mbSuspiciousActivityTypes the message boards suspicious activity types
	 */
	public void cacheResult(
		java.util.List<MBSuspiciousActivityType> mbSuspiciousActivityTypes);

	/**
	 * Creates a new message boards suspicious activity type with the primary key. Does not add the message boards suspicious activity type to the database.
	 *
	 * @param suspiciousActivityTypeId the primary key for the new message boards suspicious activity type
	 * @return the new message boards suspicious activity type
	 */
	public MBSuspiciousActivityType create(long suspiciousActivityTypeId);

	/**
	 * Removes the message boards suspicious activity type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was removed
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public MBSuspiciousActivityType remove(long suspiciousActivityTypeId)
		throws NoSuchSuspiciousActivityTypeException;

	public MBSuspiciousActivityType updateImpl(
		MBSuspiciousActivityType mbSuspiciousActivityType);

	/**
	 * Returns the message boards suspicious activity type with the primary key or throws a <code>NoSuchSuspiciousActivityTypeException</code> if it could not be found.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	public MBSuspiciousActivityType findByPrimaryKey(
			long suspiciousActivityTypeId)
		throws NoSuchSuspiciousActivityTypeException;

	/**
	 * Returns the message boards suspicious activity type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type, or <code>null</code> if a message boards suspicious activity type with the primary key could not be found
	 */
	public MBSuspiciousActivityType fetchByPrimaryKey(
		long suspiciousActivityTypeId);

	/**
	 * Returns all the message boards suspicious activity types.
	 *
	 * @return the message boards suspicious activity types
	 */
	public java.util.List<MBSuspiciousActivityType> findAll();

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
	public java.util.List<MBSuspiciousActivityType> findAll(int start, int end);

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
	public java.util.List<MBSuspiciousActivityType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator);

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
	public java.util.List<MBSuspiciousActivityType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the message boards suspicious activity types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of message boards suspicious activity types.
	 *
	 * @return the number of message boards suspicious activity types
	 */
	public int countAll();

}