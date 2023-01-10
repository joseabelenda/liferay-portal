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

import com.liferay.dc.model.Documents;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the documents service. This utility wraps <code>com.liferay.dc.service.persistence.impl.DocumentsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentsPersistence
 * @generated
 */
public class DocumentsUtil {

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
	public static void clearCache(Documents documents) {
		getPersistence().clearCache(documents);
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
	public static Map<Serializable, Documents> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Documents> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Documents> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Documents> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Documents update(Documents documents) {
		return getPersistence().update(documents);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Documents update(
		Documents documents, ServiceContext serviceContext) {

		return getPersistence().update(documents, serviceContext);
	}

	/**
	 * Returns all the documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching documentses
	 */
	public static List<Documents> findBydocumentId(long documentId) {
		return getPersistence().findBydocumentId(documentId);
	}

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
	public static List<Documents> findBydocumentId(
		long documentId, int start, int end) {

		return getPersistence().findBydocumentId(documentId, start, end);
	}

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
	public static List<Documents> findBydocumentId(
		long documentId, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().findBydocumentId(
			documentId, start, end, orderByComparator);
	}

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
	public static List<Documents> findBydocumentId(
		long documentId, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBydocumentId(
			documentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findBydocumentId_First(
			long documentId, OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findBydocumentId_First(
			documentId, orderByComparator);
	}

	/**
	 * Returns the first documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchBydocumentId_First(
		long documentId, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchBydocumentId_First(
			documentId, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findBydocumentId_Last(
			long documentId, OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findBydocumentId_Last(
			documentId, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchBydocumentId_Last(
		long documentId, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchBydocumentId_Last(
			documentId, orderByComparator);
	}

	/**
	 * Removes all the documentses where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	public static void removeBydocumentId(long documentId) {
		getPersistence().removeBydocumentId(documentId);
	}

	/**
	 * Returns the number of documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching documentses
	 */
	public static int countBydocumentId(long documentId) {
		return getPersistence().countBydocumentId(documentId);
	}

	/**
	 * Returns all the documentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching documentses
	 */
	public static List<Documents> findByName(String name) {
		return getPersistence().findByName(name);
	}

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
	public static List<Documents> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

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
	public static List<Documents> findByName(
		String name, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

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
	public static List<Documents> findByName(
		String name, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByName_First(
			String name, OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByName_First(
		String name, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByName_Last(
			String name, OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByName_Last(
		String name, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the documentses before and after the current documents in the ordered set where name = &#63;.
	 *
	 * @param documentId the primary key of the current documents
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public static Documents[] findByName_PrevAndNext(
			long documentId, String name,
			OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByName_PrevAndNext(
			documentId, name, orderByComparator);
	}

	/**
	 * Removes all the documentses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of documentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching documentses
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByD_D_N(
			long documentId, String description, String name)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByD_D_N(documentId, description, name);
	}

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByD_D_N(
		long documentId, String description, String name) {

		return getPersistence().fetchByD_D_N(documentId, description, name);
	}

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByD_D_N(
		long documentId, String description, String name,
		boolean useFinderCache) {

		return getPersistence().fetchByD_D_N(
			documentId, description, name, useFinderCache);
	}

	/**
	 * Removes the documents where documentId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the documents that was removed
	 */
	public static Documents removeByD_D_N(
			long documentId, String description, String name)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().removeByD_D_N(documentId, description, name);
	}

	/**
	 * Returns the number of documentses where documentId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching documentses
	 */
	public static int countByD_D_N(
		long documentId, String description, String name) {

		return getPersistence().countByD_D_N(documentId, description, name);
	}

	/**
	 * Returns all the documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching documentses
	 */
	public static List<Documents> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

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
	public static List<Documents> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static List<Documents> findByStatus(
		int status, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

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
	public static List<Documents> findByStatus(
		int status, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByStatus_First(
			int status, OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByStatus_First(
		int status, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByStatus_Last(
			int status, OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByStatus_Last(
		int status, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the documentses before and after the current documents in the ordered set where status = &#63;.
	 *
	 * @param documentId the primary key of the current documents
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public static Documents[] findByStatus_PrevAndNext(
			long documentId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByStatus_PrevAndNext(
			documentId, status, orderByComparator);
	}

	/**
	 * Removes all the documentses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching documentses
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the documentses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching documentses
	 */
	public static List<Documents> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

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
	public static List<Documents> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

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
	public static List<Documents> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

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
	public static List<Documents> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByG_S_First(
			long groupId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	public static Documents findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	public static Documents fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Documents> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

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
	public static Documents[] findByG_S_PrevAndNext(
			long documentId, long groupId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByG_S_PrevAndNext(
			documentId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the documentses where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of documentses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching documentses
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	public static void cacheResult(Documents documents) {
		getPersistence().cacheResult(documents);
	}

	/**
	 * Caches the documentses in the entity cache if it is enabled.
	 *
	 * @param documentses the documentses
	 */
	public static void cacheResult(List<Documents> documentses) {
		getPersistence().cacheResult(documentses);
	}

	/**
	 * Creates a new documents with the primary key. Does not add the documents to the database.
	 *
	 * @param documentId the primary key for the new documents
	 * @return the new documents
	 */
	public static Documents create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	 * Removes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents that was removed
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public static Documents remove(long documentId)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().remove(documentId);
	}

	public static Documents updateImpl(Documents documents) {
		return getPersistence().updateImpl(documents);
	}

	/**
	 * Returns the documents with the primary key or throws a <code>NoSuchDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	public static Documents findByPrimaryKey(long documentId)
		throws com.liferay.dc.exception.NoSuchDocumentsException {

		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	 * Returns the documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents, or <code>null</code> if a documents with the primary key could not be found
	 */
	public static Documents fetchByPrimaryKey(long documentId) {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	/**
	 * Returns all the documentses.
	 *
	 * @return the documentses
	 */
	public static List<Documents> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Documents> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Documents> findAll(
		int start, int end, OrderByComparator<Documents> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Documents> findAll(
		int start, int end, OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the documentses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of documentses.
	 *
	 * @return the number of documentses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocumentsPersistence _persistence;

}