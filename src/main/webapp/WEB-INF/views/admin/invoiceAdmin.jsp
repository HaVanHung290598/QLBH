<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/searchInvoiceAdmin" var="url5"/>
<form action="${url5}" method="get">
	<div class="row form-search-invoice">
		<div class="col-md-3">			
			<input class="form-control" type="text" name="day" placeholder="Day" value="${params.get('day')}"/>		
		</div>
		<div class="col-md-3">			
			<input class="form-control" type="text" name="month" placeholder="Month" value="${params.get('month')}"/>	
		</div>
		<div class="col-md-3">			
			<input class="form-control" type="text" name="year" placeholder="Year" value="${params.get('year')}"/>		
		</div>
		<div class="col-md-3">			
			<input class="form-control" type="submit" value="submit"/>			
		</div>
	</div>
</form>
<div class="row form-invoice">
	<div class="col-md-12">
		<table class="table">
			<tr>
				<th>Invoice Id</th>
				<th>Discount Amount</th>
				<th>Tax</th>
				<th>Total Amount</th>
				<th>Status</th>
				<th>Created At</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${invoiceDTOs}" var="s">
				<tr>
					<td>${s.id}</td>
					<td>${s.discount_amount}</td>
					<td>${s.tax}</td>
					<td>${s.total_amount}</td>
					<td>${s.status}</td>
					<td>${s.created_at}</td>
					<c:url value="/admin/invoiceDetails?id=${s.id}&&userId=${s.user_id}" var="url6"/>
					<td><a href="${url6}"><i class="fas fa-info"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<div class="row">
	<c:choose>
		<c:when test="${empty params}">
			<div class="col-md-12" style="margin-top: 20px;">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	<c:url value="/admin/invoiceAdmin?page=${page-1}" var="url1"/>
				  	<c:url value="/admin/invoiceAdmin?page=${page+1}" var="url2"/>
				    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url1}">Previous</a></li>
				    <li class="page-item ${page == Math.ceil(size/10) ? 'disabled' : ''}"><a class="page-link" href="${url2}">Next</a></li>
				  </ul>
				</nav>
			</div>
		</c:when>
		<c:when test="${not empty params}">
			<div class="col-md-12" style="margin-top: 20px;">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	<c:url value="/admin/searchInvoiceAdmin?page=${page-1}&&day=${params.get('day')}&&month=${params.get('month')}&&year=${parmas.get('year')}" var="url3"/>
				  	<c:url value="/admin/searchInvoiceAdmin?page=${page+1}&&day=${params.get('day')}&&month=${params.get('month')}&&year=${parmas.get('year')}" var="url4"/>
				    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url3}">Previous</a></li>
				    <li class="page-item ${page == Math.ceil(size/10) ? 'disabled' : ''}"><a class="page-link" href="${url4}">Next</a></li>
				  </ul>
				</nav>
			</div>
		</c:when>
	</c:choose>
</div>