<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/admin/${url}" var="action"/>
<form:form modelAttribute="product" action="${action}" method="post">
	<form:label path="">Product Name</form:label>
	<form:input class="form-control" path="product_name"/><br/>
	<form:label path="">Price</form:label>
	<form:input class="form-control" path="unit_price" type="number"/><br/>
	<form:label path="">Description</form:label>
	<form:textarea class="form-control" path="description"/><br/>
	<form:label path="">Imange</form:label>
	<form:input class="form-control" path="image"/><br/>
	<form:label path="">Quantity</form:label>
	<form:input class="form-control" path="quantity_available" type="number"/>
	<form:label path="">Created_at</form:label>
	<form:input class="form-control" path="created_at" type="date"/><br/>
	<form:label path="">Updated_at</form:label>
	<form:input class="form-control" path="updated_at" type="date"/><br/>
	<form:button class="form-control">Submit</form:button>
</form:form>