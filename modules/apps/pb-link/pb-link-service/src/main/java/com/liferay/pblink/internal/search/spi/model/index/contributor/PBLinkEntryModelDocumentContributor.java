package com.liferay.pblink.internal.search.spi.model.index.contributor;

import com.liferay.pblink.model.PBLinkEntry;
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
	property = "indexer.class.name=com.liferay.pblink.model.PBLinkEntry",
	service = ModelDocumentContributor.class
)

public class PBLinkEntryModelDocumentContributor implements ModelDocumentContributor<PBLinkEntry> {
		@Override
		public void contribute(Document document, PBLinkEntry pbLinkEntry) {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing article " + pbLinkEntry);
			}

			// Strip HTML.
			String name = HtmlParserUtil.extractText(pbLinkEntry.getName());
			document.addText(Field.NAME, name);
			String description = HtmlParserUtil.extractText(pbLinkEntry.getDescription());
			document.addText(Field.DESCRIPTION, description);
			String link = HtmlParserUtil.extractText(pbLinkEntry.getLink());
			document.addText(Field.URL, link);
			document.addDate(Field.MODIFIED_DATE, pbLinkEntry.getModifiedDate());

			// Handle localized fields.
			for (Locale locale : LanguageUtil.getAvailableLocales(pbLinkEntry.getGroupId())) {
				String languageId = LocaleUtil.toLanguageId(locale);
				document.addText(
					LocalizationUtil.getLocalizedName(Field.NAME, languageId), name);
				document.addText(LocalizationUtil.getLocalizedName(Field.DESCRIPTION, languageId),description);
				document.addText(LocalizationUtil.getLocalizedName(Field.URL, languageId), link);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Document " + pbLinkEntry + " indexed successfully");
			}
		}

		private static final Log _log = LogFactoryUtil.getLog(
			PBLinkEntryModelDocumentContributor.class);
}
