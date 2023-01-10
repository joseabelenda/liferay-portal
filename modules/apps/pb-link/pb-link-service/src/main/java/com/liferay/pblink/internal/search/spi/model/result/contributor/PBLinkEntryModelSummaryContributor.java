package com.liferay.pblink.internal.search.spi.model.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.pblink.model.PBLinkEntry",
	service = ModelSummaryContributor.class
)
public class PBLinkEntryModelSummaryContributor implements ModelSummaryContributor {
		@Override
		public Summary getSummary(
			Document document, Locale locale, String snippet) {
			String languageId = LocaleUtil.toLanguageId(locale);
			return _createSummary(
				document,
				LocalizationUtil.getLocalizedName(Field.NAME, languageId),
				LocalizationUtil.getLocalizedName(Field.DESCRIPTION, languageId),
				LocalizationUtil.getLocalizedName(Field.URL, languageId));
		}
		private Summary _createSummary(
			Document document, String nameField, String urlField, String descriptionField) {
			String prefix = Field.SNIPPET + StringPool.UNDERLINE;

			Summary summary = new Summary(
				document.get(prefix + nameField, nameField),
				document.get(prefix + urlField, urlField)
			);

			summary.setMaxContentLength(200);
			return summary;
		}

}
