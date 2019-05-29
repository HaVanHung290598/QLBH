<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container-fluid products">
		<div class="container">
			<div class="row">
				<div class="col-md-12 trending">
					<h1 class="big">Products</h1>
					<h2 class="small">OUR PRODUCT</h2>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${productDTOs}" var="s">
					<div class="col-md-3 col-sm-6 products-content">
						<div class="box"><a href="productSingle?productId=${s.id}"><img src="<c:url value="/resources/images/${s.image}.jpg"/>" width="100%" height="382.5px"/></a></div>
						<div class="box"><a href="productSingle?productId=${s.id}" class="name">${s.product_name}</a></div>
						<div class="box">
							<p class="price">$${s.unit_price}</p>
							<p class="star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
						</div>
						<hr/>
						<a href="" class="add-cart">ADD TO CART+</a>
						<p class="tym"><i class="far fa-heart"></i></p>
					</div>
				</c:forEach>
				<div class="row" style="display: ${display};">
					<div class="col-md-12" style="margin-top: 20px;">
						<nav aria-label="Page navigation example">
						  <ul class="pagination">
						    <li class="page-item ${pages-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="collection?page=${pages-1}">Previous</a></li>
						    <li class="page-item ${productDTOs.size() < 8 ? 'disabled' : ''}"><a class="page-link" href="collection?page=${pages+1}">Next</a></li>
						  </ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>