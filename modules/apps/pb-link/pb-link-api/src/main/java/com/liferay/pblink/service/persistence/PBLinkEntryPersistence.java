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

import com.liferay.pblink.exception.NoSuchEntryException;
import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pb link entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PBLinkEntryUtil
 * @generated
 */
@ProviderType
public interface PBLinkEntryPersistence extends BasePersistence<PBLinkEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PBLinkEntryUtil} to access the pb link entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pb link entries where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @return the matching pb link entries
	 */
	public java.util.List<PBLinkEntry> findBypbLinkEntryId(long pbLinkEntryId);

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
	public java.util.List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end);

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
	public java.util.List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

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
	public java.util.List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findBypbLinkEntryId_First(
			long pbLinkEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the first pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchBypbLinkEntryId_First(
		long pbLinkEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Returns the last pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findBypbLinkEntryId_Last(
			long pbLinkEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the last pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchBypbLinkEntryId_Last(
		long pbLinkEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Removes all the pb link entries where pbLinkEntryId = &#63; from the database.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 */
	public void removeBypbLinkEntryId(long pbLinkEntryId);

	/**
	 * Returns the number of pb link entries where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @return the number of matching pb link entries
	 */
	public int countBypbLinkEntryId(long pbLinkEntryId);

	/**
	 * Returns all the pb link entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pb link entries
	 */
	public java.util.List<PBLinkEntry> findByName(String name);

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
	public java.util.List<PBLinkEntry> findByName(
		String name, int start, int end);

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
	public java.util.List<PBLinkEntry> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

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
	public java.util.List<PBLinkEntry> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the first pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Returns the last pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the last pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Returns the pb link entries before and after the current pb link entry in the ordered set where name = &#63;.
	 *
	 * @param pbLinkEntryId the primary key of the current pb link entry
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public PBLinkEntry[] findByName_PrevAndNext(
			long pbLinkEntryId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Removes all the pb link entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of pb link entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pb link entries
	 */
	public int countByName(String name);

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByD_D_N(
			long pbLinkEntryId, String description, String name)
		throws NoSuchEntryException;

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByD_D_N(
		long pbLinkEntryId, String description, String name);

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByD_D_N(
		long pbLinkEntryId, String description, String name,
		boolean useFinderCache);

	/**
	 * Removes the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the pb link entry that was removed
	 */
	public PBLinkEntry removeByD_D_N(
			long pbLinkEntryId, String description, String name)
		throws NoSuchEntryException;

	/**
	 * Returns the number of pb link entries where pbLinkEntryId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching pb link entries
	 */
	public int countByD_D_N(
		long pbLinkEntryId, String description, String name);

	/**
	 * Returns all the pb link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching pb link entries
	 */
	public java.util.List<PBLinkEntry> findByStatus(int status);

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
	public java.util.List<PBLinkEntry> findByStatus(
		int status, int start, int end);

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
	public java.util.List<PBLinkEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

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
	public java.util.List<PBLinkEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the first pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Returns the last pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the last pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Returns the pb link entries before and after the current pb link entry in the ordered set where status = &#63;.
	 *
	 * @param pbLinkEntryId the primary key of the current pb link entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public PBLinkEntry[] findByStatus_PrevAndNext(
			long pbLinkEntryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Removes all the pb link entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of pb link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching pb link entries
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching pb link entries
	 */
	public java.util.List<PBLinkEntry> findByG_S(long groupId, int status);

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
	public java.util.List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

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
	public java.util.List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the first pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

	/**
	 * Returns the last pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	public PBLinkEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Returns the last pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	public PBLinkEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

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
	public PBLinkEntry[] findByG_S_PrevAndNext(
			long pbLinkEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
				orderByComparator)
		throws NoSuchEntryException;

	/**
	 * Removes all the pb link entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching pb link entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Caches the pb link entry in the entity cache if it is enabled.
	 *
	 * @param pbLinkEntry the pb link entry
	 */
	public void cacheResult(PBLinkEntry pbLinkEntry);

	/**
	 * Caches the pb link entries in the entity cache if it is enabled.
	 *
	 * @param pbLinkEntries the pb link entries
	 */
	public void cacheResult(java.util.List<PBLinkEntry> pbLinkEntries);

	/**
	 * Creates a new pb link entry with the primary key. Does not add the pb link entry to the database.
	 *
	 * @param pbLinkEntryId the primary key for the new pb link entry
	 * @return the new pb link entry
	 */
	public PBLinkEntry create(long pbLinkEntryId);

	/**
	 * Removes the pb link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry that was removed
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public PBLinkEntry remove(long pbLinkEntryId) throws NoSuchEntryException;

	public PBLinkEntry updateImpl(PBLinkEntry pbLinkEntry);

	/**
	 * Returns the pb link entry with the primary key or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	public PBLinkEntry findByPrimaryKey(long pbLinkEntryId)
		throws NoSuchEntryException;

	/**
	 * Returns the pb link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry, or <code>null</code> if a pb link entry with the primary key could not be found
	 */
	public PBLinkEntry fetchByPrimaryKey(long pbLinkEntryId);

	/**
	 * Returns all the pb link entries.
	 *
	 * @return the pb link entries
	 */
	public java.util.List<PBLinkEntry> findAll();

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
	public java.util.List<PBLinkEntry> findAll(int start, int end);

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
	public java.util.List<PBLinkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator);

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
	public java.util.List<PBLinkEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PBLinkEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pb link entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pb link entries.
	 *
	 * @return the number of pb link entries
	 */
	public int countAll();

}