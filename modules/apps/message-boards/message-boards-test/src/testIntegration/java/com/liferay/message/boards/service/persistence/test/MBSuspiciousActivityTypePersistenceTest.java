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

package com.liferay.message.boards.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.message.boards.exception.NoSuchSuspiciousActivityTypeException;
import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.message.boards.service.MBSuspiciousActivityTypeLocalServiceUtil;
import com.liferay.message.boards.service.persistence.MBSuspiciousActivityTypePersistence;
import com.liferay.message.boards.service.persistence.MBSuspiciousActivityTypeUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class MBSuspiciousActivityTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.message.boards.service"));

	@Before
	public void setUp() {
		_persistence = MBSuspiciousActivityTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<MBSuspiciousActivityType> iterator =
			_mbSuspiciousActivityTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MBSuspiciousActivityType mbSuspiciousActivityType = _persistence.create(
			pk);

		Assert.assertNotNull(mbSuspiciousActivityType);

		Assert.assertEquals(mbSuspiciousActivityType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		_persistence.remove(newMBSuspiciousActivityType);

		MBSuspiciousActivityType existingMBSuspiciousActivityType =
			_persistence.fetchByPrimaryKey(
				newMBSuspiciousActivityType.getPrimaryKey());

		Assert.assertNull(existingMBSuspiciousActivityType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addMBSuspiciousActivityType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MBSuspiciousActivityType newMBSuspiciousActivityType =
			_persistence.create(pk);

		newMBSuspiciousActivityType.setMvccVersion(RandomTestUtil.nextLong());

		newMBSuspiciousActivityType.setCtCollectionId(
			RandomTestUtil.nextLong());

		newMBSuspiciousActivityType.setUuid(RandomTestUtil.randomString());

		newMBSuspiciousActivityType.setGroupId(RandomTestUtil.nextLong());

		newMBSuspiciousActivityType.setCompanyId(RandomTestUtil.nextLong());

		newMBSuspiciousActivityType.setUserId(RandomTestUtil.nextLong());

		newMBSuspiciousActivityType.setUserName(RandomTestUtil.randomString());

		newMBSuspiciousActivityType.setCreateDate(RandomTestUtil.nextDate());

		newMBSuspiciousActivityType.setModifiedDate(RandomTestUtil.nextDate());

		newMBSuspiciousActivityType.setDescription(
			RandomTestUtil.randomString());

		_mbSuspiciousActivityTypes.add(
			_persistence.update(newMBSuspiciousActivityType));

		MBSuspiciousActivityType existingMBSuspiciousActivityType =
			_persistence.findByPrimaryKey(
				newMBSuspiciousActivityType.getPrimaryKey());

		Assert.assertEquals(
			existingMBSuspiciousActivityType.getMvccVersion(),
			newMBSuspiciousActivityType.getMvccVersion());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getCtCollectionId(),
			newMBSuspiciousActivityType.getCtCollectionId());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getUuid(),
			newMBSuspiciousActivityType.getUuid());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getSuspiciousActivityTypeId(),
			newMBSuspiciousActivityType.getSuspiciousActivityTypeId());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getGroupId(),
			newMBSuspiciousActivityType.getGroupId());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getCompanyId(),
			newMBSuspiciousActivityType.getCompanyId());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getUserId(),
			newMBSuspiciousActivityType.getUserId());
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getUserName(),
			newMBSuspiciousActivityType.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingMBSuspiciousActivityType.getCreateDate()),
			Time.getShortTimestamp(
				newMBSuspiciousActivityType.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingMBSuspiciousActivityType.getModifiedDate()),
			Time.getShortTimestamp(
				newMBSuspiciousActivityType.getModifiedDate()));
		Assert.assertEquals(
			existingMBSuspiciousActivityType.getDescription(),
			newMBSuspiciousActivityType.getDescription());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountBySuspiciousActivityTypeId() throws Exception {
		_persistence.countBySuspiciousActivityTypeId(RandomTestUtil.nextLong());

		_persistence.countBySuspiciousActivityTypeId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		MBSuspiciousActivityType existingMBSuspiciousActivityType =
			_persistence.findByPrimaryKey(
				newMBSuspiciousActivityType.getPrimaryKey());

		Assert.assertEquals(
			existingMBSuspiciousActivityType, newMBSuspiciousActivityType);
	}

	@Test(expected = NoSuchSuspiciousActivityTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<MBSuspiciousActivityType>
		getOrderByComparator() {

		return OrderByComparatorFactoryUtil.create(
			"MBSuspiciousActivityType", "mvccVersion", true, "ctCollectionId",
			true, "uuid", true, "suspiciousActivityTypeId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		MBSuspiciousActivityType existingMBSuspiciousActivityType =
			_persistence.fetchByPrimaryKey(
				newMBSuspiciousActivityType.getPrimaryKey());

		Assert.assertEquals(
			existingMBSuspiciousActivityType, newMBSuspiciousActivityType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		MBSuspiciousActivityType missingMBSuspiciousActivityType =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingMBSuspiciousActivityType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		MBSuspiciousActivityType newMBSuspiciousActivityType1 =
			addMBSuspiciousActivityType();
		MBSuspiciousActivityType newMBSuspiciousActivityType2 =
			addMBSuspiciousActivityType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMBSuspiciousActivityType1.getPrimaryKey());
		primaryKeys.add(newMBSuspiciousActivityType2.getPrimaryKey());

		Map<Serializable, MBSuspiciousActivityType> mbSuspiciousActivityTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, mbSuspiciousActivityTypes.size());
		Assert.assertEquals(
			newMBSuspiciousActivityType1,
			mbSuspiciousActivityTypes.get(
				newMBSuspiciousActivityType1.getPrimaryKey()));
		Assert.assertEquals(
			newMBSuspiciousActivityType2,
			mbSuspiciousActivityTypes.get(
				newMBSuspiciousActivityType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, MBSuspiciousActivityType> mbSuspiciousActivityTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(mbSuspiciousActivityTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMBSuspiciousActivityType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, MBSuspiciousActivityType> mbSuspiciousActivityTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, mbSuspiciousActivityTypes.size());
		Assert.assertEquals(
			newMBSuspiciousActivityType,
			mbSuspiciousActivityTypes.get(
				newMBSuspiciousActivityType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, MBSuspiciousActivityType> mbSuspiciousActivityTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(mbSuspiciousActivityTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMBSuspiciousActivityType.getPrimaryKey());

		Map<Serializable, MBSuspiciousActivityType> mbSuspiciousActivityTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, mbSuspiciousActivityTypes.size());
		Assert.assertEquals(
			newMBSuspiciousActivityType,
			mbSuspiciousActivityTypes.get(
				newMBSuspiciousActivityType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			MBSuspiciousActivityTypeLocalServiceUtil.
				getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<MBSuspiciousActivityType>() {

				@Override
				public void performAction(
					MBSuspiciousActivityType mbSuspiciousActivityType) {

					Assert.assertNotNull(mbSuspiciousActivityType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MBSuspiciousActivityType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"suspiciousActivityTypeId",
				newMBSuspiciousActivityType.getSuspiciousActivityTypeId()));

		List<MBSuspiciousActivityType> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		MBSuspiciousActivityType existingMBSuspiciousActivityType = result.get(
			0);

		Assert.assertEquals(
			existingMBSuspiciousActivityType, newMBSuspiciousActivityType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MBSuspiciousActivityType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"suspiciousActivityTypeId", RandomTestUtil.nextLong()));

		List<MBSuspiciousActivityType> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MBSuspiciousActivityType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("suspiciousActivityTypeId"));

		Object newSuspiciousActivityTypeId =
			newMBSuspiciousActivityType.getSuspiciousActivityTypeId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"suspiciousActivityTypeId",
				new Object[] {newSuspiciousActivityTypeId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSuspiciousActivityTypeId = result.get(0);

		Assert.assertEquals(
			existingSuspiciousActivityTypeId, newSuspiciousActivityTypeId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MBSuspiciousActivityType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("suspiciousActivityTypeId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"suspiciousActivityTypeId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newMBSuspiciousActivityType.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		MBSuspiciousActivityType newMBSuspiciousActivityType =
			addMBSuspiciousActivityType();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			MBSuspiciousActivityType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"suspiciousActivityTypeId",
				newMBSuspiciousActivityType.getSuspiciousActivityTypeId()));

		List<MBSuspiciousActivityType> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		Assert.assertEquals(
			mbSuspiciousActivityType.getUuid(),
			ReflectionTestUtil.invoke(
				mbSuspiciousActivityType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(mbSuspiciousActivityType.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				mbSuspiciousActivityType, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected MBSuspiciousActivityType addMBSuspiciousActivityType()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		MBSuspiciousActivityType mbSuspiciousActivityType = _persistence.create(
			pk);

		mbSuspiciousActivityType.setMvccVersion(RandomTestUtil.nextLong());

		mbSuspiciousActivityType.setCtCollectionId(RandomTestUtil.nextLong());

		mbSuspiciousActivityType.setUuid(RandomTestUtil.randomString());

		mbSuspiciousActivityType.setGroupId(RandomTestUtil.nextLong());

		mbSuspiciousActivityType.setCompanyId(RandomTestUtil.nextLong());

		mbSuspiciousActivityType.setUserId(RandomTestUtil.nextLong());

		mbSuspiciousActivityType.setUserName(RandomTestUtil.randomString());

		mbSuspiciousActivityType.setCreateDate(RandomTestUtil.nextDate());

		mbSuspiciousActivityType.setModifiedDate(RandomTestUtil.nextDate());

		mbSuspiciousActivityType.setDescription(RandomTestUtil.randomString());

		_mbSuspiciousActivityTypes.add(
			_persistence.update(mbSuspiciousActivityType));

		return mbSuspiciousActivityType;
	}

	private List<MBSuspiciousActivityType> _mbSuspiciousActivityTypes =
		new ArrayList<MBSuspiciousActivityType>();
	private MBSuspiciousActivityTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}