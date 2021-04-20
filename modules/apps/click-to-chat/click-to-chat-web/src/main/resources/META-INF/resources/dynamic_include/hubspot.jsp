<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<%
String[] credentials = clickToChatChatProviderAccountId.split("/");
%>

<script async defer id="hs-script-loader" src="//js-na1.hs-scripts.com/<%= credentials[0] %>.js" type="text/javascript"></script>

<c:if test="<%= themeDisplay.isSignedIn() %>">
	<script type="text/javascript">
		window.hsConversationsSettings = {
			loadImmediately: false,
		};
		window.hsConversationsSettings = {
			identificationEmail: '<%= user.getEmailAddress() %>',
			identificationToken:
				'<%= HubspotConnectionUtil.fetchToken(user, credentials[1]) %>',
		};
		window.HubSpotConversations.widget.load();
	</script>
</c:if>