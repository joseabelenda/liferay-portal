create index IX_FB5B5B0A on Documents_Documents (documentId, description[$COLUMN_LENGTH:75$], name[$COLUMN_LENGTH:75$]);
create index IX_C3C4C139 on Documents_Documents (groupId, status);
create index IX_C4E127B6 on Documents_Documents (name[$COLUMN_LENGTH:75$]);
create index IX_F22EF51D on Documents_Documents (status);