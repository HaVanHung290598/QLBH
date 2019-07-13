<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/searchProduct" var="url5"/>
<form action="${url5}" method="get">
	<div class="row form-search">
		<div class="col-md-6 col-sm-12">
			<label>Price</label>
			<select name="sortPrice" class="form-control">
				<option value=""></option>
				<option value="ASC" ${params.get("sortPrice") == "ASC" ? "selected" : ""}>Ascending</option>
				<option value="DESC" ${params.get("sortPrice") == "DESC" ? "selected" : ""}>Decrease</option>
			</select>
		</div>
		<div class="col-md-6 col-sm-12">
			<label>Quantity</label>
			<select name="sortQuantity" class="form-control">
				<option value=""></option>
				<option value="ASC" ${params.get("sortQuantity") == "ASC" ? "selected" : ""}>Ascending</option>
				<option value="DESC" ${params.get("sortQuantity") == "DESC" ? "selected" : ""}>Decrease</option>
			</select>
		</div>
		<div class="col-md-6 col-sm-12">
			<label>Created_at</label>
			<input class="form-control" type="date" name="created_at" value="${params.get('created_at')}" placeholder="Created_at"/>
		</div>
		<div class="col-md-6 col-sm-12">
			<label>Updated_at</label>
			<input class="form-control" type="date" name="updated_at" value="${params.get('updated_at')}" placeholder="Updated_at"/>
		</div>
		<div class="col-md-2 col-sm-3">
			<input class="form-control" type="submit" value="Search"/>
		</div>	
	</div>
</form>
<div class="row">
	<div class="col-md-12 collection">
		<table class="table">
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
						<c:url value="/admin/repairProduct?id=${s.id}" var="url8"/>
						<a href="${url8}"><i class="fas fa-recycle"></i></a>
						<a href=""><i class="far fa-trash-alt"></i></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<c:choose>
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
			<c:when test="${not empty params}">
				<div class="col-md-12" style="margin-top: 20px;">
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  	<c:url value="/admin/searchProduct?pages=${pages-1}&&sortPrice=${params.get('sortPrice')}&&sortQuantity=${params.get('sortQuantity')}&&created_at=${params.get('created_at')}&&updated_at=${params.get('updated_at')}" var="url6"/>
					  	<c:url value="/admin/searchProduct?pages=${pages+1}&&sortPrice=${params.get('sortPrice')}&&sortQuantity=${params.get('sortQuantity')}&&created_at=${params.get('created_at')}&&updated_at=${params.get('updated_at')}" var="url7"/>
					    <li class="page-item ${pages-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url6}">Previous</a></li>
					    <li class="page-item ${pages == Math.ceil(size/8) ? 'disabled' : ''}"><a class="page-link" href="${url7}">Next</a></li>
					  </ul>
					</nav>
				</div>
			</c:when>
			<c:otherwise>
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
			</c:otherwise>
		</c:choose>
	</div>
</div>
