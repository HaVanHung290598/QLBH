<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<header class="container-fluid">
		<div class="container">
			<div class="row main-menu">
				<div class="col-md-6 logo">
					<h1><a href="">H 2 S</a></h1>
				</div>
				<div class="col-md-6">
					<ul class="list-unstyled menu">
						<li><a id="home" href="home">Home</a></li>
						<li>
							<a href="collection">Shop <i class="fas fa-angle-down"></i></a> 
							<ul id="submenu">
								<li><a href="collection">Shop</a></li>
								<li><a href="productSingle">Single Product</a></li>
								<li><a href="cart">Cart</a></li>
							</ul>
						</li>
						<li><a href="">About</a></li>
						<li><a href="">Contact</a></li>
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
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 header-content">
					<h1 class="lable-1">${head}</h1>
					<a href="home" class="lable-2">${home}</a>
					<p class="lable-3">${page}</p>
				</div>
			</div>
		</div>
	</header>