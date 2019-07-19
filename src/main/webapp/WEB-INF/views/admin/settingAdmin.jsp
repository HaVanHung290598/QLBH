<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row setting">
	<div class="col-md-12 col-sm-12">
		<div class="row ">
			<div class="col-md-12 col-sm-12 information">
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
						<td><a href="javascript:void(0)" class="update">update</a></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row form-update-setting">
			<div class="col-md-12">
				<c:url value="/admin/setting" var="url1"/>
				<form action="${url1}" method="post">
					<table class="table">
						<tr>
							<th>Title</th>
							<td><input type="text" name="title" value="${setting.title}" class="form-control"></td>
						</tr>
						<tr>
							<th>Description</th>
							<td><textarea name="description" rows="" cols="" class="form-control">${setting.description}</textarea></td>
						</tr>
						<tr>
							<th>Keywords</th>
							<td><input type="text" name="keywords" value="${setting.keywords}" class="form-control"></td>
						</tr>
						<tr>
							<th>Author</th>
							<td><input type="text" name="author" value="${setting.author}" class="form-control"></td>
						</tr>
						<tr>
							<th>Discount amount</th>
							<td><input type="text" name="discount_amount" value="${setting.discount_amount}" class="form-control"></td>
						</tr>
						<tr>
							<th>Tax</th>
							<td><input type="text" name="tax" value="${setting.tax}" class="form-control"></td>
						</tr>
						<tr>
							<th></th>
							<td colspan="1">
								<input type="hidden" name="settingId" value="${setting.id}">
								<input type="submit" value="Submit" class="form-control">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>