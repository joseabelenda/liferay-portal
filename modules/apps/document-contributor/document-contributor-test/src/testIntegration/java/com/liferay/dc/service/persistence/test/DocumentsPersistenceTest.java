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

package com.liferay.dc.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.dc.exception.NoSuchDocumentsException;
import com.liferay.dc.model.Documents;
import com.liferay.dc.service.DocumentsLocalServiceUtil;
import com.liferay.dc.service.persistence.DocumentsPersistence;
import com.liferay.dc.service.persistence.DocumentsUtil;
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
public class DocumentsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.dc.service"));

	@Before
	public void setUp() {
		_persistence = DocumentsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Documents> iterator = _documentses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Documents documents = _persistence.create(pk);

		Assert.assertNotNull(documents);

		Assert.assertEquals(documents.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Documents newDocuments = addDocuments();

		_persistence.remove(newDocuments);

		Documents existingDocuments = _persistence.fetchByPrimaryKey(
			newDocuments.getPrimaryKey());

		Assert.assertNull(existingDocuments);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDocuments();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Documents newDocuments = _persistence.create(pk);

		newDocuments.setGroupId(RandomTestUtil.nextLong());

		newDocuments.setCompanyId(RandomTestUtil.nextLong());

		newDocuments.setUserId(RandomTestUtil.nextLong());

		newDocuments.setUserName(RandomTestUtil.randomString());

		newDocuments.setCreateDate(RandomTestUtil.nextDate());

		newDocuments.setModifiedDate(RandomTestUtil.nextDate());

		newDocuments.setName(RandomTestUtil.randomString());

		newDocuments.setDescription(RandomTestUtil.randomString());

		newDocuments.setLink(RandomTestUtil.randomString());

		_documentses.add(_persistence.update(newDocuments));

		Documents existingDocuments = _persistence.findByPrimaryKey(
			newDocuments.getPrimaryKey());

		Assert.assertEquals(
			existingDocuments.getDocumentId(), newDocuments.getDocumentId());
		Assert.assertEquals(
			existingDocuments.getGroupId(), newDocuments.getGroupId());
		Assert.assertEquals(
			existingDocuments.getCompanyId(), newDocuments.getCompanyId());
		Assert.assertEquals(
			existingDocuments.getUserId(), newDocuments.getUserId());
		Assert.assertEquals(
			existingDocuments.getUserName(), newDocuments.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDocuments.getCreateDate()),
			Time.getShortTimestamp(newDocuments.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDocuments.getModifiedDate()),
			Time.getShortTimestamp(newDocuments.getModifiedDate()));
		Assert.assertEquals(
			existingDocuments.getName(), newDocuments.getName());
		Assert.assertEquals(
			existingDocuments.getDescription(), newDocuments.getDescription());
		Assert.assertEquals(
			existingDocuments.getLink(), newDocuments.getLink());
	}

	@Test
	public void testCountBydocumentId() throws Exception {
		_persistence.countBydocumentId(RandomTestUtil.nextLong());

		_persistence.countBydocumentId(0L);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testCountByD_D_N() throws Exception {
		_persistence.countByD_D_N(RandomTestUtil.nextLong(), "", "");

		_persistence.countByD_D_N(0L, "null", "null");

		_persistence.countByD_D_N(0L, (String)null, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Documents newDocuments = addDocuments();

		Documents existingDocuments = _persistence.findByPrimaryKey(
			newDocuments.getPrimaryKey());

		Assert.assertEquals(existingDocuments, newDocuments);
	}

	@Test(expected = NoSuchDocumentsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Documents> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Documents_Documents", "documentId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "name", true, "description", true,
			"link", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Documents newDocuments = addDocuments();

		Documents existingDocuments = _persistence.fetchByPrimaryKey(
			newDocuments.getPrimaryKey());

		Assert.assertEquals(existingDocuments, newDocuments);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Documents missingDocuments = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDocuments);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Documents newDocuments1 = addDocuments();
		Documents newDocuments2 = addDocuments();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocuments1.getPrimaryKey());
		primaryKeys.add(newDocuments2.getPrimaryKey());

		Map<Serializable, Documents> documentses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, documentses.size());
		Assert.assertEquals(
			newDocuments1, documentses.get(newDocuments1.getPrimaryKey()));
		Assert.assertEquals(
			newDocuments2, documentses.get(newDocuments2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Documents> documentses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(documentses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Documents newDocuments = addDocuments();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocuments.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Documents> documentses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, documentses.size());
		Assert.assertEquals(
			newDocuments, documentses.get(newDocuments.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Documents> documentses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(documentses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Documents newDocuments = addDocuments();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocuments.getPrimaryKey());

		Map<Serializable, Documents> documentses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, documentses.size());
		Assert.assertEquals(
			newDocuments, documentses.get(newDocuments.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DocumentsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Documents>() {

				@Override
				public void performAction(Documents documents) {
					Assert.assertNotNull(documents);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Documents newDocuments = addDocuments();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Documents.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"documentId", newDocuments.getDocumentId()));

		List<Documents> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Documents existingDocuments = result.get(0);

		Assert.assertEquals(existingDocuments, newDocuments);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Documents.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"documentId", RandomTestUtil.nextLong()));

		List<Documents> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Documents newDocuments = addDocuments();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Documents.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("documentId"));

		Object newDocumentId = newDocuments.getDocumentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"documentId", new Object[] {newDocumentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDocumentId = result.get(0);

		Assert.assertEquals(existingDocumentId, newDocumentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Documents.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("documentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"documentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Documents newDocuments = addDocuments();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newDocuments.getPrimaryKey()));
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

		Documents newDocuments = addDocuments();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Documents.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"documentId", newDocuments.getDocumentId()));

		List<Documents> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Documents documents) {
		Assert.assertEquals(
			Long.valueOf(documents.getDocumentId()),
			ReflectionTestUtil.<Long>invoke(
				documents, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "documentId"));
		Assert.assertEquals(
			documents.getDescription(),
			ReflectionTestUtil.invoke(
				documents, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "description"));
		Assert.assertEquals(
			documents.getName(),
			ReflectionTestUtil.invoke(
				documents, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected Documents addDocuments() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Documents documents = _persistence.create(pk);

		documents.setGroupId(RandomTestUtil.nextLong());

		documents.setCompanyId(RandomTestUtil.nextLong());

		documents.setUserId(RandomTestUtil.nextLong());

		documents.setUserName(RandomTestUtil.randomString());

		documents.setCreateDate(RandomTestUtil.nextDate());

		documents.setModifiedDate(RandomTestUtil.nextDate());

		documents.setName(RandomTestUtil.randomString());

		documents.setDescription(RandomTestUtil.randomString());

		documents.setLink(RandomTestUtil.randomString());

		_documentses.add(_persistence.update(documents));

		return documents;
	}

	private List<Documents> _documentses = new ArrayList<Documents>();
	private DocumentsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}