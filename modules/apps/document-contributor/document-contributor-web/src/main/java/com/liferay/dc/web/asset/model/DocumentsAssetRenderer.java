package com.liferay.dc.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.dc.model.Documents;
import com.liferay.dc.web.constants.DocumentsPortletKeys;
import com.liferay.dc.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.asset.util.AssetUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Asset renderer for documents.
 *
 * @author Mylena Monte
 */
public class DocumentsAssetRenderer extends BaseJSPAssetRenderer<Documents> {
	public DocumentsAssetRenderer(Documents documents) {
		_documents = documents;
	}
	@Override
	public Documents getAssetObject() {
		return _documents;
	}
	@Override
	public String getClassName() {
		return Documents.class.getName();
	}
	@Override
	public long getClassPK() {
		return _documents.getDocumentId();
	}
	@Override
	public long getGroupId() {return _documents.getGroupId();
	}
	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {
			return "/asset/" + template + ".jsp";
		}
		return null;
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
			int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;

			String summary = HtmlUtil.stripHtml(StringUtil.shorten(_documents.getDescription(),abstractLength));

		return summary;
	}

	@Override
	public String getTitle(Locale locale) {
		return _documents.getName();
	}
	@Override
	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse)
		throws Exception {
		Group group = GroupLocalServiceUtil.fetchGroup(_documents.getGroupId());
		if (group.isCompany()) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)liferayPortletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);
			group = themeDisplay.getScopeGroup();
		}
		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
			liferayPortletRequest, group, DocumentsPortletKeys.DOCUMENTS, 0, 0,
			PortletRequest.RENDER_PHASE);
		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.EDIT_DOCUMENTS);portletURL.setParameter(
			"documentsId", String.valueOf(_documents.getDocumentId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());
		return portletURL;
	}
	@Override
	public String getURLView(
		LiferayPortletResponse liferayPortletResponse,
		WindowState windowState)
		throws Exception {
		return super.getURLView(liferayPortletResponse, windowState);
	}
	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect)
		throws Exception {
		if (_assetDisplayPageFriendlyURLProvider != null) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)liferayPortletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);
			String friendlyURL =
				_assetDisplayPageFriendlyURLProvider.getFriendlyURL(
					getClassName(), getClassPK(), themeDisplay);if (Validator.isNotNull(friendlyURL)) {
				return friendlyURL;
			}
		}
		try {
			long plid = PortalUtil.getPlidFromPortletId(
				_documents.getGroupId(), DocumentsPortletKeys.DOCUMENTS
			);
			PortletURL portletURL;
			if (plid == LayoutConstants.DEFAULT_PLID) {
				portletURL = liferayPortletResponse.createLiferayPortletURL(
					getControlPanelPlid(liferayPortletRequest),
					DocumentsPortletKeys.DOCUMENTS,
					PortletRequest.RENDER_PHASE);
			}
			else {
				portletURL =
					PortletURLFactoryUtil.getPortletURLFactory(
					).create(
						liferayPortletRequest, DocumentsPortletKeys.DOCUMENTS, plid, PortletRequest.RENDER_PHASE
					);
			}
			portletURL.setParameter(
				"mvcRenderCommandName", MVCCommandNames.VIEW_DOCUMENTS);
			portletURL.setParameter(
				"documentsId", String.valueOf(_documents.getDocumentId()));String currentUrl = PortalUtil.getCurrentURL(
				liferayPortletRequest
			);
			portletURL.setParameter("redirect", currentUrl);
			return portletURL.toString();
		}
		catch (PortalException pe) {
		}
		catch (SystemException se) {
		}
		return null;
	}
	@Override
	public long getUserId() {
		return _documents.getUserId();
	}
	@Override
	public String getUserName() {
		return _documents.getUserName();
	}
	@Override
	public String getUuid() {
		return _documents.getUserUuid();
	}

//	@Override
//	public boolean hasEditPermission(PermissionChecker permissionChecker)
//		throws PortalException {
//		return DocumentsPermission.contains(
//			permissionChecker, _documents, ActionKeys.UPDATE);
//	}
//	@Override
//	public boolean hasViewPermission(PermissionChecker permissionChecker)
//		throws PortalException {
//		return DocumentsPermission.contains(
//			permissionChecker, _documents, ActionKeys.VIEW);
//	}

	@Override
	public boolean include(
		HttpServletRequest request, HttpServletResponse response,
		String template)
		throws Exception {
		request.setAttribute("documents", _documents);
		return super.include(request, response, template);
	}
	public void setAssetDisplayPageFriendlyURLProvider(
		AssetDisplayPageFriendlyURLProvider
			assetDisplayPageFriendlyURLProvider) {
		_assetDisplayPageFriendlyURLProvider =
			assetDisplayPageFriendlyURLProvider;}
	private AssetDisplayPageFriendlyURLProvider
		_assetDisplayPageFriendlyURLProvider;
	private Documents _documents;
}
