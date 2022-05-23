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
	<jstl:if test="${type == 'TOOL'}">
	<acme:input-integer code="inventor.itemQuantity.form.label.quantity" path="quantity"  readonly="true"/>
    <acme:input-select code="inventor.itemQuantity.form.label.item" path="itemId">
        <jstl:forEach items="${tools}" var="item">
            <acme:input-option code="${item.getCode()}   ${item.getName()}" value="${item.getId()}" selected="${item.getId() == itemId}"/>
        </jstl:forEach>
    </acme:input-select>
    </jstl:if>
	<jstl:if test="${type == 'COMPONENT'}">
	<acme:input-integer code="inventor.itemQuantity.form.label.quantity" path="quantity"/>
    <acme:input-select code="inventor.itemQuantity.form.label.item" path="itemId">
        <jstl:forEach items="${components}" var="item">
            <acme:input-option code="${item.getCode()}   ${item.getName()}" value="${item.getId()}" selected="${item.getId() == itemId}"/>
        </jstl:forEach>
    </acme:input-select>
    </jstl:if>
    <jstl:choose>
    <jstl:when test="${command == 'create'}">
    	<jstl:if test="${type == 'TOOL' && draftMode == true}">
        	<acme:submit code="inventor.item-quantity.tool.button.create" action="/inventor/item-quantity/create?masterId=${masterId}"/>
    	</jstl:if>
    	<jstl:if test="${type == 'COMPONENT'  && draftMode == true}">
        	<acme:submit code="inventor.item-quantity.component.button.create" action="/inventor/item-quantity/create?masterId=${masterId}"/>
    	</jstl:if>
    </jstl:when>
    <jstl:when test="${command == 'delete'}">
    	<jstl:if test="${type == 'TOOL' && draftMode == true}">
        	<acme:input-select code="inventor.itemQuantity.form.delete.tool" path="itemId">
        		<jstl:forEach items="${toolkitTools}" var="tool">
            		<acme:input-option code="${tool.getCode()}   ${tool.getName()}" value="${tool.getId()}" selected="${tool.getId() == itemId}"/>
        		</jstl:forEach>
    		</acme:input-select>
    	</jstl:if>
    	<jstl:if test="${type == 'COMPONENT'  && draftMode == true}">
        	<acme:input-select code="inventor.itemQuantity.form.delete.component" path="itemId">
        		<jstl:forEach items="${toolkitComponents}" var="component">
            		<acme:input-option code="${component.getCode()}   ${component.getName()}" value="${component.getId()}" selected="${component.getId() == itemId}"/>
        		</jstl:forEach>
    		</acme:input-select>
    	</jstl:if>
    </jstl:when>
    </jstl:choose>
</acme:form>