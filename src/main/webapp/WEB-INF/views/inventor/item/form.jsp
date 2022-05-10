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

	<acme:input-textbox code="inventor.item.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.item.form.label.code" path="code"/>
	<acme:input-select code="inventor.item.form.label.type" path="type" readonly="true">
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${type == 'COMPONENT'}"/>
		<acme:input-option code="TOOL" value="TOOL" selected="${type == 'TOOL'}"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.item.form.label.technology" path="technology"/>
	<acme:input-textbox code="inventor.item.form.label.description" path="description"/>
	<acme:input-money code="inventor.item.form.label.retailPrice" path="retailPrice"/>
	<acme:input-checkbox code="inventor.item.form.label.published" path="published"/>
	<acme:input-url code="inventor.item.form.label.more-info" path="moreInfo"/>
	
	
	<acme:submit code="inventor.item.form.button.create" action="/inventor/item/create"/>
	<acme:submit code="inventor.item.form.button.update" action="/inventor/item/update"/>

	
	
</acme:form> 
