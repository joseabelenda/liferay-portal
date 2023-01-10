<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%=MVCCommandNames.ADD_PBLINKENTRY%>" var="addPBLinkEntryURL">
        <portlet:param name="redirect" value="${param.redirect}"/>
    </portlet:actionURL>

<aui:form
  action="<%= addPBLinkEntryURL %>"
  method="post"
  name="fm"
  cssClass="mx-3"
>
  <aui:row cssClass="ml-2">
    <h1>PBLinkEntry</h1>
  </aui:row>
  <aui:col>
    <div>
      <aui:input name="name" label="Name" type="text" required="true">
        <aui:validator
          name="maxLength"
          errorMessage="Nome deve ter menos de 50 caracteres"
          >50</aui:validator
        >
      </aui:input>
    </div>
    <div>
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
    <div>
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
  </aui:col>
  <aui:row cssClass="justify-content-end">
    <aui:button
      cssClass="btn-lg mr-3"
      name="saveButton"
      primary="true"
      type="submit"
      value="Register"
    />
    <aui:button
      cssClass="btn-lg mr-4"
      href="#"
      name="cancelButton"
      type="cancel"
      value="Cancel"
    />
  </aui:row>
</aui:form>
<div class="col-md-12 mx-3">
<h5>PBLinkEntry</h5>

<% List<PBLinkEntry> pbLinkEntries = PBLinkEntryLocalServiceUtil.listPBLinkEntries(); %>

<c:choose>
	<c:when test="<%= pbLinkEntries.size() > 0 %>">
		<table class="table">
			<thead>
                <tr>
                  <th scope="col" class="bg-primary text-light">Name</th>
                  <th scope="col" class="bg-primary text-light">Description</th>
                  <th scope="col" class="bg-primary text-light">Link</th>
                </tr>
              </thead>
              <tbody>
				<c:forEach items="<%= pbLinkEntries %>" var="pbLinkEntries">
					<tr>
						<td>${pbLinkEntries.name}</td>
						<td>${pbLinkEntries.description}</td>
						<td>${pbLinkEntries.link}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<em>There are no PB Link Entries.</em>
	</c:otherwise>
</c:choose>
</div>