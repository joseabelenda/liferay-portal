create index IX_46B98797 on PBLink_PBLinkEntry (groupId, status);
create index IX_4968B018 on PBLink_PBLinkEntry (name[$COLUMN_LENGTH:75$]);
create index IX_6EA9233 on PBLink_PBLinkEntry (pbLinkEntryId, description[$COLUMN_LENGTH:75$], name[$COLUMN_LENGTH:75$]);
create index IX_72F5ECFF on PBLink_PBLinkEntry (status);