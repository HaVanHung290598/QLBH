<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12 collection">
		<table class="table table-hover">
			<tr>
				<th>Product Name</th>
				<th>Image</th>
				<th>Unit price</th>
				<th>Quantity</th>
				<th>Created at</th>
				<th>Updated at</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${productDTOs}" var="s">
				<tr>
					<td>${s.product_name}</td>
					<td><img src="<c:url value="/resources/images/${s.image}.jpg"/>" width="75px" height="auto"/></td>
					<td>$${s.unit_price}</td>
					<td>${s.quantity_available}</td>
					<td>${s.created_at}</td>
					<td>${s.updated_at}</td>
					<td>
						<a href=""><i class="fas fa-recycle"></i></a>
						<a href=""><i class="far fa-trash-alt"></i></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:choose>
			<c:when test="${empty product_name}">
				<div class="col-md-12" style="margin-top: 20px;">
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  	<c:url value="/admin/product?pages=${pages-1}" var="url1"/>
					  	<c:url value="/admin/product?pages=${pages+1}" var="url2"/>
					    <li class="page-item ${pages-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url1}">Previous</a></li>
					    <li class="page-item ${pages == Math.ceil(size/8) ? 'disabled' : ''}"><a class="page-link" href="${url2}">Next</a></li>
					  </ul>
					</nav>
				</div>
			</c:when>
			<c:when test="${not empty product_name}">
				<div class="col-md-12" style="margin-top: 20px;">
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  	<c:url value="/admin/search?productName=${product_name}&&pages=${pages-1}" var="url3"/>
					  	<c:url value="/admin/search?productName=${product_name}&&pages=${pages+1}" var="url4"/>
					    <li class="page-item ${pages-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url3}">Previous</a></li>
					    <li class="page-item ${pages == Math.ceil(size/8) ? 'disabled' : ''}"><a class="page-link" href="${url4}">Next</a></li>
					  </ul>
					</nav>
				</div>
			</c:when>
		</c:choose>
	</div>
</div>
