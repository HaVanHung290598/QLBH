<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
	<div class="overlay-text-1">H2S - TIME TO GET DRESS</div>
	<div class="overlay-text-2">SINCE - 1998</div>
	<header class="container-fluid">
		<div class="overlay"></div>
		<div class="container">
			<div class="row main-menu">
				<div class="col-md-6 logo">
					<h1><a href="">H 2 S</a></h1>
				</div>
				<div class="col-md-6">
					<ul class="list-unstyled menu">
						<li><a id="home" href="home" style="color:${color};">Home</a></li>
						<li>
							<a href="collection">Shop &nbsp;&nbsp; <i class="fas fa-angle-down"></i></a>
							<ul id="submenu">
								<li><a href="collection">Shop</a></li>
								<li><a href="productSingle">Single Product</a></li>
								<li><a href="cart">Cart</a></li>
							</ul>
						</li>
						<li><a href="">About</a></li>
						<li><a href="">Contact</a></li>
						<security:authorize access="isAuthenticated()">
							<security:authentication property="principal" var="user"/>
						</security:authorize>
						<c:choose>
								<c:when test="${user.username == null}">
									<li>
										<a href="">Sign in</a>|
										<a href="">Sign up</a>
									</li>
								</c:when>
								<c:when test="${user.username != null}">
									<li><a href=""><i class="fas fa-shopping-cart"></i>[0]</a>
										<ul class="submenu2">
											<li>New products</li>
											<li>
												<div class="row">
													<div class="col-md-2"><img src="<c:url value="/resources/images/product-4.jpg"/>" width="40px" height="auto"/></div>
													<div class="col-md-6 list-products">
														<p>Young Woman Wearing Dress</p>
														<p>SIZE: SMALL</p>
													</div>
													<div class="col-md-4">
														<p>$120.00</p>
														<a href="" class="delete-product">Delete</a>
													</div>
												</div>
											</li>
											<li>
												<div class="row">
													<div class="col-md-2"><img src="<c:url value="/resources/images/product-5.jpg"/>" width="40px" height="auto"/></div>
													<div class="col-md-6 list-products">
														<p>Young Woman Wearing Dress</p>
														<p>SIZE: SMALL</p>
													</div>
													<div class="col-md-4">
														<p>$120.00</p>
														<a href="" class="delete-product">Delete</a>
													</div>
												</div>
											</li>
											<li class="carts"><a href="cart">VIEW CART</a></li>
										</ul>
									</li>
									<li>
										<p>${user.username} |</p><a href="logout">Log out</a>
									</li>
								</c:when>
							</c:choose>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 header-content">
					<p class="lable-1">LE STYLIST</p>
					<p class="lable-2">- W E A R&nbsp; Y O U R&nbsp; D R E S S -</p>
					<a class="lable-3" href=""><i class="fas fa-angle-down"></i></a>
				</div>
			</div>
		</div>
	</header>