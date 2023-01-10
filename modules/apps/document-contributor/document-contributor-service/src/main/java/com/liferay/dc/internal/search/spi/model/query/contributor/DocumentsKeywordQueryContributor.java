package com.liferay.dc.internal.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.dc.model.Documents",service = KeywordQueryContributor.class
)

public class DocumentsKeywordQueryContributor implements KeywordQueryContributor {
    @Override
    public void contribute(
            String keywords, BooleanQuery booleanQuery,
            KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext =
                keywordQueryContributorHelper.getSearchContext();
        queryHelper.addSearchLocalizedTerm(
                booleanQuery, searchContext, Field.NAME, false);
        queryHelper.addSearchLocalizedTerm(
                booleanQuery, searchContext, Field.DESCRIPTION, false);
        queryHelper.addSearchLocalizedTerm(
            booleanQuery, searchContext, Field.URL, false);
    }
    @Reference
    protected QueryHelper queryHelper;

}
