package com.liferay.dc.web.action;

import com.liferay.dc.model.Documents;
import com.liferay.dc.service.DocumentsLocalService;
import com.liferay.dc.web.constants.DocumentsPortletKeys;
import com.liferay.dc.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.util.List;

@Component(property = {
        "javax.portlet.name=" + DocumentsPortletKeys.DOCUMENTS,
        "mvc.command.name=" + MVCCommandNames.ADD_DOCUMENTS,
}, service = MVCActionCommand.class)

public class DocumentsMVCActionCommand extends BaseMVCActionCommand {
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            Documents.class.getName(), actionRequest);
        String name = ParamUtil.getString(actionRequest, "name");
        String description = ParamUtil.getString(actionRequest, "description");
        String link = ParamUtil.getString(actionRequest, "link");

        try {
            documentsLocalService.addDocument(name, description, link, serviceContext);

        } catch (PortalException portalException) {
            System.out.println(portalException.getMessage());
        }

        String redirect = ParamUtil.getString(actionRequest, "redirect");
        sendRedirect(actionRequest, actionResponse);
    }

    @Reference
    DocumentsLocalService documentsLocalService;

}