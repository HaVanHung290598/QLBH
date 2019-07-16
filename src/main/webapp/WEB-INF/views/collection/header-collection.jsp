<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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
							<a href="collection" style="color:${color};">Shop <i class="fas fa-angle-down"></i></a> 
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
						<security:authorize access="hasRole('ADMIN')">
							<li>
								<c:url value="/logout" var="url"/>
								<c:url value="/admin/" var="url10"/>
								<a href="${url10}">${user.username}</a>|<a href="${url}">Log out</a>
							</li>
						</security:authorize>
						<security:authorize access="hasRole('USER')">
							<li><a href=""><i class="fas fa-shopping-cart"></i>[${params.size()}]</a>
									<ul class="submenu2">
										<li>New products</li>
										<c:forEach items="${params}" var="s">
											<li>
												<div class="row">
													<div class="col-md-2"><img src="<c:url value="/resources/images/${s.get('image')}.jpg"/>" width="40px" height="auto"/></div>
													<div class="col-md-10">
														<div class="row">
															<div class="col-md-8 list-products">
																<p>${s.get("product-name")}</p>
															</div>
															<div class="col-md-4">
																<p>$${s.get("price")}</p>
															</div>
														</div>
														<div class="row">
															<div class="col-md-12 proc-classification">
																<p>Product classification: ${s.get("size")},${s.get("color")}</p>
															</div>
														</div>
													</div>
												</div>
											</li>
										</c:forEach>
										<li class="carts"><a href="cart">VIEW CART</a></li>
									</ul>
								</li>
								<li>
									<c:url value="/logout" var="url"/>
								<p>${user.username} |</p><a href="${url}">Log out</a>
							</li>
						</security:authorize>
						<c:if test="${empty user}">
							<li>
								<a href="login">Sign in</a>|
								<a href="signUp">Sign up</a>
							</li>
						</c:if>
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