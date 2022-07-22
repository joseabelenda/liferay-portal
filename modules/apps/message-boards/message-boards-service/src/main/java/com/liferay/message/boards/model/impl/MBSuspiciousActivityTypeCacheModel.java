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

package com.liferay.message.boards.model.impl;

import com.liferay.message.boards.model.MBSuspiciousActivityType;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MBSuspiciousActivityType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MBSuspiciousActivityTypeCacheModel
	implements CacheModel<MBSuspiciousActivityType>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MBSuspiciousActivityTypeCacheModel)) {
			return false;
		}

		MBSuspiciousActivityTypeCacheModel mbSuspiciousActivityTypeCacheModel =
			(MBSuspiciousActivityTypeCacheModel)object;

		if ((suspiciousActivityTypeId ==
				mbSuspiciousActivityTypeCacheModel.suspiciousActivityTypeId) &&
			(mvccVersion == mbSuspiciousActivityTypeCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, suspiciousActivityTypeId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", ctCollectionId=");
		sb.append(ctCollectionId);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", suspiciousActivityTypeId=");
		sb.append(suspiciousActivityTypeId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MBSuspiciousActivityType toEntityModel() {
		MBSuspiciousActivityTypeImpl mbSuspiciousActivityTypeImpl =
			new MBSuspiciousActivityTypeImpl();

		mbSuspiciousActivityTypeImpl.setMvccVersion(mvccVersion);
		mbSuspiciousActivityTypeImpl.setCtCollectionId(ctCollectionId);

		if (uuid == null) {
			mbSuspiciousActivityTypeImpl.setUuid("");
		}
		else {
			mbSuspiciousActivityTypeImpl.setUuid(uuid);
		}

		mbSuspiciousActivityTypeImpl.setSuspiciousActivityTypeId(
			suspiciousActivityTypeId);
		mbSuspiciousActivityTypeImpl.setGroupId(groupId);
		mbSuspiciousActivityTypeImpl.setCompanyId(companyId);
		mbSuspiciousActivityTypeImpl.setUserId(userId);

		if (userName == null) {
			mbSuspiciousActivityTypeImpl.setUserName("");
		}
		else {
			mbSuspiciousActivityTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mbSuspiciousActivityTypeImpl.setCreateDate(null);
		}
		else {
			mbSuspiciousActivityTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mbSuspiciousActivityTypeImpl.setModifiedDate(null);
		}
		else {
			mbSuspiciousActivityTypeImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		if (description == null) {
			mbSuspiciousActivityTypeImpl.setDescription("");
		}
		else {
			mbSuspiciousActivityTypeImpl.setDescription(description);
		}

		mbSuspiciousActivityTypeImpl.resetOriginalValues();

		return mbSuspiciousActivityTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		ctCollectionId = objectInput.readLong();
		uuid = objectInput.readUTF();

		suspiciousActivityTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(ctCollectionId);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(suspiciousActivityTypeId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long mvccVersion;
	public long ctCollectionId;
	public String uuid;
	public long suspiciousActivityTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;

}