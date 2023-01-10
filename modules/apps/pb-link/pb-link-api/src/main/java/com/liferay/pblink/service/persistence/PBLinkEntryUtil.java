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

package com.liferay.pblink.service.persistence;

import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pb link entry service. This utility wraps <code>com.liferay.pblink.service.persistence.impl.PBLinkEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PBLinkEntryPersistence
 * @generated
 */
public class PBLinkEntryUtil {

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
	public static void clearCache(PBLinkEntry pbLinkEntry) {
		getPersistence().clearCache(pbLinkEntry);
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
	public static Map<Serializable, PBLinkEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PBLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PBLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PBLinkEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PBLinkEntry update(PBLinkEntry pbLinkEntry) {
		return getPersistence().update(pbLinkEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PBLinkEntry update(
		PBLinkEntry pbLinkEntry, ServiceContext serviceContext) {

		return getPersistence().update(pbLinkEntry, serviceContext);
	}

	/**
	 * Returns all the pb link entries where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @return the matching pb link entries
	 */
	public static List<PBLinkEntry> findBypbLinkEntryId(long pbLinkEntryId) {
		return getPersistence().findBypbLinkEntryId(pbLinkEntryId);
	}

	/**
	 * Returns a range of all the pb link entries where pbLinkEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @return the range of matching pb link entries
	 */
	public static List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end) {

		return getPersistence().findBypbLinkEntryId(pbLinkEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the pb link entries where pbLinkEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().findBypbLinkEntryId(
			pbLinkEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pb link entries where pbLinkEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypbLinkEntryId(
			pbLinkEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findBypbLinkEntryId_First(
			long pbLinkEntryId,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findBypbLinkEntryId_First(
			pbLinkEntryId, orderByComparator);
	}

	/**
	 * Returns the first pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchBypbLinkEntryId_First(
		long pbLinkEntryId, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchBypbLinkEntryId_First(
			pbLinkEntryId, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findBypbLinkEntryId_Last(
			long pbLinkEntryId,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findBypbLinkEntryId_Last(
			pbLinkEntryId, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchBypbLinkEntryId_Last(
		long pbLinkEntryId, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchBypbLinkEntryId_Last(
			pbLinkEntryId, orderByComparator);
	}

	/**
	 * Removes all the pb link entries where pbLinkEntryId = &#63; from the database.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 */
	public static void removeBypbLinkEntryId(long pbLinkEntryId) {
		getPersistence().removeBypbLinkEntryId(pbLinkEntryId);
	}

	/**
	 * Returns the number of pb link entries where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @return the number of matching pb link entries
	 */
	public static int countBypbLinkEntryId(long pbLinkEntryId) {
		return getPersistence().countBypbLinkEntryId(pbLinkEntryId);
	}

	/**
	 * Returns all the pb link entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pb link entries
	 */
	public static List<PBLinkEntry> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the pb link entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @return the range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByName(
		String name, int start, int end) {

		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the pb link entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByName(
		String name, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pb link entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByName(
		String name, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByName_First(
			String name, OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByName_First(
		String name, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByName_Last(
			String name, OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByName_Last(
		String name, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the pb link entries before and after the current pb link entry in the ordered set where name = &#63;.
	 *
	 * @param pbLinkEntryId the primary key of the current pb link entry
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public static PBLinkEntry[] findByName_PrevAndNext(
			long pbLinkEntryId, String name,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByName_PrevAndNext(
			pbLinkEntryId, name, orderByComparator);
	}

	/**
	 * Removes all the pb link entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of pb link entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pb link entries
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByD_D_N(
			long pbLinkEntryId, String description, String name)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByD_D_N(pbLinkEntryId, description, name);
	}

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByD_D_N(
		long pbLinkEntryId, String description, String name) {

		return getPersistence().fetchByD_D_N(pbLinkEntryId, description, name);
	}

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByD_D_N(
		long pbLinkEntryId, String description, String name,
		boolean useFinderCache) {

		return getPersistence().fetchByD_D_N(
			pbLinkEntryId, description, name, useFinderCache);
	}

	/**
	 * Removes the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the pb link entry that was removed
	 */
	public static PBLinkEntry removeByD_D_N(
			long pbLinkEntryId, String description, String name)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().removeByD_D_N(pbLinkEntryId, description, name);
	}

	/**
	 * Returns the number of pb link entries where pbLinkEntryId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching pb link entries
	 */
	public static int countByD_D_N(
		long pbLinkEntryId, String description, String name) {

		return getPersistence().countByD_D_N(pbLinkEntryId, description, name);
	}

	/**
	 * Returns all the pb link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching pb link entries
	 */
	public static List<PBLinkEntry> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the pb link entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @return the range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the pb link entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pb link entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByStatus_First(
			int status, OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByStatus_First(
		int status, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByStatus_Last(
			int status, OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByStatus_Last(
		int status, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the pb link entries before and after the current pb link entry in the ordered set where status = &#63;.
	 *
	 * @param pbLinkEntryId the primary key of the current pb link entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public static PBLinkEntry[] findByStatus_PrevAndNext(
			long pbLinkEntryId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByStatus_PrevAndNext(
			pbLinkEntryId, status, orderByComparator);
	}

	/**
	 * Removes all the pb link entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of pb link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching pb link entries
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching pb link entries
	 */
	public static List<PBLinkEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @return the range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pb link entries
	 */
	public static List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public static PBLinkEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public static PBLinkEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the pb link entries before and after the current pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param pbLinkEntryId the primary key of the current pb link entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public static PBLinkEntry[] findByG_S_PrevAndNext(
			long pbLinkEntryId, long groupId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			pbLinkEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the pb link entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching pb link entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Caches the pb link entry in the entity cache if it is enabled.
	 *
	 * @param pbLinkEntry the pb link entry
	 */
	public static void cacheResult(PBLinkEntry pbLinkEntry) {
		getPersistence().cacheResult(pbLinkEntry);
	}

	/**
	 * Caches the pb link entries in the entity cache if it is enabled.
	 *
	 * @param pbLinkEntries the pb link entries
	 */
	public static void cacheResult(List<PBLinkEntry> pbLinkEntries) {
		getPersistence().cacheResult(pbLinkEntries);
	}

	/**
	 * Creates a new pb link entry with the primary key. Does not add the pb link entry to the database.
	 *
	 * @param pbLinkEntryId the primary key for the new pb link entry
	 * @return the new pb link entry
	 */
	public static PBLinkEntry create(long pbLinkEntryId) {
		return getPersistence().create(pbLinkEntryId);
	}

	/**
	 * Removes the pb link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry that was removed
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public static PBLinkEntry remove(long pbLinkEntryId)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().remove(pbLinkEntryId);
	}

	public static PBLinkEntry updateImpl(PBLinkEntry pbLinkEntry) {
		return getPersistence().updateImpl(pbLinkEntry);
	}

	/**
	 * Returns the pb link entry with the primary key or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public static PBLinkEntry findByPrimaryKey(long pbLinkEntryId)
		throws com.liferay.pblink.exception.NoSuchEntryException {

		return getPersistence().findByPrimaryKey(pbLinkEntryId);
	}

	/**
	 * Returns the pb link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry, or <code>null</code> if a pb link entry with the primary key could not be found
	 */
	public static PBLinkEntry fetchByPrimaryKey(long pbLinkEntryId) {
		return getPersistence().fetchByPrimaryKey(pbLinkEntryId);
	}

	/**
	 * Returns all the pb link entries.
	 *
	 * @return the pb link entries
	 */
	public static List<PBLinkEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pb link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @return the range of pb link entries
	 */
	public static List<PBLinkEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pb link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pb link entries
	 */
	public static List<PBLinkEntry> findAll(
		int start, int end, OrderByComparator<PBLinkEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pb link entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PBLinkEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pb link entries
	 * @param end the upper bound of the range of pb link entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pb link entries
	 */
	public static List<PBLinkEntry> findAll(
		int start, int end, OrderByComparator<PBLinkEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pb link entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pb link entries.
	 *
	 * @return the number of pb link entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PBLinkEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PBLinkEntryPersistence _persistence;

}