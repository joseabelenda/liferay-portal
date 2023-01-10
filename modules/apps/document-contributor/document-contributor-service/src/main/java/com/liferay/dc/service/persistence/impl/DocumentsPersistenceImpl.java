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

package com.liferay.dc.service.persistence.impl;

import com.liferay.dc.exception.NoSuchDocumentsException;
import com.liferay.dc.model.Documents;
import com.liferay.dc.model.DocumentsTable;
import com.liferay.dc.model.impl.DocumentsImpl;
import com.liferay.dc.model.impl.DocumentsModelImpl;
import com.liferay.dc.service.persistence.DocumentsPersistence;
import com.liferay.dc.service.persistence.DocumentsUtil;
import com.liferay.dc.service.persistence.impl.constants.DocumentsPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DocumentsPersistence.class)
public class DocumentsPersistenceImpl
	extends BasePersistenceImpl<Documents> implements DocumentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentsUtil</code> to access the documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBydocumentId;
	private FinderPath _finderPathWithoutPaginationFindBydocumentId;
	private FinderPath _finderPathCountBydocumentId;

	/**
	 * Returns all the documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching documentses
	 */
	@Override
	public List<Documents> findBydocumentId(long documentId) {
		return findBydocumentId(
			documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Documents> findBydocumentId(
		long documentId, int start, int end) {

		return findBydocumentId(documentId, start, end, null);
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
	@Override
	public List<Documents> findBydocumentId(
		long documentId, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return findBydocumentId(
			documentId, start, end, orderByComparator, true);
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
	@Override
	public List<Documents> findBydocumentId(
		long documentId, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBydocumentId;
				finderArgs = new Object[] {documentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBydocumentId;
			finderArgs = new Object[] {
				documentId, start, end, orderByComparator
			};
		}

		List<Documents> list = null;

		if (useFinderCache) {
			list = (List<Documents>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Documents documents : list) {
					if (documentId != documents.getDocumentId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				list = (List<Documents>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findBydocumentId_First(
			long documentId, OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchBydocumentId_First(
			documentId, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the first documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchBydocumentId_First(
		long documentId, OrderByComparator<Documents> orderByComparator) {

		List<Documents> list = findBydocumentId(
			documentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findBydocumentId_Last(
			long documentId, OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchBydocumentId_Last(
			documentId, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the last documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchBydocumentId_Last(
		long documentId, OrderByComparator<Documents> orderByComparator) {

		int count = countBydocumentId(documentId);

		if (count == 0) {
			return null;
		}

		List<Documents> list = findBydocumentId(
			documentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the documentses where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	@Override
	public void removeBydocumentId(long documentId) {
		for (Documents documents :
				findBydocumentId(
					documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documents);
		}
	}

	/**
	 * Returns the number of documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching documentses
	 */
	@Override
	public int countBydocumentId(long documentId) {
		FinderPath finderPath = _finderPathCountBydocumentId;

		Object[] finderArgs = new Object[] {documentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 =
		"documents.documentId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the documentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching documentses
	 */
	@Override
	public List<Documents> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Documents> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
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
	@Override
	public List<Documents> findByName(
		String name, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
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
	@Override
	public List<Documents> findByName(
		String name, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<Documents> list = null;

		if (useFinderCache) {
			list = (List<Documents>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Documents documents : list) {
					if (!name.equals(documents.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Documents>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findByName_First(
			String name, OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchByName_First(name, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the first documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByName_First(
		String name, OrderByComparator<Documents> orderByComparator) {

		List<Documents> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findByName_Last(
			String name, OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchByName_Last(name, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the last documents in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByName_Last(
		String name, OrderByComparator<Documents> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Documents> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Documents[] findByName_PrevAndNext(
			long documentId, String name,
			OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		name = Objects.toString(name, "");

		Documents documents = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Documents[] array = new DocumentsImpl[3];

			array[0] = getByName_PrevAndNext(
				session, documents, name, orderByComparator, true);

			array[1] = documents;

			array[2] = getByName_PrevAndNext(
				session, documents, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Documents getByName_PrevAndNext(
		Session session, Documents documents, String name,
		OrderByComparator<Documents> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(documents)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Documents> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documentses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (Documents documents :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documents);
		}
	}

	/**
	 * Returns the number of documentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching documentses
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"documents.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(documents.name IS NULL OR documents.name = '')";

	private FinderPath _finderPathFetchByD_D_N;
	private FinderPath _finderPathCountByD_D_N;

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findByD_D_N(
			long documentId, String description, String name)
		throws NoSuchDocumentsException {

		Documents documents = fetchByD_D_N(documentId, description, name);

		if (documents == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("documentId=");
			sb.append(documentId);

			sb.append(", description=");
			sb.append(description);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentsException(sb.toString());
		}

		return documents;
	}

	/**
	 * Returns the documents where documentId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByD_D_N(
		long documentId, String description, String name) {

		return fetchByD_D_N(documentId, description, name, true);
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
	@Override
	public Documents fetchByD_D_N(
		long documentId, String description, String name,
		boolean useFinderCache) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {documentId, description, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByD_D_N, finderArgs, this);
		}

		if (result instanceof Documents) {
			Documents documents = (Documents)result;

			if ((documentId != documents.getDocumentId()) ||
				!Objects.equals(description, documents.getDescription()) ||
				!Objects.equals(name, documents.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_D_D_N_DOCUMENTID_2);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_D_D_N_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_D_D_N_DESCRIPTION_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_D_D_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_D_D_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				List<Documents> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByD_D_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									documentId, description, name
								};
							}

							_log.warn(
								"DocumentsPersistenceImpl.fetchByD_D_N(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Documents documents = list.get(0);

					result = documents;

					cacheResult(documents);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Documents)result;
		}
	}

	/**
	 * Removes the documents where documentId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the documents that was removed
	 */
	@Override
	public Documents removeByD_D_N(
			long documentId, String description, String name)
		throws NoSuchDocumentsException {

		Documents documents = findByD_D_N(documentId, description, name);

		return remove(documents);
	}

	/**
	 * Returns the number of documentses where documentId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param documentId the document ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching documentses
	 */
	@Override
	public int countByD_D_N(long documentId, String description, String name) {
		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByD_D_N;

		Object[] finderArgs = new Object[] {documentId, description, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_D_D_N_DOCUMENTID_2);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_D_D_N_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_D_D_N_DESCRIPTION_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_D_D_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_D_D_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_D_D_N_DOCUMENTID_2 =
		"documents.documentId = ? AND ";

	private static final String _FINDER_COLUMN_D_D_N_DESCRIPTION_2 =
		"documents.description = ? AND ";

	private static final String _FINDER_COLUMN_D_D_N_DESCRIPTION_3 =
		"(documents.description IS NULL OR documents.description = '') AND ";

	private static final String _FINDER_COLUMN_D_D_N_NAME_2 =
		"documents.name = ?";

	private static final String _FINDER_COLUMN_D_D_N_NAME_3 =
		"(documents.name IS NULL OR documents.name = '')";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching documentses
	 */
	@Override
	public List<Documents> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Documents> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<Documents> findByStatus(
		int status, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
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
	@Override
	public List<Documents> findByStatus(
		int status, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Documents> list = null;

		if (useFinderCache) {
			list = (List<Documents>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Documents documents : list) {
					if (status != documents.getStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Documents>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findByStatus_First(
			int status, OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchByStatus_First(status, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the first documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByStatus_First(
		int status, OrderByComparator<Documents> orderByComparator) {

		List<Documents> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents
	 * @throws NoSuchDocumentsException if a matching documents could not be found
	 */
	@Override
	public Documents findByStatus_Last(
			int status, OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchByStatus_Last(status, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the last documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByStatus_Last(
		int status, OrderByComparator<Documents> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Documents> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Documents[] findByStatus_PrevAndNext(
			long documentId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Documents[] array = new DocumentsImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, documents, status, orderByComparator, true);

			array[1] = documents;

			array[2] = getByStatus_PrevAndNext(
				session, documents, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Documents getByStatus_PrevAndNext(
		Session session, Documents documents, int status,
		OrderByComparator<Documents> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(documents)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Documents> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documentses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Documents documents :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documents);
		}
	}

	/**
	 * Returns the number of documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching documentses
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"documents.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the documentses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching documentses
	 */
	@Override
	public List<Documents> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Documents> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
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
	@Override
	public List<Documents> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Documents> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Documents> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<Documents> list = null;

		if (useFinderCache) {
			list = (List<Documents>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Documents documents : list) {
					if ((groupId != documents.getGroupId()) ||
						(status != documents.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<Documents>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Documents findByG_S_First(
			long groupId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the first documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Documents> orderByComparator) {

		List<Documents> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Documents findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (documents != null) {
			return documents;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDocumentsException(sb.toString());
	}

	/**
	 * Returns the last documents in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching documents, or <code>null</code> if a matching documents could not be found
	 */
	@Override
	public Documents fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Documents> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Documents> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Documents[] findByG_S_PrevAndNext(
			long documentId, long groupId, int status,
			OrderByComparator<Documents> orderByComparator)
		throws NoSuchDocumentsException {

		Documents documents = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			Documents[] array = new DocumentsImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, documents, groupId, status, orderByComparator, true);

			array[1] = documents;

			array[2] = getByG_S_PrevAndNext(
				session, documents, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Documents getByG_S_PrevAndNext(
		Session session, Documents documents, long groupId, int status,
		OrderByComparator<Documents> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DOCUMENTS_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(documents)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Documents> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the documentses where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (Documents documents :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(documents);
		}
	}

	/**
	 * Returns the number of documentses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching documentses
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"documents.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"documents.status = ?";

	public DocumentsPersistenceImpl() {
		setModelClass(Documents.class);

		setModelImplClass(DocumentsImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentsTable.INSTANCE);
	}

	/**
	 * Caches the documents in the entity cache if it is enabled.
	 *
	 * @param documents the documents
	 */
	@Override
	public void cacheResult(Documents documents) {
		entityCache.putResult(
			DocumentsImpl.class, documents.getPrimaryKey(), documents);

		finderCache.putResult(
			_finderPathFetchByD_D_N,
			new Object[] {
				documents.getDocumentId(), documents.getDescription(),
				documents.getName()
			},
			documents);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the documentses in the entity cache if it is enabled.
	 *
	 * @param documentses the documentses
	 */
	@Override
	public void cacheResult(List<Documents> documentses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documentses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Documents documents : documentses) {
			if (entityCache.getResult(
					DocumentsImpl.class, documents.getPrimaryKey()) == null) {

				cacheResult(documents);
			}
		}
	}

	/**
	 * Clears the cache for all documentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentsImpl.class);

		finderCache.clearCache(DocumentsImpl.class);
	}

	/**
	 * Clears the cache for the documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Documents documents) {
		entityCache.removeResult(DocumentsImpl.class, documents);
	}

	@Override
	public void clearCache(List<Documents> documentses) {
		for (Documents documents : documentses) {
			entityCache.removeResult(DocumentsImpl.class, documents);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentsModelImpl documentsModelImpl) {

		Object[] args = new Object[] {
			documentsModelImpl.getDocumentId(),
			documentsModelImpl.getDescription(), documentsModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByD_D_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByD_D_N, args, documentsModelImpl);
	}

	/**
	 * Creates a new documents with the primary key. Does not add the documents to the database.
	 *
	 * @param documentId the primary key for the new documents
	 * @return the new documents
	 */
	@Override
	public Documents create(long documentId) {
		Documents documents = new DocumentsImpl();

		documents.setNew(true);
		documents.setPrimaryKey(documentId);

		documents.setCompanyId(CompanyThreadLocal.getCompanyId());

		return documents;
	}

	/**
	 * Removes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents that was removed
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	@Override
	public Documents remove(long documentId) throws NoSuchDocumentsException {
		return remove((Serializable)documentId);
	}

	/**
	 * Removes the documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the documents
	 * @return the documents that was removed
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	@Override
	public Documents remove(Serializable primaryKey)
		throws NoSuchDocumentsException {

		Session session = null;

		try {
			session = openSession();

			Documents documents = (Documents)session.get(
				DocumentsImpl.class, primaryKey);

			if (documents == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documents);
		}
		catch (NoSuchDocumentsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Documents removeImpl(Documents documents) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documents)) {
				documents = (Documents)session.get(
					DocumentsImpl.class, documents.getPrimaryKeyObj());
			}

			if (documents != null) {
				session.delete(documents);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documents != null) {
			clearCache(documents);
		}

		return documents;
	}

	@Override
	public Documents updateImpl(Documents documents) {
		boolean isNew = documents.isNew();

		if (!(documents instanceof DocumentsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documents.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(documents);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documents proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Documents implementation " +
					documents.getClass());
		}

		DocumentsModelImpl documentsModelImpl = (DocumentsModelImpl)documents;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (documents.getCreateDate() == null)) {
			if (serviceContext == null) {
				documents.setCreateDate(date);
			}
			else {
				documents.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!documentsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				documents.setModifiedDate(date);
			}
			else {
				documents.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documents);
			}
			else {
				documents = (Documents)session.merge(documents);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentsImpl.class, documentsModelImpl, false, true);

		cacheUniqueFindersCache(documentsModelImpl);

		if (isNew) {
			documents.setNew(false);
		}

		documents.resetOriginalValues();

		return documents;
	}

	/**
	 * Returns the documents with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the documents
	 * @return the documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	@Override
	public Documents findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentsException {

		Documents documents = fetchByPrimaryKey(primaryKey);

		if (documents == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documents;
	}

	/**
	 * Returns the documents with the primary key or throws a <code>NoSuchDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents
	 * @throws NoSuchDocumentsException if a documents with the primary key could not be found
	 */
	@Override
	public Documents findByPrimaryKey(long documentId)
		throws NoSuchDocumentsException {

		return findByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns the documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the documents
	 * @return the documents, or <code>null</code> if a documents with the primary key could not be found
	 */
	@Override
	public Documents fetchByPrimaryKey(long documentId) {
		return fetchByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns all the documentses.
	 *
	 * @return the documentses
	 */
	@Override
	public List<Documents> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Documents> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Documents> findAll(
		int start, int end, OrderByComparator<Documents> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Documents> findAll(
		int start, int end, OrderByComparator<Documents> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Documents> list = null;

		if (useFinderCache) {
			list = (List<Documents>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTS;

				sql = sql.concat(DocumentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Documents>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the documentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Documents documents : findAll()) {
			remove(documents);
		}
	}

	/**
	 * Returns the number of documentses.
	 *
	 * @return the number of documentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENTS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "documentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the documents persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBydocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydocumentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"documentId"}, true);

		_finderPathWithoutPaginationFindBydocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			true);

		_finderPathCountBydocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			false);

		_finderPathWithPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathFetchByD_D_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByD_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"documentId", "description", "name"}, true);

		_finderPathCountByD_D_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"documentId", "description", "name"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_setDocumentsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocumentsUtilPersistence(null);

		entityCache.removeCache(DocumentsImpl.class.getName());
	}

	private void _setDocumentsUtilPersistence(
		DocumentsPersistence documentsPersistence) {

		try {
			Field field = DocumentsUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, documentsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DocumentsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DocumentsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DocumentsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DOCUMENTS =
		"SELECT documents FROM Documents documents";

	private static final String _SQL_SELECT_DOCUMENTS_WHERE =
		"SELECT documents FROM Documents documents WHERE ";

	private static final String _SQL_COUNT_DOCUMENTS =
		"SELECT COUNT(documents) FROM Documents documents";

	private static final String _SQL_COUNT_DOCUMENTS_WHERE =
		"SELECT COUNT(documents) FROM Documents documents WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documents.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Documents exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Documents exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}