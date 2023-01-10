package com.liferay.pblink.web.action;

import com.liferay.pblink.model.PBLinkEntry;
import com.liferay.pblink.service.PBLinkEntryLocalService;
import com.liferay.pblink.web.constants.MVCCommandNames;
import com.liferay.pblink.web.constants.PBLinkEntryPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;

@Component(property = {
    "javax.portlet.name=" + PBLinkEntryPortletKeys.PBLINKENTRY,
    "mvc.command.name=" + MVCCommandNames.ADD_PBLINKENTRY,
}, service = MVCActionCommand.class)

public class PBLinkEntryMVCActionCommand extends BaseMVCActionCommand {
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            PBLinkEntry.class.getName(), actionRequest);
        String name = ParamUtil.getString(actionRequest, "name");
        String description = ParamUtil.getString(actionRequest, "description");
        String link = ParamUtil.getString(actionRequest, "link");

        try {
            pbLinkEntryLocalService.addPBLinkEntry(name, description, link, serviceContext);

        } catch (PortalException portalException) {
            System.out.println(portalException.getMessage());
        }

        String redirect = ParamUtil.getString(actionRequest, "redirect");
        sendRedirect(actionRequest, actionResponse);
    }

    @Reference
    PBLinkEntryLocalService pbLinkEntryLocalService;

}