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

package com.liferay.pblink.model.impl;

import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PBLinkEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PBLinkEntryCacheModel
	implements CacheModel<PBLinkEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PBLinkEntryCacheModel)) {
			return false;
		}

		PBLinkEntryCacheModel pbLinkEntryCacheModel =
			(PBLinkEntryCacheModel)object;

		if (pbLinkEntryId == pbLinkEntryCacheModel.pbLinkEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pbLinkEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{pbLinkEntryId=");
		sb.append(pbLinkEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", link=");
		sb.append(link);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PBLinkEntry toEntityModel() {
		PBLinkEntryImpl pbLinkEntryImpl = new PBLinkEntryImpl();

		pbLinkEntryImpl.setPbLinkEntryId(pbLinkEntryId);
		pbLinkEntryImpl.setGroupId(groupId);
		pbLinkEntryImpl.setCompanyId(companyId);
		pbLinkEntryImpl.setUserId(userId);

		if (userName == null) {
			pbLinkEntryImpl.setUserName("");
		}
		else {
			pbLinkEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			pbLinkEntryImpl.setCreateDate(null);
		}
		else {
			pbLinkEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pbLinkEntryImpl.setModifiedDate(null);
		}
		else {
			pbLinkEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			pbLinkEntryImpl.setName("");
		}
		else {
			pbLinkEntryImpl.setName(name);
		}

		if (description == null) {
			pbLinkEntryImpl.setDescription("");
		}
		else {
			pbLinkEntryImpl.setDescription(description);
		}

		if (link == null) {
			pbLinkEntryImpl.setLink("");
		}
		else {
			pbLinkEntryImpl.setLink(link);
		}

		pbLinkEntryImpl.setStatus(status);
		pbLinkEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			pbLinkEntryImpl.setStatusByUserName("");
		}
		else {
			pbLinkEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			pbLinkEntryImpl.setStatusDate(null);
		}
		else {
			pbLinkEntryImpl.setStatusDate(new Date(statusDate));
		}

		pbLinkEntryImpl.resetOriginalValues();

		return pbLinkEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pbLinkEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		link = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(pbLinkEntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long pbLinkEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String link;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}