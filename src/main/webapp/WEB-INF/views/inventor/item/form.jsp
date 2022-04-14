<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form> 
	<acme:input-textbox code="inventor.tool.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.tool.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.tool.form.label.technology" path="technology"/>
	<acme:input-textbox code="inventor.tool.form.label.description" path="description"/>
	<acme:input-money code="inventor.tool.form.label.retail-price" path="retailPrice"/>
	<acme:input-url code="inventor.tool.form.label.more-info" path="moreInfo"/>
	
</acme:form>
