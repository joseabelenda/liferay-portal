package com.liferay.dc.internal.search.spi.model.index.contributor;

import com.liferay.dc.model.Documents;
import com.liferay.dc.service.DocumentsLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.dc.model.Documents",
        service = ModelIndexerWriterContributor.class
)

public class DocumentsModelIndexerWriterContributor implements ModelIndexerWriterContributor<Documents> {
    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
                (Documents documents) -> {
                    Document document =
                            modelIndexerWriterDocumentHelper.getDocument(documents);
                                    batchIndexingActionable.addDocuments(document);
                });
    }
    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(documentsLocalService.getIndexableActionableDynamicQuery());
    }
    @Override
    public long getCompanyId(Documents documents) {
        return documents.getCompanyId();}
    @Reference
    protected DocumentsLocalService documentsLocalService;
    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}
