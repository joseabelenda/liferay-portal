package com.liferay.pblink.web.portlet;

import com.liferay.pblink.web.constants.PBLinkEntryPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author me
 */
@Component(immediate = true, property = {
		"com.liferay.portlet.display-category=Petrobras",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=PB Link Entry",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PBLinkEntryPortletKeys.PBLINKENTRY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
}, service = Portlet.class)
public class PBLinkEntryPortlet extends MVCPortlet {
}