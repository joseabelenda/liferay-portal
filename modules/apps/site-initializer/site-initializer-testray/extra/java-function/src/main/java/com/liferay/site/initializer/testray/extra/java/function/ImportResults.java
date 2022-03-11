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

package com.liferay.site.initializer.testray.extra.java.function;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import com.liferay.petra.http.invoker.HttpInvoker;
import com.liferay.petra.string.StringPool;
import com.liferay.site.initializer.testray.extra.java.function.constants.TestrayConstants;
import com.liferay.site.initializer.testray.extra.java.function.http.HttpUtil;
import com.liferay.site.initializer.testray.extra.java.function.util.PropsUtil;
import com.liferay.site.initializer.testray.extra.java.function.util.PropsValues;

import java.io.File;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author José Abelenda
 */
public class ImportResults {

	public static void main(String[] args) {
		try {
			ImportResults importResults = new ImportResults();

			importResults._readFiles("");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public ImportResults() throws Exception {
		_storage = _getStorage();

		_documentBuilderFactory = DocumentBuilderFactory.newInstance();

		_documentBuilder = _documentBuilderFactory.newDocumentBuilder();
	}

	private void _addTestrayAttachments(
			Node testcaseNode, long testrayCaseResultId)
		throws Exception {

		Element testcaseElement = (Element)testcaseNode;

		NodeList attachmentsNodeList = testcaseElement.getElementsByTagName(
			"attachments");

		for (int i = 0; i < attachmentsNodeList.getLength(); i++) {
			Node attachmentsNode = attachmentsNodeList.item(i);

			if (attachmentsNode.getNodeType() == Node.ELEMENT_NODE) {
				Element attachmentsElement = (Element)attachmentsNode;

				NodeList fileNodeList = attachmentsElement.getElementsByTagName(
					"file");

				for (int j = 0; j < fileNodeList.getLength(); j++) {
					Node fileNode = fileNodeList.item(j);

					if (fileNode.getNodeType() == Node.ELEMENT_NODE) {
						Element fileElement = (Element)fileNode;

						Map<String, String> bodyMap = new HashMap<>();

						bodyMap.put("name", fileElement.getAttribute("name"));
						bodyMap.put(
							"r_caseResultToAttachments_c_caseResultId",
							String.valueOf(testrayCaseResultId));
						bodyMap.put("url", fileElement.getAttribute("url"));
						bodyMap.put("value", fileElement.getAttribute("value"));

						HttpUtil.invoke(
							new JSONObject(
								bodyMap
							).toString(),
							"attachments", null, null,
							HttpInvoker.HttpMethod.POST);
					}
				}
			}
		}
	}

	private void _addTestrayCase(
			Node testcaseNode, long testrayBuildId, long testrayProjectId,
			long testrayRunId, Map<String, Object> testrayCasePropertiesMap)
		throws Exception {

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put(
			"description",
			(String)testrayCasePropertiesMap.get(
				"testray.testcase.description"));
		bodyMap.put(
			"name",
			(String)testrayCasePropertiesMap.get("testray.testcase.name"));
		bodyMap.put(
			"priority",
			(String)testrayCasePropertiesMap.get("testray.testcase.priority"));

		String testrayCaseTypeName = (String)testrayCasePropertiesMap.get(
			"testray.case.type.name");

		long testrayCaseTypeId = _fetchOrAddTestrayCaseType(
			testrayCaseTypeName);

		bodyMap.put("testrayCaseTypeId", String.valueOf(testrayCaseTypeId));

		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));

		String testrayTeamName = (String)testrayCasePropertiesMap.get(
			"testray.team.name");

		long testrayTeamId = _fetchOrAddTestrayTeam(
			testrayProjectId, testrayTeamName);

		bodyMap.put("testrayTeamId", String.valueOf(testrayTeamId));

		String testrayComponentName = (String)testrayCasePropertiesMap.get(
			"testray.main.component.name");

		long testrayComponentId = _fetchOrAddTestrayComponent(
			testrayProjectId, testrayTeamId, testrayComponentName);

		bodyMap.put("testrayComponentId", String.valueOf(testrayComponentId));

		JSONObject responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"cases", null, null, HttpInvoker.HttpMethod.POST);

		long testrayCaseId = responseJSONObject.getLong("id");

		long testrayCaseResultId = _addTestrayCaseResult(
			testrayCaseId, testrayComponentId, testrayBuildId, testrayRunId,
			testrayCasePropertiesMap);

		_addTestrayAttachments(testcaseNode, testrayCaseResultId);
		_addTestrayWarnings(testrayCasePropertiesMap, testrayCaseResultId);
	}

	private long _addTestrayCaseResult(
			long testrayCaseId, long testrayComponentId, long testrayBuildId,
			long testrayRunId, Map<String, Object> testrayCasePropertiesMap)
		throws Exception {

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("testrayBuildId", String.valueOf(testrayBuildId));
		bodyMap.put("testrayCaseId", String.valueOf(testrayCaseId));
		bodyMap.put("testrayComponentId", String.valueOf(testrayComponentId));
		bodyMap.put("testrayRunId", String.valueOf(testrayRunId));

		String dueStatus = String.valueOf(
			TestrayConstants.TESTRAY_STATUS_UNTESTED);

		String testrayTestcaseStatus = (String)testrayCasePropertiesMap.get(
			"testray.testcase.status");

		if (testrayTestcaseStatus.equals("in-progress")) {
			dueStatus = String.valueOf(
				TestrayConstants.TESTRAY_STATUS_IN_PROGRESS);
		}
		else if (testrayTestcaseStatus.equals("passed")) {
			dueStatus = String.valueOf(TestrayConstants.TESTRAY_STATUS_PASSED);
		}
		else if (testrayTestcaseStatus.equals("failed")) {
			dueStatus = String.valueOf(TestrayConstants.TESTRAY_STATUS_FAILED);
		}
		else if (testrayTestcaseStatus.equals("blocked")) {
			dueStatus = String.valueOf(TestrayConstants.TESTRAY_STATUS_BLOCKED);
		}
		else if (testrayTestcaseStatus.equals("dnr")) {
			dueStatus = String.valueOf(
				TestrayConstants.TESTRAY_STATUS_DID_NOT_RUN);
		}
		else if (testrayTestcaseStatus.equals("test-fix")) {
			dueStatus = String.valueOf(
				TestrayConstants.TESTRAY_STATUS_TEST_FIX);
		}

		bodyMap.put("dueStatus", dueStatus);

		JSONObject responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"caseresults", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private void _addTestrayCases(
			Element rootElement, long testrayBuildId, long testrayProjectId,
			long testrayRunId)
		throws Exception {

		NodeList testCasesNodeList = rootElement.getElementsByTagName(
			"testcase");

		for (int i = 0; i < testCasesNodeList.getLength(); i++) {
			Node testcaseNode = testCasesNodeList.item(i);

			Map<String, Object> testrayCasePropertiesMap =
				_getTestrayCaseProperties((Element)testcaseNode);

			_addTestrayCase(
				testcaseNode, testrayBuildId, testrayProjectId, testrayRunId,
				testrayCasePropertiesMap);
		}
	}

	private void _addTestrayFactor(
			long testrayRunId, long testrayCategoryId, String categoryName,
			long testrayOptionId, String optionName)
		throws Exception {

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("classNameId", String.valueOf(testrayRunId));
		bodyMap.put("classPK", String.valueOf(testrayRunId));
		bodyMap.put(
			"testrayFactorCategoryId", String.valueOf(testrayCategoryId));
		bodyMap.put("testrayFactorCategoryName", categoryName);
		bodyMap.put("testrayFactorOptionId", String.valueOf(testrayOptionId));
		bodyMap.put("testrayFactorOptionName", optionName);

		HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testrayfactors", null, null, HttpInvoker.HttpMethod.POST);
	}

	private void _addTestrayWarnings(
			Map<String, Object> testrayCasePropertiesMap,
			long testrayCaseResultId)
		throws Exception {

		List<String> warningsList = (List<String>)testrayCasePropertiesMap.get(
			"testray.testcase.warnings");

		if (warningsList == null) {
			return;
		}

		for (String warning : warningsList) {
			Map<String, String> bodyMap = new HashMap<>();

			bodyMap.put("content", warning);
			bodyMap.put(
				"r_caseResultToWarnings_c_caseResultId",
				String.valueOf(testrayCaseResultId));

			HttpUtil.invoke(
				new JSONObject(
					bodyMap
				).toString(),
				"warnings", null, null, HttpInvoker.HttpMethod.POST);
		}
	}

	private String _buildTestrayBuildDescription(
		Map<String, String> propertiesMap) {

		StringBuilder sb = new StringBuilder(15);

		if (propertiesMap.get("liferay.portal.git.id") != null) {
			sb.append("Portal hash: ");
			sb.append(propertiesMap.get("liferay.portal.git.id"));
			sb.append(StringPool.SEMICOLON);
			sb.append(StringPool.NEW_LINE);
		}

		if (propertiesMap.get("liferay.plugins.git.id") != null) {
			sb.append("Plugins hash: ");
			sb.append(propertiesMap.get("liferay.plugins.git.id"));
			sb.append(StringPool.SEMICOLON);
			sb.append(StringPool.NEW_LINE);
		}

		if (propertiesMap.get("liferay.portal.branch") != null) {
			sb.append("Portal branch: ");
			sb.append(propertiesMap.get("liferay.portal.branch"));
			sb.append(StringPool.SEMICOLON);
			sb.append(StringPool.NEW_LINE);
		}

		if (propertiesMap.get("liferay.portal.bundle") != null) {
			sb.append("Bundle: ");
			sb.append(propertiesMap.get("liferay.portal.bundle"));
			sb.append(StringPool.SEMICOLON);
		}

		return sb.toString();
	}

	private long _fetchOrAddTestrayBuild(
			long testrayProjectId, Map<String, String> propertiesMap)
		throws Exception {

		String testrayBuildName = propertiesMap.get("testray.build.name");

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayBuildName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "builds", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray buildsJSONArray = responseJSONObject.getJSONArray("items");

		if (!buildsJSONArray.isEmpty()) {
			JSONObject buildJSONObject = buildsJSONArray.getJSONObject(0);

			return buildJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put(
			"description", _buildTestrayBuildDescription(propertiesMap));
		bodyMap.put("dueDate", propertiesMap.get("testray.build.time"));
		bodyMap.put("name", testrayBuildName);
		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));

		long testrayProductVersionId = _fetchOrAddTestrayProductVersion(
			testrayProjectId, propertiesMap.get("testray.product.version"));

		bodyMap.put(
			"testrayProductVersionId", String.valueOf(testrayProductVersionId));

		long testrayRoutineId = _fetchOrAddTestrayRoutine(
			testrayProjectId, propertiesMap.get("testray.build.type"));

		bodyMap.put("testrayRoutineId", String.valueOf(testrayRoutineId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"builds", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayCaseType(String testrayCaseTypeName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayCaseTypeName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "casetypes", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray caseTypesJSONArray = responseJSONObject.getJSONArray("items");

		if (!caseTypesJSONArray.isEmpty()) {
			JSONObject caseTypeJSONObject = caseTypesJSONArray.getJSONObject(0);

			return caseTypeJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", testrayCaseTypeName);

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"casetypes", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayComponent(
			long testrayProjectId, long testrayTeamId,
			String testrayComponentName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayComponentName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "components", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray componentsJSONArray = responseJSONObject.getJSONArray(
			"items");

		if (!componentsJSONArray.isEmpty()) {
			JSONObject componentJSONObject = componentsJSONArray.getJSONObject(
				0);

			return componentJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", testrayComponentName);
		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));
		bodyMap.put("testrayTeamId", String.valueOf(testrayTeamId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"components", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayFactorCategory(String categoryName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + categoryName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "factorcategories", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray categoriesJSONArray = responseJSONObject.getJSONArray(
			"items");

		if (!categoriesJSONArray.isEmpty()) {
			JSONObject categoryJSONObject = categoriesJSONArray.getJSONObject(
				0);

			return categoryJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", categoryName);

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"factorcategories", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayFactorOption(
			String optionName, long testrayCategoryId)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + optionName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "factoroptions", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray optionsJSONArray = responseJSONObject.getJSONArray("items");

		if (!optionsJSONArray.isEmpty()) {
			JSONObject optionJSONObject = optionsJSONArray.getJSONObject(0);

			return optionJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", optionName);
		bodyMap.put(
			"testrayFactorCategoryId", String.valueOf(testrayCategoryId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"factoroptions", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayProductVersion(
			long testrayProjectId, String testrayProductVersion)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayProductVersion + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "productversions", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray versionsJSONArray = responseJSONObject.getJSONArray("items");

		if (!versionsJSONArray.isEmpty()) {
			JSONObject versionJSONObject = versionsJSONArray.getJSONObject(0);

			return versionJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", testrayProductVersion);
		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"productversions", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayProject(String testrayProjectName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayProjectName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "projects", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray projectsJSONArray = responseJSONObject.getJSONArray("items");

		if (!projectsJSONArray.isEmpty()) {
			JSONObject projectJSONObject = projectsJSONArray.getJSONObject(0);

			return projectJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", testrayProjectName);

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"projects", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayRoutine(
			long testrayProjectId, String routineName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + routineName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "routines", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray routinesJSONArray = responseJSONObject.getJSONArray("items");

		if (!routinesJSONArray.isEmpty()) {
			JSONObject routineJSONObject = routinesJSONArray.getJSONObject(0);

			return routineJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", routineName);
		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"routines", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayRun(
			long testrayBuildId, String testrayRunName, Element rootElement)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayRunName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "runs", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray runsJSONArray = responseJSONObject.getJSONArray("items");

		if (!runsJSONArray.isEmpty()) {
			JSONObject runJSONObject = runsJSONArray.getJSONObject(0);

			return runJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("externalReferencePK", testrayRunName);
		bodyMap.put("name", testrayRunName);
		bodyMap.put("testrayBuildId", String.valueOf(testrayBuildId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"runs", null, null, HttpInvoker.HttpMethod.POST);

		long testrayRunId = responseJSONObject.getLong("id");

		String environmentHash = _getTestrayRunEnvironmentHash(
			rootElement, testrayRunId);

		bodyMap = new HashMap<>();

		bodyMap.put("environmentHash", environmentHash);

		HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testrayruns/" + String.valueOf(testrayRunId), null, null,
			HttpInvoker.HttpMethod.PATCH);

		return testrayRunId;
	}

	private void _fetchOrAddTestrayTask(
			long testrayBuildId, String testrayTaskName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayTaskName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "tasks", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray tasksJSONArray = responseJSONObject.getJSONArray("items");

		if (tasksJSONArray.isEmpty()) {
			Map<String, String> bodyMap = new HashMap<>();

			bodyMap.put(
				"dueStatus",
				String.valueOf(TestrayConstants.TESTRAY_STATUS_IN_PROGRESS));
			bodyMap.put("name", testrayTaskName);
			bodyMap.put("testrayBuildId", String.valueOf(testrayBuildId));

			HttpUtil.invoke(
				new JSONObject(
					bodyMap
				).toString(),
				"tasks", null, null, HttpInvoker.HttpMethod.POST);
		}
	}

	private long _fetchOrAddTestrayTeam(
			long testrayProjectId, String testrayTeamName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayTeamName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "teams", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray teamsJSONArray = responseJSONObject.getJSONArray("items");

		if (!teamsJSONArray.isEmpty()) {
			JSONObject teamJSONObject = teamsJSONArray.getJSONObject(0);

			return teamJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", testrayTeamName);
		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"teams", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private String _getAttributeValue(Node node, String attributeName) {
		NamedNodeMap namedNodeMap = node.getAttributes();

		if (namedNodeMap == null) {
			return null;
		}

		Node attributeNode = namedNodeMap.getNamedItem(attributeName);

		if (attributeNode == null) {
			return null;
		}

		return attributeNode.getTextContent();
	}

	private Map<String, String> _getProperties(Element rootElement) {
		Map<String, String> map = new HashMap<>();

		NodeList nodeList = rootElement.getElementsByTagName("properties");

		Node propertiesNode = nodeList.item(0);

		Element element = (Element)propertiesNode;

		NodeList propertyNodeList = element.getElementsByTagName("property");

		for (int i = 0; i < propertyNodeList.getLength(); i++) {
			Node node = propertyNodeList.item(i);

			if (!node.hasAttributes()) {
				continue;
			}

			map.put(
				_getAttributeValue(node, "name"),
				_getAttributeValue(node, "value"));
		}

		return map;
	}

	private Storage _getStorage() throws Exception {
		InputStream inputStream = PropsUtil.class.getResourceAsStream(
			PropsValues.TESTRAY_URL_API_KEY);

		GoogleCredentials credentials = GoogleCredentials.fromStream(
			inputStream);

		return StorageOptions.newBuilder(
		).setProjectId(
			PropsValues.TESTRAY_BUCKET_NAME
		).setCredentials(
			credentials
		).build(
		).getService();
	}

	private Map<String, Object> _getTestrayCaseProperties(
		Element testcaseElement) {

		Map<String, Object> map = new HashMap<>();

		NodeList propertiesNodeList = testcaseElement.getElementsByTagName(
			"properties");

		Node propertiesNode = propertiesNodeList.item(0);

		Element element = (Element)propertiesNode;

		NodeList propertyNodeList = element.getElementsByTagName("property");

		for (int i = 0; i < propertyNodeList.getLength(); i++) {
			Node propertyNode = propertyNodeList.item(i);

			if (!propertyNode.hasAttributes()) {
				continue;
			}

			String name = _getAttributeValue(propertyNode, "name");

			if (name.equalsIgnoreCase("testray.testcase.warnings")) {
				List<String> values = new ArrayList<>();

				NodeList childNodeList = propertyNode.getChildNodes();

				for (int j = 0; j < childNodeList.getLength(); j++) {
					Node childNode = childNodeList.item(j);

					String warning = childNode.getTextContent();

					if (!_isEmpty(warning)) {
						values.add(childNode.getTextContent());
					}
				}

				map.put(name, values);
			}
			else {
				map.put(name, _getAttributeValue(propertyNode, "value"));
			}
		}

		return map;
	}

	private String _getTestrayRunEnvironmentHash(
			Element rootElement, long testrayRunId)
		throws Exception {

		StringBuilder stringBuilder = new StringBuilder();

		NodeList environmentNodeList = rootElement.getElementsByTagName(
			"environment");

		for (int i = 0; i < environmentNodeList.getLength(); i++) {
			Node node = environmentNodeList.item(i);

			if (!node.hasAttributes()) {
				continue;
			}

			String categoryName = _getAttributeValue(node, "type");
			String optionName = _getAttributeValue(node, "option");

			long testrayCategoryId = _fetchOrAddTestrayFactorCategory(
				categoryName);

			long testrayOptionId = _fetchOrAddTestrayFactorOption(
				optionName, testrayCategoryId);

			_addTestrayFactor(
				testrayRunId, testrayCategoryId, categoryName, testrayOptionId,
				optionName);

			stringBuilder.append(testrayCategoryId);
			
			stringBuilder.append(testrayOptionId);
		}

		String testrayFactorsString = stringBuilder.toString();

		return String.valueOf(testrayFactorsString.hashCode());
	}

	private boolean _isEmpty(String value) {
		if (value == null) {
			return true;
		}

		String trimmedValue = value.trim();

		if (trimmedValue.isEmpty()) {
			return true;
		}

		return false;
	}

	private void _processResults(Document document) throws Exception {
		Element rootElement = document.getDocumentElement();

		Map<String, String> propertiesMap = _getProperties(rootElement);

		String testrayProjectName = propertiesMap.get("testray.project.name");

		long testrayProjectId = _fetchOrAddTestrayProject(testrayProjectName);

		long testrayBuildId = _fetchOrAddTestrayBuild(
			testrayProjectId, propertiesMap);

		long testrayRunId = _fetchOrAddTestrayRun(
			testrayBuildId, propertiesMap.get("testray.run.id"), rootElement);

		_addTestrayCases(
			rootElement, testrayBuildId, testrayProjectId, testrayRunId);

		_fetchOrAddTestrayTask(
			testrayBuildId, propertiesMap.get("testray.build.name"));
	}

	private void _readFiles(String folderName) throws Exception {
		Page<Blob> page;

		if (folderName == null) {
			page = _storage.list(
				PropsValues.TESTRAY_BUCKET_NAME,
				Storage.BlobListOption.currentDirectory());
		}
		else {
			page = _storage.list(
				PropsValues.TESTRAY_BUCKET_NAME,
				Storage.BlobListOption.prefix(folderName),
				Storage.BlobListOption.currentDirectory());
		}

		for (Blob blob : page.iterateAll()) {
			String blobName = blob.getName();

			if (blobName.endsWith("results.tar.gz")) {
				Blob lfrTestrayCompletedBlod = _storage.get(
					PropsValues.TESTRAY_BUCKET_NAME,
					blobName.replace(
						"results.tar.gz", ".lfr-testray-completed"));

				if (lfrTestrayCompletedBlod != null) {
					_unTarGzip(blob.getContent());
				}

				continue;
			}

			if (blobName.endsWith("/")) {
				folderName = blobName.replace(folderName, "");

				if (!folderName.equals("")) {
					_readFiles(folderName);
				}
			}
		}
	}

	private void _unTarGzip(byte[] bytes) throws Exception {
		Path pathTempFile = Files.createTempFile(null, null);

		Files.write(pathTempFile, bytes);

		File tempFile = pathTempFile.toFile();

		Path pathTempDirectory = Files.createTempDirectory(null);

		File tempDirectory = pathTempDirectory.toFile();

		Archiver archiver = ArchiverFactory.createArchiver("tar", "gz");

		archiver.extract(tempFile, tempDirectory);

		File[] files = tempDirectory.listFiles();

		for (File file : files) {
			Document document = _documentBuilder.parse(file);

			_processResults(document);
		}
	}

	private final DocumentBuilder _documentBuilder;
	private final DocumentBuilderFactory _documentBuilderFactory;
	private final Storage _storage;

}