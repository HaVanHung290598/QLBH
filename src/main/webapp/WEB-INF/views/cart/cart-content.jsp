<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="container-fluid cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table class="show-product-cart">
						<tr>
							<th></th>
							<th>Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
						</tr>
						<c:forEach items="${params}" var="s">
							<tr>
								<td class="product">
									<a href="deleteCartItem?user-id=${s.get('user-id')}&&product-id=${s.get('product-id')}">x</a>
									<img src="<c:url value="/resources/images/${s.get('image')}.jpg"/>" height="240px" width="auto"/>
								</td>
								<td class="product-title">
									<p>${s.get("product-name")}</p>
									<br/>
									<p style="opacity:0.5;">Product classification: ${s.get("color")},${s.get("size")}</p>
								</td>
								<td class="price">$<input type="text" value="${s.get('price')}" class="price-product"></td>
								<td>
									<input type="text" name="number-product" value="${s.get('quantity')}" class="quantity" id="quantity" data-price="${s.get('price')}">
								</td>
								<td class="total">$<input type="text" value="${s.get('price')*s.get('quantity')}" class="total-product"></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-6 cart-totals">
					<table>
						<tr>
							<th colspan="2">CART TOTALS</th>
						</tr>
						<tr>
							<th>Subtotal</th>
							<td>$<input type="text" value="" class="subtotal"></td>
						</tr>
						<tr>
							<th>Delivery</th>
							<td>$<input type="text" value="0" class="delivery"></td>
						</tr>
						<tr>
							<th>Discout</th>
							<td>$<input type="text" value="0" class="discount"></td>
						</tr>
						<tr class="total">
							<th>TOTAL</th>
							<td>$<input type="text" value="0" class="total-price-cartItem"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" name="" value="Process to Checkout"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>