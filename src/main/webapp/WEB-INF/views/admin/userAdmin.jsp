<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12 list-user">
		<div class="row form-search">
			<div class="col-md-12">
				<c:url value="/admin/searchUser" var="url"/>
				<form action="${url}" method="get">
					<input class="form-control" type="search" placeholder="Username" name="userName">
				</form>
			</div>
		</div>
		<div class="row infor">
			<div class="col-md-12">
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
								<a href="${url3}"><i class="fas fa-recycle"></i></a>
								<a href="${url4}"><i class="far fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row pages">
			<div class="col-md-12" style="margin-top: 20px;">
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