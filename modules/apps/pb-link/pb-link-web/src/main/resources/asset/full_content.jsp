<%@ include file="/init.jsp"%>
<%
	AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
	String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);
	PBLinkEntry pbLinkEntry = (pbLinkEntry)request.getAttribute("pbLinkEntry");
%>
<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
	<h3 class="title"><%= HtmlUtil.escape(pbLinkEntry.getName()) %></h3>
</aui:a>
<div class="autofit-col autofit-col-expand">
	<%= HtmlUtil.escape(pbLinkEntry.getDescription()) %>
</div>