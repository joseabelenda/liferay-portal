<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ page import="com.liferay.dc.web.constants.MVCCommandNames" %>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%=MVCCommandNames.ADD_DOCUMENTS%>" var="addDocumentsURL">
        <portlet:param name="redirect" value="${param.redirect}"/>
    </portlet:actionURL>

<aui:form
  action="<%= addDocumentsURL %>"
  method="post"
  name="fm"
  cssClass="ml-5 w-100"
>
  <aui:row>
    <h1>Documents</h1>
  </aui:row>
  <aui:row>
    <div class="mr-3">
      <aui:input name="name" label="Name" type="text" required="true">
        <aui:validator
          name="maxLength"
          errorMessage="Nome deve ter menos de 50 caracteres"
          >50</aui:validator
        >
      </aui:input>
    </div>
    <div class="mr-3">
      <aui:input
        name="link"
        label="Link"
        type="text"
        required="true"
      >
        <aui:validator
          name="maxLength"
          errorMessage="URL deve ter menos de 60 caracteres"
          >60</aui:validator
        >
      </aui:input>
    </div>
    <div class="mr-3">
      <aui:input
        name="description"
        label="Description"
        type="text"
        required="true"
      >
        <aui:validator
          name="maxLength"
          errorMessage="Description deve ter menos de 100 caracteres"
          >100</aui:validator
        >
      </aui:input>
    </div>
  </aui:row>
  <aui:button-row>
    <aui:button
      cssClass="btn-lg"
      name="saveButton"
      primary="true"
      type="submit"
      value="Register"
    />
    <aui:button
      cssClass="btn-lg"
      href="#"
      name="cancelButton"
      type="cancel"
      value="Cancel"
    />
  </aui:button-row>
</aui:form>