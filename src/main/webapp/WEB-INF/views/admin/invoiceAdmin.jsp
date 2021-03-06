<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/searchInvoiceAdmin" var="url5"/>
<form action="${url5}" method="get">
	<div class="row form-search-invoice">
		<div class="col-md-2 col-sm-2">
			<input type="text" name="id" value="${params.get('id')}" placeholder="Invoice id" class="form-control"/>
		</div>
		<div class="col-md-4 col-sm-4">
			<label>Status</label>
			<select name="status" class="form-control status-invoice">
				<option value=""></option>
				<option value="pending" ${params.get('status') == 'pending' ? 'selected' : ''}>pending</option>
				<option value="delivering" ${params.get('status') == 'delivering' ? 'selected' : ''}>delivering</option>
				<option value="success" ${params.get('status') != 'success' ? '' : 'selected'}>success</option>
				<option value="refunded" ${params.get('status') != 'refunded' ? '' : 'selected'}>refunded</option>
				<option value="canceled" ${params.get('status') != 'canceled' ? '' : 'selected'}>canceled</option>
			</select>
		</div>
		<div class="col-md-2 col-sm-2">			
			<input class="form-control" type="text" name="day" placeholder="Day" value="${params.get('day')}"/>		
		</div>
		<div class="col-md-2 col-sm-2">			
			<input class="form-control" type="text" name="month" placeholder="Month" value="${params.get('month')}"/>	
		</div>
		<div class="col-md-2 col-sm-2">			
			<input class="form-control" type="text" name="year" placeholder="Year" value="${params.get('year')}"/>		
		</div>
		<div class="col-md-4 col-sm-4">			
			<input class="form-control" type="submit" value="submit"/>			
		</div>
	</div>
</form>
<div class="row form-invoice">
	<div class="col-md-12 col-sm-12">
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
					<td class="invoiceId">${s.id}</td>
					<td>${s.discount_amount}%</td>
					<td>$${s.tax}</td>
					<td>${s.total_amount}</td>
					<td>
						<select name="status" class="form-control status" disabled="disabled">
							<option value="pending" ${s.status == 'pending' ? 'selected' : ''}>pending</option>
							<option value="delivering" ${s.status == 'delivering' ? 'selected' : ''}>delivering</option>
							<option value="success" ${s.status == 'success' ? 'selected' : ''}>success</option>
							<option value="refunded" ${s.status == 'refunded' ? 'selected' : ''}>refunded</option>
							<option value="canceled" ${s.status == 'canceled' ? 'selected' : ''}>canceled</option>
						</select>
					</td>
					<td>${s.created_at}</td>
					<c:url value="/admin/invoiceDetails?id=${s.id}&&userId=${s.user_id}" var="url6"/>
					<td>
						<a href="javascript:void(0)" class="repairStatus" title="repair"><i class="fas fa-pencil-alt"></i></a>
						<a href="${url6}" title="detail"><i class="fas fa-info"></i></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<div class="row">
	<c:choose>
		<c:when test="${empty params}">
			<div class="col-md-12 col-sm-12" style="margin-top: 20px;">
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
			<div class="col-md-12 col-sm-12" style="margin-top: 20px;">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	<c:url value="/admin/searchInvoiceAdmin?page=${page-1}&&id=${params.get('id')}&&day=${params.get('day')}&&month=${params.get('month')}&&year=${parmas.get('year')}" var="url3"/>
				  	<c:url value="/admin/searchInvoiceAdmin?page=${page+1}&&id=${params.get('id')}&&day=${params.get('day')}&&month=${params.get('month')}&&year=${parmas.get('year')}" var="url4"/>
				    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url3}">Previous</a></li>
				    <li class="page-item ${page == Math.ceil(size/10) ? 'disabled' : ''}"><a class="page-link" href="${url4}">Next</a></li>
				  </ul>
				</nav>
			</div>
		</c:when>
	</c:choose>
</div>