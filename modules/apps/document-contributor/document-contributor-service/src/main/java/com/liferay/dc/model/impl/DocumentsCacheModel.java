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

package com.liferay.dc.model.impl;

import com.liferay.dc.model.Documents;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Documents in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentsCacheModel
	implements CacheModel<Documents>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentsCacheModel)) {
			return false;
		}

		DocumentsCacheModel documentsCacheModel = (DocumentsCacheModel)object;

		if (documentId == documentsCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{documentId=");
		sb.append(documentId);
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
	public Documents toEntityModel() {
		DocumentsImpl documentsImpl = new DocumentsImpl();

		documentsImpl.setDocumentId(documentId);
		documentsImpl.setGroupId(groupId);
		documentsImpl.setCompanyId(companyId);
		documentsImpl.setUserId(userId);

		if (userName == null) {
			documentsImpl.setUserName("");
		}
		else {
			documentsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			documentsImpl.setCreateDate(null);
		}
		else {
			documentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentsImpl.setModifiedDate(null);
		}
		else {
			documentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			documentsImpl.setName("");
		}
		else {
			documentsImpl.setName(name);
		}

		if (description == null) {
			documentsImpl.setDescription("");
		}
		else {
			documentsImpl.setDescription(description);
		}

		if (link == null) {
			documentsImpl.setLink("");
		}
		else {
			documentsImpl.setLink(link);
		}

		documentsImpl.setStatus(status);
		documentsImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			documentsImpl.setStatusByUserName("");
		}
		else {
			documentsImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			documentsImpl.setStatusDate(null);
		}
		else {
			documentsImpl.setStatusDate(new Date(statusDate));
		}

		documentsImpl.resetOriginalValues();

		return documentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();

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
		objectOutput.writeLong(documentId);

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

	public long documentId;
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