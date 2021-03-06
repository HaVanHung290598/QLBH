<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/${url}" var="action"/>
<form action="${action}" method="post" enctype="multipart/form-data" class="form-product">
	<table class="table">
		<tr>
			<th><h2>${headerPage}</h2></th>
		</tr>
		<tr>
			<td>Product Name</td>
			<td>
				<input type="hidden" name="id" value="${product.id}"/>
				<input type="text" name="product_name" class="form-control" placeholder="Product Name" value="${product.product_name}"/>
			</td>
		</tr>
		<tr>
			<td>Price</td>
			<td><input type="number" name="unit_price" class="form-control" placeholder="Price" value="${product.unit_price}"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea rows="4" cols="" name="description" class="form-control" placeholder="Description">${product.description}</textarea></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input type="number" name="quantity_available" class="form-control" placeholder="Quantity" value="${product.quantity_available}"/></td>
		</tr>
		<tr style="display:${display}">
			<td>Image</td>
			<td colspan="1"><input type="file" name="file" multiple="multiple"/></td>
		</tr>
		<tr>
			<td>Color</td>
			<td>
				<input type="text" name="color" />
			</td>
		</tr>
		<tr>
			<td>Size</td>
			<td>
				<input type="text" multiple="multiple">
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" class="form-control"/></td>
		</tr>
	</table>	
</form>