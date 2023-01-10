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

package com.liferay.dc.service.persistence;

import com.liferay.dc.exception.NoSuchDocumentsException;
import com.liferay.dc.model.Documents;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsUtil
 * @generated
 */
@ProviderType
public interface DocumentsPersistence extends BasePersistence<Documents> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentsUtil} to access the documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching documentses
	 */
	public java.util.List<Documents> findBydocumentId(long documentId);

	/**
	 * Returns a range of all the documentses where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of matching documentses
	 */
	public java.util.List<Documents> findBydocumentId(
		long documentId, int start, int end);

	/**
	 * Returns an ordered range of all the documentses where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findBydocumentId(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documentses where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findBydocumentId(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findBydocumentId_First(
			long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the first documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchBydocumentId_First(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the last documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findBydocumentId_Last(
			long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the last documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchBydocumentId_Last(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Removes all the documentses where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	public void removeBydocumentId(long documentId);

	/**
	 * Returns the number of documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching documentses
	 */
	public int countBydocumentId(long documentId);

	/**
	 * Returns all the documentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching documentses
	 */
	public java.util.List<Documents> findByName(String name);

	/**
	 * Returns a range of all the documentses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of matching documentses
	 */
	public java.util.List<Documents> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the documentses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documentses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the first documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the last documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the last documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the documentses before and after the current documents in the ordered set where name = &#63;.
	 *
	 * @param documentId the primary key of the current documents
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public Documents[] findByName_PrevAndNext(
			long documentId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Removes all the documentses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of documentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching documentses
	 */
	public int countByName(String name);

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByD_D_N(
			long documentId, String description, String name)
		throws NoSuchDocumentsException;

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByD_D_N(
		long documentId, String description, String name);

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByD_D_N(
		long documentId, String description, String name,
		boolean useFinderCache);

	/**
	 * Removes the documents where documentId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the documents that was removed
	 */
	public Documents removeByD_D_N(
			long documentId, String description, String name)
		throws NoSuchDocumentsException;

	/**
	 * Returns the number of documentses where documentId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching documentses
	 */
	public int countByD_D_N(long documentId, String description, String name);

	/**
	 * Returns all the documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching documentses
	 */
	public java.util.List<Documents> findByStatus(int status);

	/**
	 * Returns a range of all the documentses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of matching documentses
	 */
	public java.util.List<Documents> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the documentses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documentses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the first documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the last documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the last documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the documentses before and after the current documents in the ordered set where status = &#63;.
	 *
	 * @param documentId the primary key of the current documents
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public Documents[] findByStatus_PrevAndNext(
			long documentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Removes all the documentses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching documentses
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the documentses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching documentses
	 */
	public java.util.List<Documents> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the documentses where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of matching documentses
	 */
	public java.util.List<Documents> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the documentses where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documentses where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching documentses
	 */
	public java.util.List<Documents> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the first documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the last documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public Documents findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Returns the last documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public Documents fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns the documentses before and after the current documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param documentId the primary key of the current documents
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public Documents[] findByG_S_PrevAndNext(
			long documentId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Documents>
				orderByComparator)
		throws NoSuchDocumentsException;

	/**
	 * Removes all the documentses where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of documentses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching documentses
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	public void cacheResult(Documents documents);

	/**
	 * Caches the documentses in the entity cache if it is enabled.
	 *
	 * @param documentses the documentses
	 */
	public void cacheResult(java.util.List<Documents> documentses);

	/**
	 * Creates a new documents with the primary key. Does not add the documents to the database.
	 *
	 * @param documentId the primary key for the new documents
	 * @return the new documents
	 */
	public Documents create(long documentId);

	/**
	 * Removes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents that was removed
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public Documents remove(long documentId) throws NoSuchDocumentsException;

	public Documents updateImpl(Documents documents);

	/**
	 * Returns the documents with the primary key or throws a <code>NoSuchDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public Documents findByPrimaryKey(long documentId)
		throws NoSuchDocumentsException;

	/**
	 * Returns the documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents, or <code>null</code> if a documents with the primary key could not be found
	 */
	public Documents fetchByPrimaryKey(long documentId);

	/**
	 * Returns all the documentses.
	 *
	 * @return the documentses
	 */
	public java.util.List<Documents> findAll();

	/**
	 * Returns a range of all the documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @return the range of documentses
	 */
	public java.util.List<Documents> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of documentses
	 */
	public java.util.List<Documents> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator);

	/**
	 * Returns an ordered range of all the documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of documentses
	 * @param end the upper bound of the range of documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of documentses
	 */
	public java.util.List<Documents> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Documents>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the documentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of documentses.
	 *
	 * @return the number of documentses
	 */
	public int countAll();

}