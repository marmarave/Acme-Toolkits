<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.tool.list.label.name" path="name" width="10%"/>
	<acme:list-column code="inventor.tool.list.label.code" path="code" width="10%"/>
	<acme:list-column code="inventor.tool.list.label.technology" path="technology" width="20%"/>
	<acme:list-column code="inventor.tool.list.label.description" path="description" width="60%"/>
</acme:list>
	
	

