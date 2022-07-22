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

package com.liferay.message.boards.service.persistence.impl;

import com.liferay.message.boards.exception.NoSuchSuspiciousActivityTypeException;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.message.boards.model.MBSuspiciousActivityTypeTable;
import com.liferay.message.boards.model.impl.MBSuspiciousActivityTypeImpl;
import com.liferay.message.boards.model.impl.MBSuspiciousActivityTypeModelImpl;
import com.liferay.message.boards.service.persistence.MBSuspiciousActivityTypePersistence;
import com.liferay.message.boards.service.persistence.MBSuspiciousActivityTypeUtil;
import com.liferay.message.boards.service.persistence.impl.constants.MBPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.change.tracking.CTColumnResolutionType;
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
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.change.tracking.helper.CTPersistenceHelper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
 * The persistence implementation for the message boards suspicious activity type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {MBSuspiciousActivityTypePersistence.class, BasePersistence.class}
)
public class MBSuspiciousActivityTypePersistenceImpl
	extends BasePersistenceImpl<MBSuspiciousActivityType>
	implements MBSuspiciousActivityTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MBSuspiciousActivityTypeUtil</code> to access the message boards suspicious activity type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MBSuspiciousActivityTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the message boards suspicious activity types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching message boards suspicious activity types
	 */
	@Override
	public List<MBSuspiciousActivityType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<MBSuspiciousActivityType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache && productionMode) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache && productionMode) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<MBSuspiciousActivityType> list = null;

		if (useFinderCache && productionMode) {
			list = (List<MBSuspiciousActivityType>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MBSuspiciousActivityType mbSuspiciousActivityType : list) {
					if (!uuid.equals(mbSuspiciousActivityType.getUuid())) {
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

			sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MBSuspiciousActivityTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<MBSuspiciousActivityType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache && productionMode) {
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
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType findByUuid_First(
			String uuid,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = fetchByUuid_First(
			uuid, orderByComparator);

		if (mbSuspiciousActivityType != null) {
			return mbSuspiciousActivityType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSuspiciousActivityTypeException(sb.toString());
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByUuid_First(
		String uuid,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		List<MBSuspiciousActivityType> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType findByUuid_Last(
			String uuid,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = fetchByUuid_Last(
			uuid, orderByComparator);

		if (mbSuspiciousActivityType != null) {
			return mbSuspiciousActivityType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSuspiciousActivityTypeException(sb.toString());
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByUuid_Last(
		String uuid,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MBSuspiciousActivityType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MBSuspiciousActivityType[] findByUuid_PrevAndNext(
			long suspiciousActivityTypeId, String uuid,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		uuid = Objects.toString(uuid, "");

		MBSuspiciousActivityType mbSuspiciousActivityType = findByPrimaryKey(
			suspiciousActivityTypeId);

		Session session = null;

		try {
			session = openSession();

			MBSuspiciousActivityType[] array =
				new MBSuspiciousActivityTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, mbSuspiciousActivityType, uuid, orderByComparator,
				true);

			array[1] = mbSuspiciousActivityType;

			array[2] = getByUuid_PrevAndNext(
				session, mbSuspiciousActivityType, uuid, orderByComparator,
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

	protected MBSuspiciousActivityType getByUuid_PrevAndNext(
		Session session, MBSuspiciousActivityType mbSuspiciousActivityType,
		String uuid,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(MBSuspiciousActivityTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mbSuspiciousActivityType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MBSuspiciousActivityType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the message boards suspicious activity types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MBSuspiciousActivityType mbSuspiciousActivityType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mbSuspiciousActivityType);
		}
	}

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching message boards suspicious activity types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		Long count = null;

		if (productionMode) {
			finderPath = _finderPathCountByUuid;

			finderArgs = new Object[] {uuid};

			count = (Long)finderCache.getResult(finderPath, finderArgs);
		}

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				if (productionMode) {
					finderCache.putResult(finderPath, finderArgs, count);
				}
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"mbSuspiciousActivityType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(mbSuspiciousActivityType.uuid IS NULL OR mbSuspiciousActivityType.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSuspiciousActivityTypeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType findByUUID_G(String uuid, long groupId)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = fetchByUUID_G(
			uuid, groupId);

		if (mbSuspiciousActivityType == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSuspiciousActivityTypeException(sb.toString());
		}

		return mbSuspiciousActivityType;
	}

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the message boards suspicious activity type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		Object[] finderArgs = null;

		if (useFinderCache && productionMode) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache && productionMode) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof MBSuspiciousActivityType) {
			MBSuspiciousActivityType mbSuspiciousActivityType =
				(MBSuspiciousActivityType)result;

			if (!Objects.equals(uuid, mbSuspiciousActivityType.getUuid()) ||
				(groupId != mbSuspiciousActivityType.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<MBSuspiciousActivityType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache && productionMode) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					MBSuspiciousActivityType mbSuspiciousActivityType =
						list.get(0);

					result = mbSuspiciousActivityType;

					cacheResult(mbSuspiciousActivityType);
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
			return (MBSuspiciousActivityType)result;
		}
	}

	/**
	 * Removes the message boards suspicious activity type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the message boards suspicious activity type that was removed
	 */
	@Override
	public MBSuspiciousActivityType removeByUUID_G(String uuid, long groupId)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = findByUUID_G(
			uuid, groupId);

		return remove(mbSuspiciousActivityType);
	}

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching message boards suspicious activity types
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		Long count = null;

		if (productionMode) {
			finderPath = _finderPathCountByUUID_G;

			finderArgs = new Object[] {uuid, groupId};

			count = (Long)finderCache.getResult(finderPath, finderArgs);
		}

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				if (productionMode) {
					finderCache.putResult(finderPath, finderArgs, count);
				}
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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"mbSuspiciousActivityType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(mbSuspiciousActivityType.uuid IS NULL OR mbSuspiciousActivityType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"mbSuspiciousActivityType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching message boards suspicious activity types
	 */
	@Override
	public List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<MBSuspiciousActivityType> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache && productionMode) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache && productionMode) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<MBSuspiciousActivityType> list = null;

		if (useFinderCache && productionMode) {
			list = (List<MBSuspiciousActivityType>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MBSuspiciousActivityType mbSuspiciousActivityType : list) {
					if (!uuid.equals(mbSuspiciousActivityType.getUuid()) ||
						(companyId !=
							mbSuspiciousActivityType.getCompanyId())) {

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

			sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MBSuspiciousActivityTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<MBSuspiciousActivityType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache && productionMode) {
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
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (mbSuspiciousActivityType != null) {
			return mbSuspiciousActivityType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSuspiciousActivityTypeException(sb.toString());
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		List<MBSuspiciousActivityType> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MBSuspiciousActivityType findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (mbSuspiciousActivityType != null) {
			return mbSuspiciousActivityType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSuspiciousActivityTypeException(sb.toString());
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MBSuspiciousActivityType> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MBSuspiciousActivityType[] findByUuid_C_PrevAndNext(
			long suspiciousActivityTypeId, String uuid, long companyId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		uuid = Objects.toString(uuid, "");

		MBSuspiciousActivityType mbSuspiciousActivityType = findByPrimaryKey(
			suspiciousActivityTypeId);

		Session session = null;

		try {
			session = openSession();

			MBSuspiciousActivityType[] array =
				new MBSuspiciousActivityTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, mbSuspiciousActivityType, uuid, companyId,
				orderByComparator, true);

			array[1] = mbSuspiciousActivityType;

			array[2] = getByUuid_C_PrevAndNext(
				session, mbSuspiciousActivityType, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MBSuspiciousActivityType getByUuid_C_PrevAndNext(
		Session session, MBSuspiciousActivityType mbSuspiciousActivityType,
		String uuid, long companyId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(MBSuspiciousActivityTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mbSuspiciousActivityType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MBSuspiciousActivityType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the message boards suspicious activity types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MBSuspiciousActivityType mbSuspiciousActivityType :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(mbSuspiciousActivityType);
		}
	}

	/**
	 * Returns the number of message boards suspicious activity types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching message boards suspicious activity types
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		Long count = null;

		if (productionMode) {
			finderPath = _finderPathCountByUuid_C;

			finderArgs = new Object[] {uuid, companyId};

			count = (Long)finderCache.getResult(finderPath, finderArgs);
		}

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				if (productionMode) {
					finderCache.putResult(finderPath, finderArgs, count);
				}
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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"mbSuspiciousActivityType.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(mbSuspiciousActivityType.uuid IS NULL OR mbSuspiciousActivityType.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"mbSuspiciousActivityType.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBySuspiciousActivityTypeId;
	private FinderPath
		_finderPathWithoutPaginationFindBySuspiciousActivityTypeId;
	private FinderPath _finderPathCountBySuspiciousActivityTypeId;

	/**
	 * Returns all the message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @return the matching message boards suspicious activity types
	 */
	@Override
	public List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId) {

		return findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId, int start, int end) {

		return findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, start, end, null);
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
	@Override
	public List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, start, end, orderByComparator, true);
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
	@Override
	public List<MBSuspiciousActivityType> findBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId, int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache && productionMode) {
				finderPath =
					_finderPathWithoutPaginationFindBySuspiciousActivityTypeId;
				finderArgs = new Object[] {suspiciousActivityTypeId};
			}
		}
		else if (useFinderCache && productionMode) {
			finderPath =
				_finderPathWithPaginationFindBySuspiciousActivityTypeId;
			finderArgs = new Object[] {
				suspiciousActivityTypeId, start, end, orderByComparator
			};
		}

		List<MBSuspiciousActivityType> list = null;

		if (useFinderCache && productionMode) {
			list = (List<MBSuspiciousActivityType>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MBSuspiciousActivityType mbSuspiciousActivityType : list) {
					if (suspiciousActivityTypeId !=
							mbSuspiciousActivityType.
								getSuspiciousActivityTypeId()) {

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

			sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			sb.append(
				_FINDER_COLUMN_SUSPICIOUSACTIVITYTYPEID_SUSPICIOUSACTIVITYTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MBSuspiciousActivityTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(suspiciousActivityTypeId);

				list = (List<MBSuspiciousActivityType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache && productionMode) {
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
	 * Returns the first message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType findBySuspiciousActivityTypeId_First(
			long suspiciousActivityTypeId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType =
			fetchBySuspiciousActivityTypeId_First(
				suspiciousActivityTypeId, orderByComparator);

		if (mbSuspiciousActivityType != null) {
			return mbSuspiciousActivityType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("suspiciousActivityTypeId=");
		sb.append(suspiciousActivityTypeId);

		sb.append("}");

		throw new NoSuchSuspiciousActivityTypeException(sb.toString());
	}

	/**
	 * Returns the first message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchBySuspiciousActivityTypeId_First(
		long suspiciousActivityTypeId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		List<MBSuspiciousActivityType> list = findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType findBySuspiciousActivityTypeId_Last(
			long suspiciousActivityTypeId,
			OrderByComparator<MBSuspiciousActivityType> orderByComparator)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType =
			fetchBySuspiciousActivityTypeId_Last(
				suspiciousActivityTypeId, orderByComparator);

		if (mbSuspiciousActivityType != null) {
			return mbSuspiciousActivityType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("suspiciousActivityTypeId=");
		sb.append(suspiciousActivityTypeId);

		sb.append("}");

		throw new NoSuchSuspiciousActivityTypeException(sb.toString());
	}

	/**
	 * Returns the last message boards suspicious activity type in the ordered set where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message boards suspicious activity type, or <code>null</code> if a matching message boards suspicious activity type could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchBySuspiciousActivityTypeId_Last(
		long suspiciousActivityTypeId,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		int count = countBySuspiciousActivityTypeId(suspiciousActivityTypeId);

		if (count == 0) {
			return null;
		}

		List<MBSuspiciousActivityType> list = findBySuspiciousActivityTypeId(
			suspiciousActivityTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the message boards suspicious activity types where suspiciousActivityTypeId = &#63; from the database.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 */
	@Override
	public void removeBySuspiciousActivityTypeId(
		long suspiciousActivityTypeId) {

		for (MBSuspiciousActivityType mbSuspiciousActivityType :
				findBySuspiciousActivityTypeId(
					suspiciousActivityTypeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(mbSuspiciousActivityType);
		}
	}

	/**
	 * Returns the number of message boards suspicious activity types where suspiciousActivityTypeId = &#63;.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID
	 * @return the number of matching message boards suspicious activity types
	 */
	@Override
	public int countBySuspiciousActivityTypeId(long suspiciousActivityTypeId) {
		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		Long count = null;

		if (productionMode) {
			finderPath = _finderPathCountBySuspiciousActivityTypeId;

			finderArgs = new Object[] {suspiciousActivityTypeId};

			count = (Long)finderCache.getResult(finderPath, finderArgs);
		}

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE_WHERE);

			sb.append(
				_FINDER_COLUMN_SUSPICIOUSACTIVITYTYPEID_SUSPICIOUSACTIVITYTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(suspiciousActivityTypeId);

				count = (Long)query.uniqueResult();

				if (productionMode) {
					finderCache.putResult(finderPath, finderArgs, count);
				}
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

	private static final String
		_FINDER_COLUMN_SUSPICIOUSACTIVITYTYPEID_SUSPICIOUSACTIVITYTYPEID_2 =
			"mbSuspiciousActivityType.suspiciousActivityTypeId = ?";

	public MBSuspiciousActivityTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MBSuspiciousActivityType.class);

		setModelImplClass(MBSuspiciousActivityTypeImpl.class);
		setModelPKClass(long.class);

		setTable(MBSuspiciousActivityTypeTable.INSTANCE);
	}

	/**
	 * Caches the message boards suspicious activity type in the entity cache if it is enabled.
	 *
	 * @param mbSuspiciousActivityType the message boards suspicious activity type
	 */
	@Override
	public void cacheResult(MBSuspiciousActivityType mbSuspiciousActivityType) {
		if (mbSuspiciousActivityType.getCtCollectionId() != 0) {
			return;
		}

		entityCache.putResult(
			MBSuspiciousActivityTypeImpl.class,
			mbSuspiciousActivityType.getPrimaryKey(), mbSuspiciousActivityType);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				mbSuspiciousActivityType.getUuid(),
				mbSuspiciousActivityType.getGroupId()
			},
			mbSuspiciousActivityType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the message boards suspicious activity types in the entity cache if it is enabled.
	 *
	 * @param mbSuspiciousActivityTypes the message boards suspicious activity types
	 */
	@Override
	public void cacheResult(
		List<MBSuspiciousActivityType> mbSuspiciousActivityTypes) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mbSuspiciousActivityTypes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MBSuspiciousActivityType mbSuspiciousActivityType :
				mbSuspiciousActivityTypes) {

			if (mbSuspiciousActivityType.getCtCollectionId() != 0) {
				continue;
			}

			if (entityCache.getResult(
					MBSuspiciousActivityTypeImpl.class,
					mbSuspiciousActivityType.getPrimaryKey()) == null) {

				cacheResult(mbSuspiciousActivityType);
			}
		}
	}

	/**
	 * Clears the cache for all message boards suspicious activity types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MBSuspiciousActivityTypeImpl.class);

		finderCache.clearCache(MBSuspiciousActivityTypeImpl.class);
	}

	/**
	 * Clears the cache for the message boards suspicious activity type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MBSuspiciousActivityType mbSuspiciousActivityType) {
		entityCache.removeResult(
			MBSuspiciousActivityTypeImpl.class, mbSuspiciousActivityType);
	}

	@Override
	public void clearCache(
		List<MBSuspiciousActivityType> mbSuspiciousActivityTypes) {

		for (MBSuspiciousActivityType mbSuspiciousActivityType :
				mbSuspiciousActivityTypes) {

			entityCache.removeResult(
				MBSuspiciousActivityTypeImpl.class, mbSuspiciousActivityType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MBSuspiciousActivityTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				MBSuspiciousActivityTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MBSuspiciousActivityTypeModelImpl mbSuspiciousActivityTypeModelImpl) {

		Object[] args = new Object[] {
			mbSuspiciousActivityTypeModelImpl.getUuid(),
			mbSuspiciousActivityTypeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, mbSuspiciousActivityTypeModelImpl);
	}

	/**
	 * Creates a new message boards suspicious activity type with the primary key. Does not add the message boards suspicious activity type to the database.
	 *
	 * @param suspiciousActivityTypeId the primary key for the new message boards suspicious activity type
	 * @return the new message boards suspicious activity type
	 */
	@Override
	public MBSuspiciousActivityType create(long suspiciousActivityTypeId) {
		MBSuspiciousActivityType mbSuspiciousActivityType =
			new MBSuspiciousActivityTypeImpl();

		mbSuspiciousActivityType.setNew(true);
		mbSuspiciousActivityType.setPrimaryKey(suspiciousActivityTypeId);

		String uuid = _portalUUID.generate();

		mbSuspiciousActivityType.setUuid(uuid);

		mbSuspiciousActivityType.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return mbSuspiciousActivityType;
	}

	/**
	 * Removes the message boards suspicious activity type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was removed
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType remove(long suspiciousActivityTypeId)
		throws NoSuchSuspiciousActivityTypeException {

		return remove((Serializable)suspiciousActivityTypeId);
	}

	/**
	 * Removes the message boards suspicious activity type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type that was removed
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType remove(Serializable primaryKey)
		throws NoSuchSuspiciousActivityTypeException {

		Session session = null;

		try {
			session = openSession();

			MBSuspiciousActivityType mbSuspiciousActivityType =
				(MBSuspiciousActivityType)session.get(
					MBSuspiciousActivityTypeImpl.class, primaryKey);

			if (mbSuspiciousActivityType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSuspiciousActivityTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mbSuspiciousActivityType);
		}
		catch (NoSuchSuspiciousActivityTypeException noSuchEntityException) {
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
	protected MBSuspiciousActivityType removeImpl(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mbSuspiciousActivityType)) {
				mbSuspiciousActivityType =
					(MBSuspiciousActivityType)session.get(
						MBSuspiciousActivityTypeImpl.class,
						mbSuspiciousActivityType.getPrimaryKeyObj());
			}

			if ((mbSuspiciousActivityType != null) &&
				ctPersistenceHelper.isRemove(mbSuspiciousActivityType)) {

				session.delete(mbSuspiciousActivityType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mbSuspiciousActivityType != null) {
			clearCache(mbSuspiciousActivityType);
		}

		return mbSuspiciousActivityType;
	}

	@Override
	public MBSuspiciousActivityType updateImpl(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		boolean isNew = mbSuspiciousActivityType.isNew();

		if (!(mbSuspiciousActivityType instanceof
				MBSuspiciousActivityTypeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mbSuspiciousActivityType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mbSuspiciousActivityType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mbSuspiciousActivityType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MBSuspiciousActivityType implementation " +
					mbSuspiciousActivityType.getClass());
		}

		MBSuspiciousActivityTypeModelImpl mbSuspiciousActivityTypeModelImpl =
			(MBSuspiciousActivityTypeModelImpl)mbSuspiciousActivityType;

		if (Validator.isNull(mbSuspiciousActivityType.getUuid())) {
			String uuid = _portalUUID.generate();

			mbSuspiciousActivityType.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mbSuspiciousActivityType.getCreateDate() == null)) {
			if (serviceContext == null) {
				mbSuspiciousActivityType.setCreateDate(date);
			}
			else {
				mbSuspiciousActivityType.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mbSuspiciousActivityTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mbSuspiciousActivityType.setModifiedDate(date);
			}
			else {
				mbSuspiciousActivityType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ctPersistenceHelper.isInsert(mbSuspiciousActivityType)) {
				if (!isNew) {
					session.evict(
						MBSuspiciousActivityTypeImpl.class,
						mbSuspiciousActivityType.getPrimaryKeyObj());
				}

				session.save(mbSuspiciousActivityType);
			}
			else {
				mbSuspiciousActivityType =
					(MBSuspiciousActivityType)session.merge(
						mbSuspiciousActivityType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mbSuspiciousActivityType.getCtCollectionId() != 0) {
			if (isNew) {
				mbSuspiciousActivityType.setNew(false);
			}

			mbSuspiciousActivityType.resetOriginalValues();

			return mbSuspiciousActivityType;
		}

		entityCache.putResult(
			MBSuspiciousActivityTypeImpl.class,
			mbSuspiciousActivityTypeModelImpl, false, true);

		cacheUniqueFindersCache(mbSuspiciousActivityTypeModelImpl);

		if (isNew) {
			mbSuspiciousActivityType.setNew(false);
		}

		mbSuspiciousActivityType.resetOriginalValues();

		return mbSuspiciousActivityType;
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSuspiciousActivityTypeException {

		MBSuspiciousActivityType mbSuspiciousActivityType = fetchByPrimaryKey(
			primaryKey);

		if (mbSuspiciousActivityType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSuspiciousActivityTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mbSuspiciousActivityType;
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key or throws a <code>NoSuchSuspiciousActivityTypeException</code> if it could not be found.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type
	 * @throws NoSuchSuspiciousActivityTypeException if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType findByPrimaryKey(
			long suspiciousActivityTypeId)
		throws NoSuchSuspiciousActivityTypeException {

		return findByPrimaryKey((Serializable)suspiciousActivityTypeId);
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type, or <code>null</code> if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByPrimaryKey(Serializable primaryKey) {
		if (ctPersistenceHelper.isProductionMode(
				MBSuspiciousActivityType.class, primaryKey)) {

			return super.fetchByPrimaryKey(primaryKey);
		}

		MBSuspiciousActivityType mbSuspiciousActivityType = null;

		Session session = null;

		try {
			session = openSession();

			mbSuspiciousActivityType = (MBSuspiciousActivityType)session.get(
				MBSuspiciousActivityTypeImpl.class, primaryKey);

			if (mbSuspiciousActivityType != null) {
				cacheResult(mbSuspiciousActivityType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return mbSuspiciousActivityType;
	}

	/**
	 * Returns the message boards suspicious activity type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param suspiciousActivityTypeId the primary key of the message boards suspicious activity type
	 * @return the message boards suspicious activity type, or <code>null</code> if a message boards suspicious activity type with the primary key could not be found
	 */
	@Override
	public MBSuspiciousActivityType fetchByPrimaryKey(
		long suspiciousActivityTypeId) {

		return fetchByPrimaryKey((Serializable)suspiciousActivityTypeId);
	}

	@Override
	public Map<Serializable, MBSuspiciousActivityType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (ctPersistenceHelper.isProductionMode(
				MBSuspiciousActivityType.class)) {

			return super.fetchByPrimaryKeys(primaryKeys);
		}

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MBSuspiciousActivityType> map =
			new HashMap<Serializable, MBSuspiciousActivityType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MBSuspiciousActivityType mbSuspiciousActivityType =
				fetchByPrimaryKey(primaryKey);

			if (mbSuspiciousActivityType != null) {
				map.put(primaryKey, mbSuspiciousActivityType);
			}

			return map;
		}

		if ((databaseInMaxParameters > 0) &&
			(primaryKeys.size() > databaseInMaxParameters)) {

			Iterator<Serializable> iterator = primaryKeys.iterator();

			while (iterator.hasNext()) {
				Set<Serializable> page = new HashSet<>();

				for (int i = 0;
					 (i < databaseInMaxParameters) && iterator.hasNext(); i++) {

					page.add(iterator.next());
				}

				map.putAll(fetchByPrimaryKeys(page));
			}

			return map;
		}

		StringBundler sb = new StringBundler((primaryKeys.size() * 2) + 1);

		sb.append(getSelectSQL());
		sb.append(" WHERE ");
		sb.append(getPKDBName());
		sb.append(" IN (");

		for (Serializable primaryKey : primaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (MBSuspiciousActivityType mbSuspiciousActivityType :
					(List<MBSuspiciousActivityType>)query.list()) {

				map.put(
					mbSuspiciousActivityType.getPrimaryKeyObj(),
					mbSuspiciousActivityType);

				cacheResult(mbSuspiciousActivityType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the message boards suspicious activity types.
	 *
	 * @return the message boards suspicious activity types
	 */
	@Override
	public List<MBSuspiciousActivityType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MBSuspiciousActivityType> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MBSuspiciousActivityType> findAll(
		int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MBSuspiciousActivityType> findAll(
		int start, int end,
		OrderByComparator<MBSuspiciousActivityType> orderByComparator,
		boolean useFinderCache) {

		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache && productionMode) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache && productionMode) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MBSuspiciousActivityType> list = null;

		if (useFinderCache && productionMode) {
			list = (List<MBSuspiciousActivityType>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE;

				sql = sql.concat(
					MBSuspiciousActivityTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MBSuspiciousActivityType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache && productionMode) {
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
	 * Removes all the message boards suspicious activity types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MBSuspiciousActivityType mbSuspiciousActivityType : findAll()) {
			remove(mbSuspiciousActivityType);
		}
	}

	/**
	 * Returns the number of message boards suspicious activity types.
	 *
	 * @return the number of message boards suspicious activity types
	 */
	@Override
	public int countAll() {
		boolean productionMode = ctPersistenceHelper.isProductionMode(
			MBSuspiciousActivityType.class);

		Long count = null;

		if (productionMode) {
			count = (Long)finderCache.getResult(
				_finderPathCountAll, FINDER_ARGS_EMPTY);
		}

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE);

				count = (Long)query.uniqueResult();

				if (productionMode) {
					finderCache.putResult(
						_finderPathCountAll, FINDER_ARGS_EMPTY, count);
				}
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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "suspiciousActivityTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE;
	}

	@Override
	public Set<String> getCTColumnNames(
		CTColumnResolutionType ctColumnResolutionType) {

		return _ctColumnNamesMap.getOrDefault(
			ctColumnResolutionType, Collections.emptySet());
	}

	@Override
	public List<String> getMappingTableNames() {
		return _mappingTableNames;
	}

	@Override
	public Map<String, Integer> getTableColumnsMap() {
		return MBSuspiciousActivityTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	@Override
	public String getTableName() {
		return "MBSuspiciousActivityType";
	}

	@Override
	public List<String[]> getUniqueIndexColumnNames() {
		return _uniqueIndexColumnNames;
	}

	private static final Map<CTColumnResolutionType, Set<String>>
		_ctColumnNamesMap = new EnumMap<CTColumnResolutionType, Set<String>>(
			CTColumnResolutionType.class);
	private static final List<String> _mappingTableNames =
		new ArrayList<String>();
	private static final List<String[]> _uniqueIndexColumnNames =
		new ArrayList<String[]>();

	static {
		Set<String> ctControlColumnNames = new HashSet<String>();
		Set<String> ctIgnoreColumnNames = new HashSet<String>();
		Set<String> ctStrictColumnNames = new HashSet<String>();

		ctControlColumnNames.add("mvccVersion");
		ctControlColumnNames.add("ctCollectionId");
		ctStrictColumnNames.add("uuid_");
		ctStrictColumnNames.add("groupId");
		ctStrictColumnNames.add("companyId");
		ctStrictColumnNames.add("userId");
		ctStrictColumnNames.add("userName");
		ctStrictColumnNames.add("createDate");
		ctIgnoreColumnNames.add("modifiedDate");
		ctStrictColumnNames.add("description");

		_ctColumnNamesMap.put(
			CTColumnResolutionType.CONTROL, ctControlColumnNames);
		_ctColumnNamesMap.put(
			CTColumnResolutionType.IGNORE, ctIgnoreColumnNames);
		_ctColumnNamesMap.put(
			CTColumnResolutionType.PK,
			Collections.singleton("suspiciousActivityTypeId"));
		_ctColumnNamesMap.put(
			CTColumnResolutionType.STRICT, ctStrictColumnNames);

		_uniqueIndexColumnNames.add(new String[] {"uuid_", "groupId"});
	}

	/**
	 * Initializes the message boards suspicious activity type persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBySuspiciousActivityTypeId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBySuspiciousActivityTypeId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"suspiciousActivityTypeId"}, true);

		_finderPathWithoutPaginationFindBySuspiciousActivityTypeId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBySuspiciousActivityTypeId",
				new String[] {Long.class.getName()},
				new String[] {"suspiciousActivityTypeId"}, true);

		_finderPathCountBySuspiciousActivityTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySuspiciousActivityTypeId",
			new String[] {Long.class.getName()},
			new String[] {"suspiciousActivityTypeId"}, false);

		_setMBSuspiciousActivityTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMBSuspiciousActivityTypeUtilPersistence(null);

		entityCache.removeCache(MBSuspiciousActivityTypeImpl.class.getName());
	}

	private void _setMBSuspiciousActivityTypeUtilPersistence(
		MBSuspiciousActivityTypePersistence
			mbSuspiciousActivityTypePersistence) {

		try {
			Field field = MBSuspiciousActivityTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mbSuspiciousActivityTypePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected CTPersistenceHelper ctPersistenceHelper;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE =
		"SELECT mbSuspiciousActivityType FROM MBSuspiciousActivityType mbSuspiciousActivityType";

	private static final String _SQL_SELECT_MBSUSPICIOUSACTIVITYTYPE_WHERE =
		"SELECT mbSuspiciousActivityType FROM MBSuspiciousActivityType mbSuspiciousActivityType WHERE ";

	private static final String _SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE =
		"SELECT COUNT(mbSuspiciousActivityType) FROM MBSuspiciousActivityType mbSuspiciousActivityType";

	private static final String _SQL_COUNT_MBSUSPICIOUSACTIVITYTYPE_WHERE =
		"SELECT COUNT(mbSuspiciousActivityType) FROM MBSuspiciousActivityType mbSuspiciousActivityType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"mbSuspiciousActivityType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MBSuspiciousActivityType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MBSuspiciousActivityType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MBSuspiciousActivityTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private MBSuspiciousActivityTypeModelArgumentsResolver
		_mbSuspiciousActivityTypeModelArgumentsResolver;

}