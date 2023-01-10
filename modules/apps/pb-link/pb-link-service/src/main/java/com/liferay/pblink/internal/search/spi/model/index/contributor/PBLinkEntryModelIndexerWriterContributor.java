package com.liferay.pblink.internal.search.spi.model.index.contributor;

import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.pblink.service.PBLinkEntryLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Reference;

public class PBLinkEntryModelIndexerWriterContributor implements
	ModelIndexerWriterContributor<PBLinkEntry> {
	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod(
			(PBLinkEntry pbLinkEntry) -> {
				Document document = modelIndexerWriterDocumentHelper.getDocument(pbLinkEntry);
				batchIndexingActionable.addDocuments(document);
			});
	}
	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(pbLinkEntryLocalService.getIndexableActionableDynamicQuery());
	}
	@Override
	public long getCompanyId(PBLinkEntry pbLinkEntry) {
		return pbLinkEntry.getCompanyId();}
	@Reference
	protected PBLinkEntryLocalService pbLinkEntryLocalService;
	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

}
