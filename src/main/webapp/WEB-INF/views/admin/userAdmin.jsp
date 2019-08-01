<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12 col-sm-12 list-user">
		<c:url value="/admin/searchUser" var="url"/>
		<form action="${url}" method="get" class="form-search-user">
			<div class="row form-search">
				<div class="col-md-2 col-sm-2">
					<input type="text" name="username" value="${params.get('username')}" placeholder="Username" class="form-control"/>
				</div>
				<div class="col-md-3 col-sm-3">
					<input type="email" name="email" value="${params.get('email')}" placeholder="Email" class="form-control"/>
				</div>
				<div class="col-md-2 col-sm-2">
					<input type="text" name="phone" value="${params.get('phone')}" placeholder="Phone" class="form-control"/>
				</div>
				<div class="col-md-3 col-sm-3">
					<input type="date" name="created_at" value="${params.get('created_at')}" placeholder="Created at" class="form-control"/>
				</div>
				<div class="col-md-2 col-sm-2">
					<input type="submit" value="Submit" class="form-control"/>
				</div>
			</div>
		</form>
		<div class="row create-user">
			<div class="col-md-2 col-sm-2">
				<c:url value="/admin/createUser" var="url1"/>
				<a href="${url1}">Create User</a>
			</div>
		</div>
		<div class="row infor">
			<div class="col-md-12 col-sm-12">
				<table class="table">
					<tr>
						<th>Username</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Created at</th>
						<th>Updated at</th>
						<th>Role</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${userDTOs}" var="s">
						<tr>
							<td>${s.username}</td>
							<td>${s.address}</td>
							<td>${s.phone}</td>
							<td>${s.email}</td>
							<td>${s.created_at}</td>
							<td>${s.updated_at}</td>
							<td>${s.role == "ROLE_USER" ? "USER" : "ADMIN"}</td>
							<td>
								<c:url value="/admin/repairUser?id=${s.id}" var="url3"/>
								<c:url value="/admin/deleteUser?id=${s.id}" var="url4"/>
								<a href="${url3}" title="repair"><i class="fas fa-pencil-alt"></i></a>
								<a class="delete" href="${url4}" title="delete"><i class="far fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row pages">
			<div class="col-md-12 col-sm-12" style="margin-top: 20px;">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	<c:url value="/admin/user?page=${page-1}" var="url1"/>
				  	<c:url value="/admin/user?page=${page+1}" var="url2"/>
				    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url1}">Previous</a></li>
				    <li class="page-item ${page == Math.ceil(size/10) ? 'disabled' : ''}"><a class="page-link" href="${url2}">Next</a></li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
</div>