<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container-fuild productSingle" style="display: ${display}">
		<div class="container">
			<div class="row">
				<div class="col-md-6"><img src="<c:url value="/resources/images/${productDTO.image}.jpg"/>" width="90%" height="auto"/></div>
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-12">
							<h2 class="product-name">${productDTO.product_name}</h2>
							<h3 class="product-price">$${productDTO.unit_price}</h3>
							<p class="description-product">${productDTO.description}</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<form action="cart" method="post">
								<select name="product-size" class="product-size">
									<c:forEach items="${productAttributeDTOs}" var="s">
										<c:if test="${s.attribute == 'size'}">
											<option value="${s.value}">${s.value}</option>
										</c:if>
									</c:forEach>
								</select> <br/>
								<select name="product-color" class="product-size">
									<c:forEach items="${productAttributeDTOs}" var="s">
										<c:if test="${s.attribute == 'color'}">
											<option value="${s.value}">${s.value}</option>
										</c:if>
									</c:forEach>
								</select>
								<div>
									<input type="hidden" name="product-id" value="${productDTO.id}">
									<input onclick="tru()" class="except" type="button" name="except" value="-">
									<input id="number-product" class="number-product" type="text" value="1" name="quantity">
									<input onclick="cong()" class="plus" type="button" name="plus" value="+">
								</div><br/>
								<input type="submit" name="" value="Add to cart">
							</form>
							<c:if test="${not empty error}">
								<input type="hidden" id="error" value="${error}"/>
								<script type="text/javascript" src="<c:url value="/resources/js/error.js"/>"></script>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>