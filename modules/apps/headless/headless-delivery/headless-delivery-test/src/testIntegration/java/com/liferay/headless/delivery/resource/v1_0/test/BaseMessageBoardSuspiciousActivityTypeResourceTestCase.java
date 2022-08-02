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

package com.liferay.headless.delivery.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.headless.delivery.client.dto.v1_0.Field;
import com.liferay.headless.delivery.client.dto.v1_0.MessageBoardSuspiciousActivityType;
import com.liferay.headless.delivery.client.http.HttpInvoker;
import com.liferay.headless.delivery.client.pagination.Page;
import com.liferay.headless.delivery.client.resource.v1_0.MessageBoardSuspiciousActivityTypeResource;
import com.liferay.headless.delivery.client.serdes.v1_0.MessageBoardSuspiciousActivityTypeSerDes;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public abstract class BaseMessageBoardSuspiciousActivityTypeResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_messageBoardSuspiciousActivityTypeResource.setContextCompany(
			testCompany);

		MessageBoardSuspiciousActivityTypeResource.Builder builder =
			MessageBoardSuspiciousActivityTypeResource.builder();

		messageBoardSuspiciousActivityTypeResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType1 =
			randomMessageBoardSuspiciousActivityType();

		String json = objectMapper.writeValueAsString(
			messageBoardSuspiciousActivityType1);

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType2 =
			MessageBoardSuspiciousActivityTypeSerDes.toDTO(json);

		Assert.assertTrue(
			equals(
				messageBoardSuspiciousActivityType1,
				messageBoardSuspiciousActivityType2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType =
			randomMessageBoardSuspiciousActivityType();

		String json1 = objectMapper.writeValueAsString(
			messageBoardSuspiciousActivityType);
		String json2 = MessageBoardSuspiciousActivityTypeSerDes.toJSON(
			messageBoardSuspiciousActivityType);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType =
			randomMessageBoardSuspiciousActivityType();

		messageBoardSuspiciousActivityType.setDescription(regex);

		String json = MessageBoardSuspiciousActivityTypeSerDes.toJSON(
			messageBoardSuspiciousActivityType);

		Assert.assertFalse(json.contains(regex));

		messageBoardSuspiciousActivityType =
			MessageBoardSuspiciousActivityTypeSerDes.toDTO(json);

		Assert.assertEquals(
			regex, messageBoardSuspiciousActivityType.getDescription());
	}

	@Test
	public void testDeleteMessageBoardSuspiciousActivityTypeMessageBoardSuspiciousActivityType()
		throws Exception {

		Assert.assertTrue(false);
	}

	@Test
	public void testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage()
		throws Exception {

		Long suspiciousTypeId =
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_getSuspiciousTypeId();
		Long irrelevantSuspiciousTypeId =
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_getIrrelevantSuspiciousTypeId();

		Page<MessageBoardSuspiciousActivityType> page =
			messageBoardSuspiciousActivityTypeResource.
				getMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage(
					suspiciousTypeId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantSuspiciousTypeId != null) {
			MessageBoardSuspiciousActivityType
				irrelevantMessageBoardSuspiciousActivityType =
					testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_addMessageBoardSuspiciousActivityType(
						irrelevantSuspiciousTypeId,
						randomIrrelevantMessageBoardSuspiciousActivityType());

			page =
				messageBoardSuspiciousActivityTypeResource.
					getMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage(
						irrelevantSuspiciousTypeId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantMessageBoardSuspiciousActivityType),
				(List<MessageBoardSuspiciousActivityType>)page.getItems());
			assertValid(page);
		}

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType1 =
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_addMessageBoardSuspiciousActivityType(
				suspiciousTypeId, randomMessageBoardSuspiciousActivityType());

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType2 =
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_addMessageBoardSuspiciousActivityType(
				suspiciousTypeId, randomMessageBoardSuspiciousActivityType());

		page =
			messageBoardSuspiciousActivityTypeResource.
				getMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage(
					suspiciousTypeId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(
				messageBoardSuspiciousActivityType1,
				messageBoardSuspiciousActivityType2),
			(List<MessageBoardSuspiciousActivityType>)page.getItems());
		assertValid(page);
	}

	protected MessageBoardSuspiciousActivityType
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_addMessageBoardSuspiciousActivityType(
				Long suspiciousTypeId,
				MessageBoardSuspiciousActivityType
					messageBoardSuspiciousActivityType)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_getSuspiciousTypeId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage_getIrrelevantSuspiciousTypeId()
		throws Exception {

		return null;
	}

	@Test
	public void testPutMessageBoardSuspiciousActivityTypeMessageBoardSuspiciousActivityType()
		throws Exception {

		Assert.assertTrue(false);
	}

	@Test
	public void testPostMessageBoardSuspiciousActivityTypesMessageBoardSuspiciousActivityTypePage()
		throws Exception {

		Assert.assertTrue(false);
	}

	protected void assertContains(
		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType,
		List<MessageBoardSuspiciousActivityType>
			messageBoardSuspiciousActivityTypes) {

		boolean contains = false;

		for (MessageBoardSuspiciousActivityType item :
				messageBoardSuspiciousActivityTypes) {

			if (equals(messageBoardSuspiciousActivityType, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			messageBoardSuspiciousActivityTypes + " does not contain " +
				messageBoardSuspiciousActivityType,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType1,
		MessageBoardSuspiciousActivityType
			messageBoardSuspiciousActivityType2) {

		Assert.assertTrue(
			messageBoardSuspiciousActivityType1 + " does not equal " +
				messageBoardSuspiciousActivityType2,
			equals(
				messageBoardSuspiciousActivityType1,
				messageBoardSuspiciousActivityType2));
	}

	protected void assertEquals(
		List<MessageBoardSuspiciousActivityType>
			messageBoardSuspiciousActivityTypes1,
		List<MessageBoardSuspiciousActivityType>
			messageBoardSuspiciousActivityTypes2) {

		Assert.assertEquals(
			messageBoardSuspiciousActivityTypes1.size(),
			messageBoardSuspiciousActivityTypes2.size());

		for (int i = 0; i < messageBoardSuspiciousActivityTypes1.size(); i++) {
			MessageBoardSuspiciousActivityType
				messageBoardSuspiciousActivityType1 =
					messageBoardSuspiciousActivityTypes1.get(i);
			MessageBoardSuspiciousActivityType
				messageBoardSuspiciousActivityType2 =
					messageBoardSuspiciousActivityTypes2.get(i);

			assertEquals(
				messageBoardSuspiciousActivityType1,
				messageBoardSuspiciousActivityType2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<MessageBoardSuspiciousActivityType>
			messageBoardSuspiciousActivityTypes1,
		List<MessageBoardSuspiciousActivityType>
			messageBoardSuspiciousActivityTypes2) {

		Assert.assertEquals(
			messageBoardSuspiciousActivityTypes1.size(),
			messageBoardSuspiciousActivityTypes2.size());

		for (MessageBoardSuspiciousActivityType
				messageBoardSuspiciousActivityType1 :
					messageBoardSuspiciousActivityTypes1) {

			boolean contains = false;

			for (MessageBoardSuspiciousActivityType
					messageBoardSuspiciousActivityType2 :
						messageBoardSuspiciousActivityTypes2) {

				if (equals(
						messageBoardSuspiciousActivityType1,
						messageBoardSuspiciousActivityType2)) {

					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				messageBoardSuspiciousActivityTypes2 + " does not contain " +
					messageBoardSuspiciousActivityType1,
				contains);
		}
	}

	protected void assertValid(
			MessageBoardSuspiciousActivityType
				messageBoardSuspiciousActivityType)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (messageBoardSuspiciousActivityType.getActions() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (messageBoardSuspiciousActivityType.getDescription() ==
						null) {

					valid = false;
				}

				continue;
			}

			if (Objects.equals("suspiciousTypeId", additionalAssertFieldName)) {
				if (messageBoardSuspiciousActivityType.getSuspiciousTypeId() ==
						null) {

					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<MessageBoardSuspiciousActivityType> page) {
		boolean valid = false;

		java.util.Collection<MessageBoardSuspiciousActivityType>
			messageBoardSuspiciousActivityTypes = page.getItems();

		int size = messageBoardSuspiciousActivityTypes.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.headless.delivery.dto.v1_0.
						MessageBoardSuspiciousActivityType.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType1,
		MessageBoardSuspiciousActivityType
			messageBoardSuspiciousActivityType2) {

		if (messageBoardSuspiciousActivityType1 ==
				messageBoardSuspiciousActivityType2) {

			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (!equals(
						(Map)messageBoardSuspiciousActivityType1.getActions(),
						(Map)
							messageBoardSuspiciousActivityType2.getActions())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						messageBoardSuspiciousActivityType1.getDescription(),
						messageBoardSuspiciousActivityType2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("suspiciousTypeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						messageBoardSuspiciousActivityType1.
							getSuspiciousTypeId(),
						messageBoardSuspiciousActivityType2.
							getSuspiciousTypeId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_messageBoardSuspiciousActivityTypeResource instanceof
				EntityModelResource)) {

			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_messageBoardSuspiciousActivityTypeResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("actions")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(
				String.valueOf(
					messageBoardSuspiciousActivityType.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("suspiciousTypeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected MessageBoardSuspiciousActivityType
			randomMessageBoardSuspiciousActivityType()
		throws Exception {

		return new MessageBoardSuspiciousActivityType() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				suspiciousTypeId = RandomTestUtil.randomLong();
			}
		};
	}

	protected MessageBoardSuspiciousActivityType
			randomIrrelevantMessageBoardSuspiciousActivityType()
		throws Exception {

		MessageBoardSuspiciousActivityType
			randomIrrelevantMessageBoardSuspiciousActivityType =
				randomMessageBoardSuspiciousActivityType();

		return randomIrrelevantMessageBoardSuspiciousActivityType;
	}

	protected MessageBoardSuspiciousActivityType
			randomPatchMessageBoardSuspiciousActivityType()
		throws Exception {

		return randomMessageBoardSuspiciousActivityType();
	}

	protected MessageBoardSuspiciousActivityTypeResource
		messageBoardSuspiciousActivityTypeResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(
			BaseMessageBoardSuspiciousActivityTypeResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.headless.delivery.resource.v1_0.
		MessageBoardSuspiciousActivityTypeResource
			_messageBoardSuspiciousActivityTypeResource;

}