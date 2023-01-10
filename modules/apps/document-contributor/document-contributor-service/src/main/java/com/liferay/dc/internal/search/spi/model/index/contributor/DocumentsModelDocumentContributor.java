package com.liferay.dc.internal.search.spi.model.index.contributor;

import com.liferay.dc.model.Documents;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlParserUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.dc.model.Documents",
        service = ModelDocumentContributor.class
)
public class DocumentsModelDocumentContributor implements ModelDocumentContributor<Documents> {
    @Override
    public void contribute(Document document, Documents documents) {
        if (_log.isDebugEnabled()) {
            _log.debug("Indexing article " + documents);
        }

// Strip HTML.
        String name = HtmlParserUtil.extractText(documents.getName());
        document.addText(Field.NAME, name);
        String description = HtmlParserUtil.extractText(documents.getDescription());
        document.addText(Field.DESCRIPTION, description);
        String link = HtmlParserUtil.extractText(documents.getLink());
        document.addText(Field.URL, link);
        document.addDate(Field.MODIFIED_DATE, documents.getModifiedDate());

// Handle localized fields.
        for (Locale locale : LanguageUtil.getAvailableLocales(documents.getGroupId())) {
            String languageId = LocaleUtil.toLanguageId(locale);
            document.addText(LocalizationUtil.getLocalizedName(Field.NAME, languageId), name);
            document.addText(LocalizationUtil.getLocalizedName(Field.DESCRIPTION, languageId),description);
            document.addText(LocalizationUtil.getLocalizedName(Field.URL, languageId), link);
        }

        if (_log.isDebugEnabled()) {
            _log.debug("Document " + documents + " indexed successfully");
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
       DocumentsModelDocumentContributor.class);
}
