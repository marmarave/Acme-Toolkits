<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>

	
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-money code="inventor.toolkit.form.label.totalPrice" path="totalPrice"/>
	<acme:input-url code="inventor.toolkit.form.label.more-info" path="moreInfo"/>
	
	<acme:button code="any.toolkit.form.button.components" action="/any/item/list-master?type=TOOL&masterId=${id}"/>
	<acme:button code="any.toolkit.form.button.tools" action="/any/item/list-master?type=COMPONENT&masterId=${id}"/>
</acme:form> 