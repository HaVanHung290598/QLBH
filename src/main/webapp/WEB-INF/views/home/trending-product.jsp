<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container-fluid trending-product">
		<div class="container">
			<div class="row">
				<div class="col-md-12 trending">
					<h1 class="big">Trending</h1>
					<h2 class="small">TRENDING</h2>
				</div>
			</div>
			<div class="row" id="show-trending-content">
				<c:forEach items="${Top5Product}" var="s">
					<div class="col-md-4 col-sm-6 trending-content">
						<img src="<c:url value="/resources/images/${s.image}.jpg"/>" width="100%" height="85%"/>
						<p class="name">${s.product_name}</p>
						<p class="price">$${s.unit_price}</p>
						<p class="star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></p>
					</div>
				</c:forEach>
			</div>				
		</div>
	</div>