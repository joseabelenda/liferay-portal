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

package com.liferay.headless.delivery.client.serdes.v1_0;

import com.liferay.headless.delivery.client.dto.v1_0.MessageBoardSuspiciousActivityType;
import com.liferay.headless.delivery.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class MessageBoardSuspiciousActivityTypeSerDes {

	public static MessageBoardSuspiciousActivityType toDTO(String json) {
		MessageBoardSuspiciousActivityTypeJSONParser
			messageBoardSuspiciousActivityTypeJSONParser =
				new MessageBoardSuspiciousActivityTypeJSONParser();

		return messageBoardSuspiciousActivityTypeJSONParser.parseToDTO(json);
	}

	public static MessageBoardSuspiciousActivityType[] toDTOs(String json) {
		MessageBoardSuspiciousActivityTypeJSONParser
			messageBoardSuspiciousActivityTypeJSONParser =
				new MessageBoardSuspiciousActivityTypeJSONParser();

		return messageBoardSuspiciousActivityTypeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType) {

		if (messageBoardSuspiciousActivityType == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (messageBoardSuspiciousActivityType.getActions() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"actions\": ");

			sb.append(_toJSON(messageBoardSuspiciousActivityType.getActions()));
		}

		if (messageBoardSuspiciousActivityType.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(
				_escape(messageBoardSuspiciousActivityType.getDescription()));

			sb.append("\"");
		}

		if (messageBoardSuspiciousActivityType.getSuspiciousTypeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"suspiciousTypeId\": ");

			sb.append(messageBoardSuspiciousActivityType.getSuspiciousTypeId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MessageBoardSuspiciousActivityTypeJSONParser
			messageBoardSuspiciousActivityTypeJSONParser =
				new MessageBoardSuspiciousActivityTypeJSONParser();

		return messageBoardSuspiciousActivityTypeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType) {

		if (messageBoardSuspiciousActivityType == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (messageBoardSuspiciousActivityType.getActions() == null) {
			map.put("actions", null);
		}
		else {
			map.put(
				"actions",
				String.valueOf(
					messageBoardSuspiciousActivityType.getActions()));
		}

		if (messageBoardSuspiciousActivityType.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put(
				"description",
				String.valueOf(
					messageBoardSuspiciousActivityType.getDescription()));
		}

		if (messageBoardSuspiciousActivityType.getSuspiciousTypeId() == null) {
			map.put("suspiciousTypeId", null);
		}
		else {
			map.put(
				"suspiciousTypeId",
				String.valueOf(
					messageBoardSuspiciousActivityType.getSuspiciousTypeId()));
		}

		return map;
	}

	public static class MessageBoardSuspiciousActivityTypeJSONParser
		extends BaseJSONParser<MessageBoardSuspiciousActivityType> {

		@Override
		protected MessageBoardSuspiciousActivityType createDTO() {
			return new MessageBoardSuspiciousActivityType();
		}

		@Override
		protected MessageBoardSuspiciousActivityType[] createDTOArray(
			int size) {

			return new MessageBoardSuspiciousActivityType[size];
		}

		@Override
		protected void setField(
			MessageBoardSuspiciousActivityType
				messageBoardSuspiciousActivityType,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "actions")) {
				if (jsonParserFieldValue != null) {
					messageBoardSuspiciousActivityType.setActions(
						(Map)MessageBoardSuspiciousActivityTypeSerDes.toMap(
							(String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					messageBoardSuspiciousActivityType.setDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "suspiciousTypeId")) {
				if (jsonParserFieldValue != null) {
					messageBoardSuspiciousActivityType.setSuspiciousTypeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}