package com.liferay.pblink.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.pblink.web.constants.MVCCommandNames;
import com.liferay.pblink.web.constants.PBLinkEntryPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Asset renderer for_pbLinkEntry.
 *
 * @author Mylena Monte
 */
public class PBLinkEntryAssetRenderer extends BaseJSPAssetRenderer<PBLinkEntry> {
	public PBLinkEntryAssetRenderer(PBLinkEntry pbLinkEntry) {
		_pbLinkEntry = pbLinkEntry;
	}
	@Override
	public PBLinkEntry getAssetObject() {
		return _pbLinkEntry;
	}
	@Override
	public String getClassName() {
		return PBLinkEntry.class.getName();
	}
	@Override
	public long getClassPK() {
		return _pbLinkEntry.getPbLinkEntryId();
	}
	@Override
	public long getGroupId() {return _pbLinkEntry.getGroupId();
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

			String summary = HtmlUtil.stripHtml(StringUtil.shorten(_pbLinkEntry.getDescription(),abstractLength));

		return summary;
	}

	@Override
	public String getTitle(Locale locale) {
		return _pbLinkEntry.getName();
	}
	@Override
	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse)
		throws Exception {
		Group group = GroupLocalServiceUtil.fetchGroup(_pbLinkEntry.getGroupId());
		if (group.isCompany()) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)liferayPortletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);
			group = themeDisplay.getScopeGroup();
		}
		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
			liferayPortletRequest, group, PBLinkEntryPortletKeys.PBLINKENTRY, 0, 0,
			PortletRequest.RENDER_PHASE);
		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.EDIT_PBLINKENTRY);portletURL.setParameter(
			"pbLinkEntryId", String.valueOf(_pbLinkEntry.getPbLinkEntryId()));
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
				_pbLinkEntry.getGroupId(), PBLinkEntryPortletKeys.PBLINKENTRY
			);
			PortletURL portletURL;
			if (plid == LayoutConstants.DEFAULT_PLID) {
				portletURL = liferayPortletResponse.createLiferayPortletURL(
					getControlPanelPlid(liferayPortletRequest),
					PBLinkEntryPortletKeys.PBLINKENTRY,
					PortletRequest.RENDER_PHASE);
			}
			else {
				portletURL =
					PortletURLFactoryUtil.getPortletURLFactory(
					).create(
						liferayPortletRequest, PBLinkEntryPortletKeys.PBLINKENTRY, plid, PortletRequest.RENDER_PHASE
					);
			}
			portletURL.setParameter(
				"mvcRenderCommandName", MVCCommandNames.VIEW_PBLINKENTRY);
			portletURL.setParameter(
				"pbLinkEntryId", String.valueOf(_pbLinkEntry.getPbLinkEntryId()));String currentUrl = PortalUtil.getCurrentURL(
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
		return _pbLinkEntry.getUserId();
	}
	@Override
	public String getUserName() {
		return _pbLinkEntry.getUserName();
	}
	@Override
	public String getUuid() {
		return _pbLinkEntry.getUserUuid();
	}

	@Override
	public boolean include(
		HttpServletRequest request, HttpServletResponse response,
		String template)
		throws Exception {
		request.setAttribute("_pbLinkEntry", _pbLinkEntry);
		return super.include(request, response, template);
	}
	public void setAssetDisplayPageFriendlyURLProvider(
		AssetDisplayPageFriendlyURLProvider
			assetDisplayPageFriendlyURLProvider) {
		_assetDisplayPageFriendlyURLProvider =
			assetDisplayPageFriendlyURLProvider;}
	private AssetDisplayPageFriendlyURLProvider
		_assetDisplayPageFriendlyURLProvider;
	private PBLinkEntry _pbLinkEntry;
}
