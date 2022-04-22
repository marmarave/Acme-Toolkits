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
 	<acme:input-textbox code="administrator.administratordashboard.form.label.totalNumComponents" path="totalNumComponents"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.maxPriceOfComponents" path="maxPriceOfComponents"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.minPriceOfComponents" path="minPriceOfComponents"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.averagePriceOfComponents" path="averagePriceOfComponents"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.deviationPriceOfComponents" path="deviationPriceOfComponents"/>
 	<acme:message code="administrator.administratordashboard.form.label.maxPriceOfTools"/>
	<table>	
 		<jstl:forEach items="${maxPriceOfTools}" var="i"> 
 			<tr>	
				<th>	
					<acme:print value="${i.currency}"/>
				</th>
				<td>				
					<acme:print value="${i.amount}"/>				
				</td>		
			</tr>
 		</jstl:forEach>
 	</table>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.totalNumTools" path="totalNumTools"/>
 	<%-- <acme:input-money code="administrator.administratordashboard.form.label.maxPriceOfTools" path="maxPriceOfTools"/>--%>
 	<acme:input-money code="administrator.administratordashboard.form.label.minPriceOfTools" path="minPriceOfTools"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.averagePriceOfTools" path="averagePriceOfTools"/>
 	<acme:input-money code="administrator.administratordashboard.form.label.deviationPriceOfTools" path="deviationPriceOfTools"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.numberOfAcceptedPatronages" path="numberOfAcceptedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.maxAcceptedPatronages" path="maxAcceptedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.minAcceptedPatronages" path="minAcceptedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.averageAcceptedPatronages" path="averageAcceptedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.deviationAcceptedPatronages" path="deviationAcceptedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.numberOfDeniedPatronages" path="numberOfDeniedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.maxDeniedPatronages" path="maxDeniedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.minDeniedPatronages" path="minDeniedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.averageDeniedPatronages" path="averageDeniedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.deviationDeniedPatronages" path="deviationDeniedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.numberOfProposedPatronages" path="numberOfProposedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.maxProposedPatronages" path="maxProposedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.minProposedPatronages" path="minProposedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.averageProposedPatronages" path="averageProposedPatronages"/>
 	<acme:input-textbox code="administrator.administratordashboard.form.label.deviationProposedPatronages" path="deviationProposedPatronages"/>
 </acme:form> 