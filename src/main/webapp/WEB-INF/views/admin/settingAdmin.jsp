<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Keywords</th>
						<th>Author</th>
						<th>Discount amount</th>
						<th>Tax</th>
						<th>Action</th>
					</tr>
					<tr>
						<td>${setting.title}</td>
						<td>${setting.description}</td>
						<td>${setting.keywords}</td>
						<td>${setting.author}</td>
						<td>${setting.discount_amount}%</td>
						<td>$${setting.tax}</td>
						<td>update</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>