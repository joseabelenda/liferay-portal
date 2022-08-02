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

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.MessageBoardSuspiciousActivityTypeSerDes;

import java.io.Serializable;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class MessageBoardSuspiciousActivityType
	implements Cloneable, Serializable {

	public static MessageBoardSuspiciousActivityType toDTO(String json) {
		return MessageBoardSuspiciousActivityTypeSerDes.toDTO(json);
	}

	public Map<String, Map<String, String>> getActions() {
		return actions;
	}

	public void setActions(Map<String, Map<String, String>> actions) {
		this.actions = actions;
	}

	public void setActions(
		UnsafeSupplier<Map<String, Map<String, String>>, Exception>
			actionsUnsafeSupplier) {

		try {
			actions = actionsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Map<String, Map<String, String>> actions;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public Long getSuspiciousTypeId() {
		return suspiciousTypeId;
	}

	public void setSuspiciousTypeId(Long suspiciousTypeId) {
		this.suspiciousTypeId = suspiciousTypeId;
	}

	public void setSuspiciousTypeId(
		UnsafeSupplier<Long, Exception> suspiciousTypeIdUnsafeSupplier) {

		try {
			suspiciousTypeId = suspiciousTypeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long suspiciousTypeId;

	@Override
	public MessageBoardSuspiciousActivityType clone()
		throws CloneNotSupportedException {

		return (MessageBoardSuspiciousActivityType)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MessageBoardSuspiciousActivityType)) {
			return false;
		}

		MessageBoardSuspiciousActivityType messageBoardSuspiciousActivityType =
			(MessageBoardSuspiciousActivityType)object;

		return Objects.equals(
			toString(), messageBoardSuspiciousActivityType.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MessageBoardSuspiciousActivityTypeSerDes.toJSON(this);
	}

}