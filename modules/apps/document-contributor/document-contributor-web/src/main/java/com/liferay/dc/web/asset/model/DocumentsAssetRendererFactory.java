package com.liferay.dc.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.dc.constants.DocumentsConstants;
import com.liferay.dc.model.Documents;
import com.liferay.dc.service.DocumentsLocalService;
import com.liferay.dc.web.constants.DocumentsPortletKeys;
import com.liferay.dc.web.constants.MVCCommandNames;
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
 * Asset renderer factory component for documents.
 *
 * @author Mylena Monte
 */

@Component(
	immediate = true,
	property = "javax.portlet.name=" + DocumentsPortletKeys.DOCUMENTS,
	service = AssetRendererFactory.class
)
public class DocumentsAssetRendererFactory
	extends BaseAssetRendererFactory<Documents> {
	public static final String CLASS_NAME = Documents.class.getName();
	public static final String TYPE = "documents";

	public DocumentsAssetRendererFactory() {
		setClassName(CLASS_NAME);
		setLinkable(true);
		setPortletId(DocumentsPortletKeys.DOCUMENTS);
		setSearchable(true);
	}
	@Override
	public AssetRenderer<Documents> getAssetRenderer(long classPK, int type)
		throws PortalException {
		Documents documents = _documentsLocalService.getDocuments(classPK);

		DocumentsAssetRenderer documentsAssetRenderer = new DocumentsAssetRenderer(documents);

		documentsAssetRenderer.setAssetDisplayPageFriendlyURLProvider(_assetDisplayPageFriendlyURLProvider);

		documentsAssetRenderer.setAssetRendererType(type);

		documentsAssetRenderer.setServletContext(_servletContext);

		return documentsAssetRenderer;
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
			liferayPortletRequest, getGroup(liferayPortletRequest), DocumentsPortletKeys.DOCUMENTS, 0, 0, PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.ADD_DOCUMENTS);
		return portletURL;
	}

	@Override
	public PortletURL getURLView(
		LiferayPortletResponse liferayPortletResponse,
		WindowState windowState) {
		LiferayPortletURL liferayPortletURL =
			liferayPortletResponse.createLiferayPortletURL(
				DocumentsPortletKeys.DOCUMENTS, PortletRequest.RENDER_PHASE);
		try {
			liferayPortletURL.setWindowState(windowState);
		}
		catch (WindowStateException wse) {
		}
		return liferayPortletURL;
	}

	@Override
	public boolean hasAddPermission(
		PermissionChecker permissionChecker, long groupId, long classTypeId)
		throws Exception {
		return _portletResourcePermission.contains(
			permissionChecker, groupId, ActionKeys.ADD_ENTRY);
	}

	@Override
	public boolean hasPermission(
		PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {
		return _documentsModelResourcePermission.contains(
			permissionChecker, classPK, actionId);
	}
	@Reference
	private AssetDisplayPageFriendlyURLProvider
		_assetDisplayPageFriendlyURLProvider;

	@Reference
	private DocumentsLocalService _documentsLocalService;
	@Reference(
		target = "(model.class.name=com.liferay.dc.model.Documents)"
	)
	private ModelResourcePermission<Documents>
		_documentsModelResourcePermission;
	@Reference
	private Portal _portal;

	@Reference(target = "(resource.name=" + DocumentsConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;
	@Reference
	private PortletURLFactory _portletURLFactory;
	@Reference(
		target = "(osgi.web.symbolic.name=com.liferay.dc.web)"
	)
	private ServletContext _servletContext;
}
