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

package com.liferay.pblink.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PBLinkEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PBLinkEntry
 * @generated
 */
public class PBLinkEntryWrapper
	extends BaseModelWrapper<PBLinkEntry>
	implements ModelWrapper<PBLinkEntry>, PBLinkEntry {

	public PBLinkEntryWrapper(PBLinkEntry pbLinkEntry) {
		super(pbLinkEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pbLinkEntryId", getPbLinkEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("link", getLink());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pbLinkEntryId = (Long)attributes.get("pbLinkEntryId");

		if (pbLinkEntryId != null) {
			setPbLinkEntryId(pbLinkEntryId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public PBLinkEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this pb link entry.
	 *
	 * @return the company ID of this pb link entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pb link entry.
	 *
	 * @return the create date of this pb link entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this pb link entry.
	 *
	 * @return the description of this pb link entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this pb link entry.
	 *
	 * @return the group ID of this pb link entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the link of this pb link entry.
	 *
	 * @return the link of this pb link entry
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this pb link entry.
	 *
	 * @return the modified date of this pb link entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pb link entry.
	 *
	 * @return the name of this pb link entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pb link entry ID of this pb link entry.
	 *
	 * @return the pb link entry ID of this pb link entry
	 */
	@Override
	public long getPbLinkEntryId() {
		return model.getPbLinkEntryId();
	}

	/**
	 * Returns the primary key of this pb link entry.
	 *
	 * @return the primary key of this pb link entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this pb link entry.
	 *
	 * @return the status of this pb link entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this pb link entry.
	 *
	 * @return the status by user ID of this pb link entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this pb link entry.
	 *
	 * @return the status by user name of this pb link entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this pb link entry.
	 *
	 * @return the status by user uuid of this pb link entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this pb link entry.
	 *
	 * @return the status date of this pb link entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this pb link entry.
	 *
	 * @return the user ID of this pb link entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pb link entry.
	 *
	 * @return the user name of this pb link entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pb link entry.
	 *
	 * @return the user uuid of this pb link entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is approved.
	 *
	 * @return <code>true</code> if this pb link entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is denied.
	 *
	 * @return <code>true</code> if this pb link entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is a draft.
	 *
	 * @return <code>true</code> if this pb link entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is expired.
	 *
	 * @return <code>true</code> if this pb link entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is inactive.
	 *
	 * @return <code>true</code> if this pb link entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is incomplete.
	 *
	 * @return <code>true</code> if this pb link entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is pending.
	 *
	 * @return <code>true</code> if this pb link entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this pb link entry is scheduled.
	 *
	 * @return <code>true</code> if this pb link entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this pb link entry.
	 *
	 * @param companyId the company ID of this pb link entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pb link entry.
	 *
	 * @param createDate the create date of this pb link entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this pb link entry.
	 *
	 * @param description the description of this pb link entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this pb link entry.
	 *
	 * @param groupId the group ID of this pb link entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the link of this pb link entry.
	 *
	 * @param link the link of this pb link entry
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this pb link entry.
	 *
	 * @param modifiedDate the modified date of this pb link entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pb link entry.
	 *
	 * @param name the name of this pb link entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pb link entry ID of this pb link entry.
	 *
	 * @param pbLinkEntryId the pb link entry ID of this pb link entry
	 */
	@Override
	public void setPbLinkEntryId(long pbLinkEntryId) {
		model.setPbLinkEntryId(pbLinkEntryId);
	}

	/**
	 * Sets the primary key of this pb link entry.
	 *
	 * @param primaryKey the primary key of this pb link entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this pb link entry.
	 *
	 * @param status the status of this pb link entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this pb link entry.
	 *
	 * @param statusByUserId the status by user ID of this pb link entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this pb link entry.
	 *
	 * @param statusByUserName the status by user name of this pb link entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this pb link entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this pb link entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this pb link entry.
	 *
	 * @param statusDate the status date of this pb link entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this pb link entry.
	 *
	 * @param userId the user ID of this pb link entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pb link entry.
	 *
	 * @param userName the user name of this pb link entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pb link entry.
	 *
	 * @param userUuid the user uuid of this pb link entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PBLinkEntryWrapper wrap(PBLinkEntry pbLinkEntry) {
		return new PBLinkEntryWrapper(pbLinkEntry);
	}

}