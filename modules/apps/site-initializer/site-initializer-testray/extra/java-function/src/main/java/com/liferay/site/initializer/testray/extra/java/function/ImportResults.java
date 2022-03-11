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
import com.liferay.site.initializer.testray.extra.java.function.http.HttpUtil;
import com.liferay.site.initializer.testray.extra.java.function.util.PropsUtil;
import com.liferay.site.initializer.testray.extra.java.function.util.PropsValues;

import java.io.File;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;
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

			importResults.readFiles("");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public ImportResults() throws Exception {
		_storage = getStorage();

		_documentBuilderFactory = DocumentBuilderFactory.newInstance();

		_documentBuilder = _documentBuilderFactory.newDocumentBuilder();
	}

	public void addTestrayCase(long projectId, Document document)
		throws Exception {

		String componentName = null;
		
		Map<String, String> map = new HashMap<>();

		map.put("testrayProjectId", String.valueOf(projectId));
		
		NodeList testCasesNodeList = document.getElementsByTagName(
			"testcase");

		for (int i = 0; i < testCasesNodeList.getLength(); i++) {
			Node testCaseNode = testCasesNodeList.item(i);

			Element element = (Element)testCaseNode;

			NodeList propertyNodeList = element.getElementsByTagName(
				"property");

			for (int j = 0; j < propertyNodeList.getLength(); j++) {
				Node node = propertyNodeList.item(j);

				if ((node.getNodeType() == Node.ELEMENT_NODE) &&
					!node.getNodeName(
					).equals(
						"#text"
					) &&
					(node.getAttributes(
					).getLength() > 0)) {

					String name = node.getAttributes(
					).getNamedItem(
						"name"
					).getTextContent();

					String value = null;

					if (name.equals("testray.main.component.name")) {
						componentName = node.getAttributes(
						).getNamedItem(
							"value"
						).getTextContent();
					}
					else if (name.equals("testray.team.name")) {
						value = node.getAttributes(
						).getNamedItem(
							"value"
						).getTextContent();
						
						long teamId = fetchOrAddTestrayTeam(projectId, value);
						long componentId = fetchOrAddTestrayComponent(
							projectId, teamId, componentName);

						map.put("testrayComponentId", String.valueOf(componentId));
					}
					else if (name.equals("testray.testcase.name")) {
						value = node.getAttributes(
						).getNamedItem(
							"value"
						).getTextContent();
						map.put("name", value);

						//TODO figure out what it means
						map.put("stepsType", name);
					}
					else if (name.equals("testray.testcase.priority")) {
						value = node.getAttributes(
						).getNamedItem(
							"value"
						).getTextContent();
						map.put("priority", value);
					}
				}
			}

			HttpUtil.invoke(
				new JSONObject(
					map
				).toString(),
				"testraycases", null, null, HttpInvoker.HttpMethod.POST);
		}
	}

	public long fetchOrAddTestrayComponent(long projectId, long teamId,
		String componentName) throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + componentName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "testraycomponents", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray componentsJSONArray = responseJSONObject.getJSONArray("items");

		if (!componentsJSONArray.isEmpty()) {
			JSONObject componentJSONObject = componentsJSONArray.getJSONObject(0);

			return componentJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", componentName);
		bodyMap.put("testrayProjectId", String.valueOf(projectId));
		bodyMap.put("testrayTeamId", String.valueOf(teamId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testraycomponents", null, null, HttpInvoker.HttpMethod.POST);

	   	return responseJSONObject.getLong("id");
	}

	public long fetchOrAddTestrayRoutine(long projectId,
		String routineName) throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + routineName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "testrayroutines", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray routinesJSONArray = responseJSONObject.getJSONArray("items");

		if (!routinesJSONArray.isEmpty()) {
			JSONObject routineJSONObject = routinesJSONArray.getJSONObject(0);

			return routineJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", routineName);
		bodyMap.put("testrayProjectId", String.valueOf(projectId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testrayroutines", null, null, HttpInvoker.HttpMethod.POST);

	   	return responseJSONObject.getLong("id");
	}

	public long fetchOrAddTestrayRun(long buildId, String runName) throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + runName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "testrayruns", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray runsJSONArray = responseJSONObject.getJSONArray("items");

		if (!runsJSONArray.isEmpty()) {
			JSONObject runJSONObject = runsJSONArray.getJSONObject(0);

			return runJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("externalReferencePK", runName);
		bodyMap.put("name", runName);
		bodyMap.put("testrayBuildId", String.valueOf(buildId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testrayruns", null, null, HttpInvoker.HttpMethod.POST);

	   	return responseJSONObject.getLong("id");
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

		String buildName = propertiesMap.get("testray.build.name");

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + buildName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "testraybuilds", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

		JSONArray buildsJSONArray = responseJSONObject.getJSONArray("items");

		if (!buildsJSONArray.isEmpty()) {
			JSONObject buildJSONObject = buildsJSONArray.getJSONObject(0);

			return buildJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put(
			"description", _buildTestrayBuildDescription(propertiesMap));
		bodyMap.put("dueDate", propertiesMap.get("testray.build.time"));
		bodyMap.put("name", buildName);
		bodyMap.put("testrayProjectId", String.valueOf(testrayProjectId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testraybuilds", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	private long _fetchOrAddTestrayProject(String testrayProjectName)
		throws Exception {

		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + testrayProjectName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "projects", null, parametersMap,
			HttpInvoker.HttpMethod.GET);

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

	public Storage getStorage() throws Exception {
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

	public long fetchOrAddTestrayTeam(long projectId, String teamName) throws Exception {
		Map<String, String> parametersMap = new HashMap<>();

		parametersMap.put("filter", "name eq '" + teamName + "'");

		JSONObject responseJSONObject = HttpUtil.invoke(
			null, "testrayteams", null, parametersMap, HttpInvoker.HttpMethod.GET);

		JSONArray teamsJSONArray = responseJSONObject.getJSONArray("items");

		if (!teamsJSONArray.isEmpty()) {
			JSONObject teamJSONObject = teamsJSONArray.getJSONObject(0);

			return teamJSONObject.getLong("id");
		}

		Map<String, String> bodyMap = new HashMap<>();

		bodyMap.put("name", teamName);
		bodyMap.put("testrayProjectId", String.valueOf(projectId));

		responseJSONObject = HttpUtil.invoke(
			new JSONObject(
				bodyMap
			).toString(),
			"testrayteams", null, null, HttpInvoker.HttpMethod.POST);

		return responseJSONObject.getLong("id");
	}

	public void readFiles(String folderName) throws Exception {
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
			if (blob.getName(
				).endsWith(
					"results.tar.gz"
				)) {

				Blob lfrTestrayCompletedBlod = _storage.get(
					PropsValues.TESTRAY_BUCKET_NAME,
					blob.getName(
					).replace(
						"results.tar.gz", ".lfr-testray-completed"
					));

				if (lfrTestrayCompletedBlod != null) {
					_unTarGzip(blob.getContent());
				}

				continue;
			}

			if (blob.getName(
				).endsWith(
					"/"
				)) {

				folderName = blob.getName(
				).replace(
					folderName, ""
				);

				if (!folderName.equals("")) {
					readFiles(folderName);
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

	private void _processResults(Document document) throws Exception {
		Element rootElement = document.getDocumentElement();

		Map<String, String> propertiesMap = _getProperties(rootElement);

		String testrayProjectName = propertiesMap.get("testray.project.name");

		long testrayProjectId = _fetchOrAddTestrayProject(testrayProjectName);
	}

	private final DocumentBuilder _documentBuilder;
	private final DocumentBuilderFactory _documentBuilderFactory;
	private final Storage _storage;

}