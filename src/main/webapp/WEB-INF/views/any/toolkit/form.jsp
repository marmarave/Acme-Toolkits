<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="any.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="any.toolkit.form.label.description" path="description"/>
	<acme:input-textbox code="any.toolkit.form.label.assembly-notes" path="assemblyNotes"/>
	<acme:input-money code="any.toolkit.form.label.total-price" path="totalPrice"/>
	<acme:input-url code="any.toolkit.form.label.more-info" path="moreInfo"/>
	
	<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
	<acme:submit code="inventor.toolkit.form.button.update" action="/inventor/item/update"/>
</acme:form>
