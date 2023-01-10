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

package com.liferay.pblink.service.persistence.impl;

import com.liferay.pblink.exception.NoSuchEntryException;
import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.pblink.model.PBLinkEntryTable;
import com.liferay.pblink.model.impl.PBLinkEntryImpl;
import com.liferay.pblink.model.impl.PBLinkEntryModelImpl;
import com.liferay.pblink.service.persistence.PBLinkEntryPersistence;
import com.liferay.pblink.service.persistence.PBLinkEntryUtil;
import com.liferay.pblink.service.persistence.impl.constants.PBLinkPersistenceConstants;
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
 * The persistence implementation for the pb link entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PBLinkEntryPersistence.class)
public class PBLinkEntryPersistenceImpl
	extends BasePersistenceImpl<PBLinkEntry> implements PBLinkEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PBLinkEntryUtil</code> to access the pb link entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PBLinkEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypbLinkEntryId;
	private FinderPath _finderPathWithoutPaginationFindBypbLinkEntryId;
	private FinderPath _finderPathCountBypbLinkEntryId;

	/**
	 * Returns all the pb link entries where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @return the matching pb link entries
	 */
	@Override
	public List<PBLinkEntry> findBypbLinkEntryId(long pbLinkEntryId) {
		return findBypbLinkEntryId(
			pbLinkEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end) {

		return findBypbLinkEntryId(pbLinkEntryId, start, end, null);
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
	@Override
	public List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return findBypbLinkEntryId(
			pbLinkEntryId, start, end, orderByComparator, true);
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
	@Override
	public List<PBLinkEntry> findBypbLinkEntryId(
		long pbLinkEntryId, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypbLinkEntryId;
				finderArgs = new Object[] {pbLinkEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypbLinkEntryId;
			finderArgs = new Object[] {
				pbLinkEntryId, start, end, orderByComparator
			};
		}

		List<PBLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<PBLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PBLinkEntry pbLinkEntry : list) {
					if (pbLinkEntryId != pbLinkEntry.getPbLinkEntryId()) {
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

			sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PBLINKENTRYID_PBLINKENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(pbLinkEntryId);

				list = (List<PBLinkEntry>)QueryUtil.list(
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
	 * Returns the first pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findBypbLinkEntryId_First(
			long pbLinkEntryId,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchBypbLinkEntryId_First(
			pbLinkEntryId, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pbLinkEntryId=");
		sb.append(pbLinkEntryId);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the first pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchBypbLinkEntryId_First(
		long pbLinkEntryId, OrderByComparator<PBLinkEntry> orderByComparator) {

		List<PBLinkEntry> list = findBypbLinkEntryId(
			pbLinkEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findBypbLinkEntryId_Last(
			long pbLinkEntryId,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchBypbLinkEntryId_Last(
			pbLinkEntryId, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pbLinkEntryId=");
		sb.append(pbLinkEntryId);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the last pb link entry in the ordered set where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchBypbLinkEntryId_Last(
		long pbLinkEntryId, OrderByComparator<PBLinkEntry> orderByComparator) {

		int count = countBypbLinkEntryId(pbLinkEntryId);

		if (count == 0) {
			return null;
		}

		List<PBLinkEntry> list = findBypbLinkEntryId(
			pbLinkEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the pb link entries where pbLinkEntryId = &#63; from the database.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 */
	@Override
	public void removeBypbLinkEntryId(long pbLinkEntryId) {
		for (PBLinkEntry pbLinkEntry :
				findBypbLinkEntryId(
					pbLinkEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(pbLinkEntry);
		}
	}

	/**
	 * Returns the number of pb link entries where pbLinkEntryId = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @return the number of matching pb link entries
	 */
	@Override
	public int countBypbLinkEntryId(long pbLinkEntryId) {
		FinderPath finderPath = _finderPathCountBypbLinkEntryId;

		Object[] finderArgs = new Object[] {pbLinkEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PBLINKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_PBLINKENTRYID_PBLINKENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(pbLinkEntryId);

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

	private static final String _FINDER_COLUMN_PBLINKENTRYID_PBLINKENTRYID_2 =
		"pbLinkEntry.pbLinkEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the pb link entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pb link entries
	 */
	@Override
	public List<PBLinkEntry> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PBLinkEntry> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
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
	@Override
	public List<PBLinkEntry> findByName(
		String name, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
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
	@Override
	public List<PBLinkEntry> findByName(
		String name, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
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

		List<PBLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<PBLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PBLinkEntry pbLinkEntry : list) {
					if (!name.equals(pbLinkEntry.getName())) {
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

			sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

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
				sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<PBLinkEntry>)QueryUtil.list(
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
	 * Returns the first pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findByName_First(
			String name, OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByName_First(name, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the first pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByName_First(
		String name, OrderByComparator<PBLinkEntry> orderByComparator) {

		List<PBLinkEntry> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findByName_Last(
			String name, OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByName_Last(name, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the last pb link entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByName_Last(
		String name, OrderByComparator<PBLinkEntry> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<PBLinkEntry> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PBLinkEntry[] findByName_PrevAndNext(
			long pbLinkEntryId, String name,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		name = Objects.toString(name, "");

		PBLinkEntry pbLinkEntry = findByPrimaryKey(pbLinkEntryId);

		Session session = null;

		try {
			session = openSession();

			PBLinkEntry[] array = new PBLinkEntryImpl[3];

			array[0] = getByName_PrevAndNext(
				session, pbLinkEntry, name, orderByComparator, true);

			array[1] = pbLinkEntry;

			array[2] = getByName_PrevAndNext(
				session, pbLinkEntry, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PBLinkEntry getByName_PrevAndNext(
		Session session, PBLinkEntry pbLinkEntry, String name,
		OrderByComparator<PBLinkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

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
			sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pbLinkEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PBLinkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pb link entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (PBLinkEntry pbLinkEntry :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pbLinkEntry);
		}
	}

	/**
	 * Returns the number of pb link entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pb link entries
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PBLINKENTRY_WHERE);

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
		"pbLinkEntry.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(pbLinkEntry.name IS NULL OR pbLinkEntry.name = '')";

	private FinderPath _finderPathFetchByD_D_N;
	private FinderPath _finderPathCountByD_D_N;

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findByD_D_N(
			long pbLinkEntryId, String description, String name)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByD_D_N(
			pbLinkEntryId, description, name);

		if (pbLinkEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("pbLinkEntryId=");
			sb.append(pbLinkEntryId);

			sb.append(", description=");
			sb.append(description);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEntryException(sb.toString());
		}

		return pbLinkEntry;
	}

	/**
	 * Returns the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByD_D_N(
		long pbLinkEntryId, String description, String name) {

		return fetchByD_D_N(pbLinkEntryId, description, name, true);
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
	@Override
	public PBLinkEntry fetchByD_D_N(
		long pbLinkEntryId, String description, String name,
		boolean useFinderCache) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {pbLinkEntryId, description, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByD_D_N, finderArgs, this);
		}

		if (result instanceof PBLinkEntry) {
			PBLinkEntry pbLinkEntry = (PBLinkEntry)result;

			if ((pbLinkEntryId != pbLinkEntry.getPbLinkEntryId()) ||
				!Objects.equals(description, pbLinkEntry.getDescription()) ||
				!Objects.equals(name, pbLinkEntry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_D_D_N_PBLINKENTRYID_2);

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

				queryPos.add(pbLinkEntryId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				List<PBLinkEntry> list = query.list();

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
									pbLinkEntryId, description, name
								};
							}

							_log.warn(
								"PBLinkEntryPersistenceImpl.fetchByD_D_N(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PBLinkEntry pbLinkEntry = list.get(0);

					result = pbLinkEntry;

					cacheResult(pbLinkEntry);
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
			return (PBLinkEntry)result;
		}
	}

	/**
	 * Removes the pb link entry where pbLinkEntryId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the pb link entry that was removed
	 */
	@Override
	public PBLinkEntry removeByD_D_N(
			long pbLinkEntryId, String description, String name)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = findByD_D_N(pbLinkEntryId, description, name);

		return remove(pbLinkEntry);
	}

	/**
	 * Returns the number of pb link entries where pbLinkEntryId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param pbLinkEntryId the pb link entry ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching pb link entries
	 */
	@Override
	public int countByD_D_N(
		long pbLinkEntryId, String description, String name) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByD_D_N;

		Object[] finderArgs = new Object[] {pbLinkEntryId, description, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PBLINKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_D_D_N_PBLINKENTRYID_2);

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

				queryPos.add(pbLinkEntryId);

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

	private static final String _FINDER_COLUMN_D_D_N_PBLINKENTRYID_2 =
		"pbLinkEntry.pbLinkEntryId = ? AND ";

	private static final String _FINDER_COLUMN_D_D_N_DESCRIPTION_2 =
		"pbLinkEntry.description = ? AND ";

	private static final String _FINDER_COLUMN_D_D_N_DESCRIPTION_3 =
		"(pbLinkEntry.description IS NULL OR pbLinkEntry.description = '') AND ";

	private static final String _FINDER_COLUMN_D_D_N_NAME_2 =
		"pbLinkEntry.name = ?";

	private static final String _FINDER_COLUMN_D_D_N_NAME_3 =
		"(pbLinkEntry.name IS NULL OR pbLinkEntry.name = '')";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the pb link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching pb link entries
	 */
	@Override
	public List<PBLinkEntry> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PBLinkEntry> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<PBLinkEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
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
	@Override
	public List<PBLinkEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
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

		List<PBLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<PBLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PBLinkEntry pbLinkEntry : list) {
					if (status != pbLinkEntry.getStatus()) {
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

			sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<PBLinkEntry>)QueryUtil.list(
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
	 * Returns the first pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findByStatus_First(
			int status, OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByStatus_First(
			status, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the first pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByStatus_First(
		int status, OrderByComparator<PBLinkEntry> orderByComparator) {

		List<PBLinkEntry> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findByStatus_Last(
			int status, OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByStatus_Last(status, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the last pb link entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByStatus_Last(
		int status, OrderByComparator<PBLinkEntry> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<PBLinkEntry> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PBLinkEntry[] findByStatus_PrevAndNext(
			long pbLinkEntryId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = findByPrimaryKey(pbLinkEntryId);

		Session session = null;

		try {
			session = openSession();

			PBLinkEntry[] array = new PBLinkEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, pbLinkEntry, status, orderByComparator, true);

			array[1] = pbLinkEntry;

			array[2] = getByStatus_PrevAndNext(
				session, pbLinkEntry, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PBLinkEntry getByStatus_PrevAndNext(
		Session session, PBLinkEntry pbLinkEntry, int status,
		OrderByComparator<PBLinkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

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
			sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(pbLinkEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PBLinkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pb link entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (PBLinkEntry pbLinkEntry :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(pbLinkEntry);
		}
	}

	/**
	 * Returns the number of pb link entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching pb link entries
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PBLINKENTRY_WHERE);

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
		"pbLinkEntry.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching pb link entries
	 */
	@Override
	public List<PBLinkEntry> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
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
	@Override
	public List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<PBLinkEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<PBLinkEntry> orderByComparator,
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

		List<PBLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<PBLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PBLinkEntry pbLinkEntry : list) {
					if ((groupId != pbLinkEntry.getGroupId()) ||
						(status != pbLinkEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<PBLinkEntry>)QueryUtil.list(
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
	 * Returns the first pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry
	 * @throws NoSuchEntryException if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the first pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		List<PBLinkEntry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PBLinkEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (pbLinkEntry != null) {
			return pbLinkEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchEntryException(sb.toString());
	}

	/**
	 * Returns the last pb link entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pb link entry, or <code>null</code> if a matching pb link entry could not be found
	 */
	@Override
	public PBLinkEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<PBLinkEntry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<PBLinkEntry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PBLinkEntry[] findByG_S_PrevAndNext(
			long pbLinkEntryId, long groupId, int status,
			OrderByComparator<PBLinkEntry> orderByComparator)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = findByPrimaryKey(pbLinkEntryId);

		Session session = null;

		try {
			session = openSession();

			PBLinkEntry[] array = new PBLinkEntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, pbLinkEntry, groupId, status, orderByComparator, true);

			array[1] = pbLinkEntry;

			array[2] = getByG_S_PrevAndNext(
				session, pbLinkEntry, groupId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PBLinkEntry getByG_S_PrevAndNext(
		Session session, PBLinkEntry pbLinkEntry, long groupId, int status,
		OrderByComparator<PBLinkEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PBLINKENTRY_WHERE);

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
			sb.append(PBLinkEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(pbLinkEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PBLinkEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pb link entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (PBLinkEntry pbLinkEntry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(pbLinkEntry);
		}
	}

	/**
	 * Returns the number of pb link entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching pb link entries
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PBLINKENTRY_WHERE);

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
		"pbLinkEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"pbLinkEntry.status = ?";

	public PBLinkEntryPersistenceImpl() {
		setModelClass(PBLinkEntry.class);

		setModelImplClass(PBLinkEntryImpl.class);
		setModelPKClass(long.class);

		setTable(PBLinkEntryTable.INSTANCE);
	}

	/**
	 * Caches the pb link entry in the entity cache if it is enabled.
	 *
	 * @param pbLinkEntry the pb link entry
	 */
	@Override
	public void cacheResult(PBLinkEntry pbLinkEntry) {
		entityCache.putResult(
			PBLinkEntryImpl.class, pbLinkEntry.getPrimaryKey(), pbLinkEntry);

		finderCache.putResult(
			_finderPathFetchByD_D_N,
			new Object[] {
				pbLinkEntry.getPbLinkEntryId(), pbLinkEntry.getDescription(),
				pbLinkEntry.getName()
			},
			pbLinkEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pb link entries in the entity cache if it is enabled.
	 *
	 * @param pbLinkEntries the pb link entries
	 */
	@Override
	public void cacheResult(List<PBLinkEntry> pbLinkEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (pbLinkEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PBLinkEntry pbLinkEntry : pbLinkEntries) {
			if (entityCache.getResult(
					PBLinkEntryImpl.class, pbLinkEntry.getPrimaryKey()) ==
						null) {

				cacheResult(pbLinkEntry);
			}
		}
	}

	/**
	 * Clears the cache for all pb link entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PBLinkEntryImpl.class);

		finderCache.clearCache(PBLinkEntryImpl.class);
	}

	/**
	 * Clears the cache for the pb link entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PBLinkEntry pbLinkEntry) {
		entityCache.removeResult(PBLinkEntryImpl.class, pbLinkEntry);
	}

	@Override
	public void clearCache(List<PBLinkEntry> pbLinkEntries) {
		for (PBLinkEntry pbLinkEntry : pbLinkEntries) {
			entityCache.removeResult(PBLinkEntryImpl.class, pbLinkEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PBLinkEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PBLinkEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PBLinkEntryModelImpl pbLinkEntryModelImpl) {

		Object[] args = new Object[] {
			pbLinkEntryModelImpl.getPbLinkEntryId(),
			pbLinkEntryModelImpl.getDescription(),
			pbLinkEntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByD_D_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByD_D_N, args, pbLinkEntryModelImpl);
	}

	/**
	 * Creates a new pb link entry with the primary key. Does not add the pb link entry to the database.
	 *
	 * @param pbLinkEntryId the primary key for the new pb link entry
	 * @return the new pb link entry
	 */
	@Override
	public PBLinkEntry create(long pbLinkEntryId) {
		PBLinkEntry pbLinkEntry = new PBLinkEntryImpl();

		pbLinkEntry.setNew(true);
		pbLinkEntry.setPrimaryKey(pbLinkEntryId);

		pbLinkEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return pbLinkEntry;
	}

	/**
	 * Removes the pb link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry that was removed
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	@Override
	public PBLinkEntry remove(long pbLinkEntryId) throws NoSuchEntryException {
		return remove((Serializable)pbLinkEntryId);
	}

	/**
	 * Removes the pb link entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pb link entry
	 * @return the pb link entry that was removed
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	@Override
	public PBLinkEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {

		Session session = null;

		try {
			session = openSession();

			PBLinkEntry pbLinkEntry = (PBLinkEntry)session.get(
				PBLinkEntryImpl.class, primaryKey);

			if (pbLinkEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pbLinkEntry);
		}
		catch (NoSuchEntryException noSuchEntityException) {
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
	protected PBLinkEntry removeImpl(PBLinkEntry pbLinkEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pbLinkEntry)) {
				pbLinkEntry = (PBLinkEntry)session.get(
					PBLinkEntryImpl.class, pbLinkEntry.getPrimaryKeyObj());
			}

			if (pbLinkEntry != null) {
				session.delete(pbLinkEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pbLinkEntry != null) {
			clearCache(pbLinkEntry);
		}

		return pbLinkEntry;
	}

	@Override
	public PBLinkEntry updateImpl(PBLinkEntry pbLinkEntry) {
		boolean isNew = pbLinkEntry.isNew();

		if (!(pbLinkEntry instanceof PBLinkEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pbLinkEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(pbLinkEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pbLinkEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PBLinkEntry implementation " +
					pbLinkEntry.getClass());
		}

		PBLinkEntryModelImpl pbLinkEntryModelImpl =
			(PBLinkEntryModelImpl)pbLinkEntry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (pbLinkEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				pbLinkEntry.setCreateDate(date);
			}
			else {
				pbLinkEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!pbLinkEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pbLinkEntry.setModifiedDate(date);
			}
			else {
				pbLinkEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pbLinkEntry);
			}
			else {
				pbLinkEntry = (PBLinkEntry)session.merge(pbLinkEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PBLinkEntryImpl.class, pbLinkEntryModelImpl, false, true);

		cacheUniqueFindersCache(pbLinkEntryModelImpl);

		if (isNew) {
			pbLinkEntry.setNew(false);
		}

		pbLinkEntry.resetOriginalValues();

		return pbLinkEntry;
	}

	/**
	 * Returns the pb link entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pb link entry
	 * @return the pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	@Override
	public PBLinkEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {

		PBLinkEntry pbLinkEntry = fetchByPrimaryKey(primaryKey);

		if (pbLinkEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pbLinkEntry;
	}

	/**
	 * Returns the pb link entry with the primary key or throws a <code>NoSuchEntryException</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry
	 * @throws NoSuchEntryException if a pb link entry with the primary key could not be found
	 */
	@Override
	public PBLinkEntry findByPrimaryKey(long pbLinkEntryId)
		throws NoSuchEntryException {

		return findByPrimaryKey((Serializable)pbLinkEntryId);
	}

	/**
	 * Returns the pb link entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pbLinkEntryId the primary key of the pb link entry
	 * @return the pb link entry, or <code>null</code> if a pb link entry with the primary key could not be found
	 */
	@Override
	public PBLinkEntry fetchByPrimaryKey(long pbLinkEntryId) {
		return fetchByPrimaryKey((Serializable)pbLinkEntryId);
	}

	/**
	 * Returns all the pb link entries.
	 *
	 * @return the pb link entries
	 */
	@Override
	public List<PBLinkEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PBLinkEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PBLinkEntry> findAll(
		int start, int end, OrderByComparator<PBLinkEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PBLinkEntry> findAll(
		int start, int end, OrderByComparator<PBLinkEntry> orderByComparator,
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

		List<PBLinkEntry> list = null;

		if (useFinderCache) {
			list = (List<PBLinkEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PBLINKENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PBLINKENTRY;

				sql = sql.concat(PBLinkEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PBLinkEntry>)QueryUtil.list(
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
	 * Removes all the pb link entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PBLinkEntry pbLinkEntry : findAll()) {
			remove(pbLinkEntry);
		}
	}

	/**
	 * Returns the number of pb link entries.
	 *
	 * @return the number of pb link entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PBLINKENTRY);

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
		return "pbLinkEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PBLINKENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PBLinkEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pb link entry persistence.
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

		_finderPathWithPaginationFindBypbLinkEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypbLinkEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"pbLinkEntryId"}, true);

		_finderPathWithoutPaginationFindBypbLinkEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypbLinkEntryId",
			new String[] {Long.class.getName()}, new String[] {"pbLinkEntryId"},
			true);

		_finderPathCountBypbLinkEntryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypbLinkEntryId",
			new String[] {Long.class.getName()}, new String[] {"pbLinkEntryId"},
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
			new String[] {"pbLinkEntryId", "description", "name"}, true);

		_finderPathCountByD_D_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"pbLinkEntryId", "description", "name"}, false);

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

		_setPBLinkEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPBLinkEntryUtilPersistence(null);

		entityCache.removeCache(PBLinkEntryImpl.class.getName());
	}

	private void _setPBLinkEntryUtilPersistence(
		PBLinkEntryPersistence pbLinkEntryPersistence) {

		try {
			Field field = PBLinkEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, pbLinkEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PBLinkPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PBLinkPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PBLinkPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PBLINKENTRY =
		"SELECT pbLinkEntry FROM PBLinkEntry pbLinkEntry";

	private static final String _SQL_SELECT_PBLINKENTRY_WHERE =
		"SELECT pbLinkEntry FROM PBLinkEntry pbLinkEntry WHERE ";

	private static final String _SQL_COUNT_PBLINKENTRY =
		"SELECT COUNT(pbLinkEntry) FROM PBLinkEntry pbLinkEntry";

	private static final String _SQL_COUNT_PBLINKENTRY_WHERE =
		"SELECT COUNT(pbLinkEntry) FROM PBLinkEntry pbLinkEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pbLinkEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PBLinkEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PBLinkEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PBLinkEntryPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}