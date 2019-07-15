<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12 inforInvoice">
		<div class="row">
			<div class="col-md-8 col-sm-8">
				<h1>Code invoice: ${invoiceDTO.id}</h1>
			</div>
			<div class="col-md-4 col-sm-4">
				<h1>H2S</h1>
			</div>
		</div>
		<div class="row inforUsers">
			<div class="col-md-6 col-sm-6">
				<table class="table">
					<tr>
						<th>Full name:</th>
						<td>${userDTO.fullname}</td>
					</tr>
					<tr>
						<th>Address:</th>
						<td>${userDTO.address}</td>
					</tr>
				</table>
			</div>
			<div class="col-md-6 col-sm-6">
				<table class="table">
					<tr>
						<th>Phone number:</th>
						<td>${userDTO.phone}</td>
					</tr>
					<tr>
						<th>Address:</th>
						<td>${userDTO.email}</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row inforProducts">
			<div class="col-md-12 col-sm-12">
				<table class="table">
					<tr>
						<th>Product Name</th>
						<th>Unit price</th>
						<th>Quantity</th>
						<th>Size</th>
						<th>Color</th>
						<th>Discount amount</th>
						<th>Created at</th>
					</tr>
					<c:forEach items="${informationInvoice}" var="s">
						<tr>
							<td>${s.get("product").product_name}</td>
							<td>${s.get("product").unit_price}</td>
							<td>${s.get("invoiceItem").quantity}</td>
							<td>${s.get("invoiceItem").size}</td>
							<td>${s.get("invoiceItem").color}</td>
							<td>${s.get("invoiceItem").discount_amount}</td>
							<td>${s.get("invoiceItem").created_at}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-sm-6">
				<table class="table">
					<tr>
						<th>Discount amount:</th>
						<td>${invoiceDTO.discount_amount}</td>
					</tr>
					<tr>
						<th>Tax:</th>
						<td>${invoiceDTO.tax}</td>
					</tr>
					<tr>
						<th>Total amount:</th>
						<td>${invoiceDTO.total_amount}</td>
					</tr>
				</table>
			</div>
			<div class="col-md-6 col-sm-6">
				<table class="table">
					<tr>
						<th>Delivery phone:</th>
						<td>${invoiceDTO.delivery_phone}</td>
					</tr>
					<tr>
						<th>Delivery address:</th>
						<td>${invoiceDTO.delivery_address}</td>
					</tr>
					<tr>
						<th>Created at:</th>
						<td>${invoiceDTO.created_at}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>