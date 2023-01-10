package com.liferay.pblink.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.pblink.constants.PBLinkEntryConstants;
import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.pblink.service.PBLinkEntryLocalService;
import com.liferay.pblink.web.constants.MVCCommandNames;
import com.liferay.pblink.web.constants.PBLinkEntryPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

/**
 * Asset renderer factory component for pbLinkEntry.
 *
 * @author Mylena Monte
 */

@Component(
	immediate = true,
	property = "javax.portlet.name=" + PBLinkEntryPortletKeys.PBLINKENTRY,
	service = AssetRendererFactory.class
)
public class PBLinkEntryAssetRendererFactory
	extends BaseAssetRendererFactory<PBLinkEntry> {
	public static final String CLASS_NAME = PBLinkEntry.class.getName();
	public static final String TYPE = "pbLinkEntry";

	public PBLinkEntryAssetRendererFactory() {
		setClassName(CLASS_NAME);
		setLinkable(true);
		setPortletId(PBLinkEntryPortletKeys.PBLINKENTRY);
		setSearchable(true);
	}
	@Override
	public AssetRenderer<PBLinkEntry> getAssetRenderer(long classPK, int type)
		throws PortalException {
		PBLinkEntry pbLinkEntry = _pbLinkEntryLocalService.getPBLinkEntry(classPK);

		PBLinkEntryAssetRenderer
			pbLinkEntryAssetRenderer = new PBLinkEntryAssetRenderer(pbLinkEntry);

		pbLinkEntryAssetRenderer.setAssetDisplayPageFriendlyURLProvider(_assetDisplayPageFriendlyURLProvider);

		pbLinkEntryAssetRenderer.setAssetRendererType(type);

		pbLinkEntryAssetRenderer.setServletContext(_servletContext);

		return pbLinkEntryAssetRenderer;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse, long classTypeId) {
		PortletURL portletURL = _portal.getControlPanelPortletURL(
			liferayPortletRequest, getGroup(liferayPortletRequest), PBLinkEntryPortletKeys.PBLINKENTRY, 0, 0, PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.ADD_PBLINKENTRY);
		return portletURL;
	}

	@Override
	public PortletURL getURLView(
		LiferayPortletResponse liferayPortletResponse,
		WindowState windowState) {
		LiferayPortletURL liferayPortletURL =
			liferayPortletResponse.createLiferayPortletURL(
				PBLinkEntryPortletKeys.PBLINKENTRY, PortletRequest.RENDER_PHASE);
		try {
			liferayPortletURL.setWindowState(windowState);
		}
		catch (WindowStateException wse) {
		}
		return liferayPortletURL;
	}

	@Reference
	private AssetDisplayPageFriendlyURLProvider
		_assetDisplayPageFriendlyURLProvider;

	@Reference
	private PBLinkEntryLocalService _pbLinkEntryLocalService;
	@Reference
	private Portal _portal;
	@Reference(
		target = "(osgi.web.symbolic.name=com.liferay.pblink.web)"
	)
	private ServletContext _servletContext;
}
