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

package com.liferay.message.boards.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * <p>
 * This class is a wrapper for {@link MBSuspiciousActivityType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MBSuspiciousActivityType
 * @generated
 */
public class MBSuspiciousActivityTypeWrapper
	extends BaseModelWrapper<MBSuspiciousActivityType>
	implements MBSuspiciousActivityType,
			   ModelWrapper<MBSuspiciousActivityType> {

	public MBSuspiciousActivityTypeWrapper(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		super(mbSuspiciousActivityType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("ctCollectionId", getCtCollectionId());
		attributes.put("uuid", getUuid());
		attributes.put(
			"suspiciousActivityTypeId", getSuspiciousActivityTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long ctCollectionId = (Long)attributes.get("ctCollectionId");

		if (ctCollectionId != null) {
			setCtCollectionId(ctCollectionId);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long suspiciousActivityTypeId = (Long)attributes.get(
			"suspiciousActivityTypeId");

		if (suspiciousActivityTypeId != null) {
			setSuspiciousActivityTypeId(suspiciousActivityTypeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public MBSuspiciousActivityType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this message boards suspicious activity type.
	 *
	 * @return the company ID of this message boards suspicious activity type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the container model ID of this message boards suspicious activity type.
	 *
	 * @return the container model ID of this message boards suspicious activity type
	 */
	@Override
	public long getContainerModelId() {
		return model.getContainerModelId();
	}

	/**
	 * Returns the container name of this message boards suspicious activity type.
	 *
	 * @return the container name of this message boards suspicious activity type
	 */
	@Override
	public String getContainerModelName() {
		return model.getContainerModelName();
	}

	/**
	 * Returns the create date of this message boards suspicious activity type.
	 *
	 * @return the create date of this message boards suspicious activity type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the ct collection ID of this message boards suspicious activity type.
	 *
	 * @return the ct collection ID of this message boards suspicious activity type
	 */
	@Override
	public long getCtCollectionId() {
		return model.getCtCollectionId();
	}

	/**
	 * Returns the description of this message boards suspicious activity type.
	 *
	 * @return the description of this message boards suspicious activity type
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this message boards suspicious activity type.
	 *
	 * @return the group ID of this message boards suspicious activity type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this message boards suspicious activity type.
	 *
	 * @return the modified date of this message boards suspicious activity type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this message boards suspicious activity type.
	 *
	 * @return the mvcc version of this message boards suspicious activity type
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the parent container model ID of this message boards suspicious activity type.
	 *
	 * @return the parent container model ID of this message boards suspicious activity type
	 */
	@Override
	public long getParentContainerModelId() {
		return model.getParentContainerModelId();
	}

	/**
	 * Returns the primary key of this message boards suspicious activity type.
	 *
	 * @return the primary key of this message boards suspicious activity type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the suspicious activity type ID of this message boards suspicious activity type.
	 *
	 * @return the suspicious activity type ID of this message boards suspicious activity type
	 */
	@Override
	public long getSuspiciousActivityTypeId() {
		return model.getSuspiciousActivityTypeId();
	}

	/**
	 * Returns the user ID of this message boards suspicious activity type.
	 *
	 * @return the user ID of this message boards suspicious activity type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this message boards suspicious activity type.
	 *
	 * @return the user name of this message boards suspicious activity type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this message boards suspicious activity type.
	 *
	 * @return the user uuid of this message boards suspicious activity type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this message boards suspicious activity type.
	 *
	 * @return the uuid of this message boards suspicious activity type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this message boards suspicious activity type.
	 *
	 * @param companyId the company ID of this message boards suspicious activity type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the container model ID of this message boards suspicious activity type.
	 *
	 * @param containerModelId the container model ID of this message boards suspicious activity type
	 */
	@Override
	public void setContainerModelId(long containerModelId) {
		model.setContainerModelId(containerModelId);
	}

	/**
	 * Sets the create date of this message boards suspicious activity type.
	 *
	 * @param createDate the create date of this message boards suspicious activity type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the ct collection ID of this message boards suspicious activity type.
	 *
	 * @param ctCollectionId the ct collection ID of this message boards suspicious activity type
	 */
	@Override
	public void setCtCollectionId(long ctCollectionId) {
		model.setCtCollectionId(ctCollectionId);
	}

	/**
	 * Sets the description of this message boards suspicious activity type.
	 *
	 * @param description the description of this message boards suspicious activity type
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this message boards suspicious activity type.
	 *
	 * @param groupId the group ID of this message boards suspicious activity type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this message boards suspicious activity type.
	 *
	 * @param modifiedDate the modified date of this message boards suspicious activity type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this message boards suspicious activity type.
	 *
	 * @param mvccVersion the mvcc version of this message boards suspicious activity type
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the parent container model ID of this message boards suspicious activity type.
	 *
	 * @param parentContainerModelId the parent container model ID of this message boards suspicious activity type
	 */
	@Override
	public void setParentContainerModelId(long parentContainerModelId) {
		model.setParentContainerModelId(parentContainerModelId);
	}

	/**
	 * Sets the primary key of this message boards suspicious activity type.
	 *
	 * @param primaryKey the primary key of this message boards suspicious activity type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the suspicious activity type ID of this message boards suspicious activity type.
	 *
	 * @param suspiciousActivityTypeId the suspicious activity type ID of this message boards suspicious activity type
	 */
	@Override
	public void setSuspiciousActivityTypeId(long suspiciousActivityTypeId) {
		model.setSuspiciousActivityTypeId(suspiciousActivityTypeId);
	}

	/**
	 * Sets the user ID of this message boards suspicious activity type.
	 *
	 * @param userId the user ID of this message boards suspicious activity type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this message boards suspicious activity type.
	 *
	 * @param userName the user name of this message boards suspicious activity type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this message boards suspicious activity type.
	 *
	 * @param userUuid the user uuid of this message boards suspicious activity type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this message boards suspicious activity type.
	 *
	 * @param uuid the uuid of this message boards suspicious activity type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public Map<String, Function<MBSuspiciousActivityType, Object>>
		getAttributeGetterFunctions() {

		return model.getAttributeGetterFunctions();
	}

	@Override
	public Map<String, BiConsumer<MBSuspiciousActivityType, Object>>
		getAttributeSetterBiConsumers() {

		return model.getAttributeSetterBiConsumers();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected MBSuspiciousActivityTypeWrapper wrap(
		MBSuspiciousActivityType mbSuspiciousActivityType) {

		return new MBSuspiciousActivityTypeWrapper(mbSuspiciousActivityType);
	}

}