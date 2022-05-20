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
    <acme:input-integer code="inventor.itemQuantity.form.label.quantity" path="quantity"/>
	<jstl:if test="${type == 'TOOL'}">
    <acme:input-select code="inventor.itemQuantity.form.label.item" path="itemId">
        <jstl:forEach items="${tools}" var="item">
            <acme:input-option code="${item.getCode()}   ${item.getName()}" value="${item.getId()}" selected="${item.getId() == itemId}"/>
        </jstl:forEach>
    </acme:input-select>
    </jstl:if>
	<jstl:if test="${type == 'COMPONENT'}">
    <acme:input-select code="inventor.itemQuantity.form.label.item" path="itemId">
        <jstl:forEach items="${components}" var="item">
            <acme:input-option code="${item.getCode()}   ${item.getName()}" value="${item.getId()}" selected="${item.getId() == itemId}"/>
        </jstl:forEach>
    </acme:input-select>
    </jstl:if>
    <jstl:choose>
    <jstl:when test="${command == 'create'}">
        <acme:submit code="inventor.item-quantity.button.create" action="/inventor/item-quantity/create?masterId=${masterId}"/>
    </jstl:when>
    </jstl:choose>
</acme:form>