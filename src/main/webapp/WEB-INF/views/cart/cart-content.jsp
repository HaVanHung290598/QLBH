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
							<th>Quanlity</th>
							<th>Total</th>
						</tr>
						<tr>
							<td class="product">
								<input type="submit" value="x">
								<img src="<c:url value="/resources/images/product-4.jpg"/>" height="240px" width="auto"/>
							</td>
							<td class="product-title">
								<p>YOUNG WOMAN WEARING DRESS</p>
								<br/>
								<p>Far far away, behind the word mountains, far from the countries</p>
							</td>
							<td class="price">$120.00</td>
							<td>
								<input type="text" name="number-product" class="quanlity">
							</td>
							<td class="total">$120.00</td>
						</tr>
						<tr>
							<td class="product">
								<input type="submit" value="x">
								<img src="<c:url value="/resources/images/product-3.jpg"/>" height="240px" width="auto"/>
							</td>
							<td class="product-title">
								<p>YOUNG WOMAN WEARING DRESS</p>
								<br/>
								<p>Far far away, behind the word mountains, far from the countries</p>
							</td>
							<td class="price">$120.00</td>
							<td>
								<input type="text" name="number-product" class="quanlity">
							</td>
							<td class="total">$120.00</td>
						</tr>
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
							<td>$120.00</td>
						</tr>
						<tr>
							<th>Delivery</th>
							<td>$0.00</td>
						</tr>
						<tr>
							<th>Discout</th>
							<td>$3.00</td>
						</tr>
						<tr class="total">
							<th>TOTAL</th>
							<td>$9.00</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" name="" value="Process to Checkout"></td>
							
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>