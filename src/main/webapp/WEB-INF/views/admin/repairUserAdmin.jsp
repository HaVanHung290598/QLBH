<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<c:url value="/admin/repairUser" var="url1"/>
		<form action="${url1}" method="post">
			<table class="table">
				<tr>
					<th>Fullname:</th>
					<td><input class="form-control" type="text" name="fullname" value="${userDTO.fullname}" placeholder="Username"/></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input class="form-control" type="text" name="address" value="${userDTO.address}" placeholder="Address"/></td>
				</tr>
				<tr>
					<th>Phone:</th>
					<td><input class="form-control" type="text" name="phone" value="${userDTO.phone}" placeholder="Phone number"/></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><input class="form-control" type="email" name="email" value="${userDTO.email}" placeholder="Email"/></td>
				</tr>
				<tr>
					<th>Role:</th>
					<td><input class="form-control" type="text" name="role" value="${userDTO.role }" placeholder="Role"/></td>
				</tr>
				<tr>
					<th>Enabled:</th>
					<td><input class="form-control" type="number" name="enabled" value="${userDTO.enabled }" placeholder="Enabled" min="0" max="1"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="username" value="${userDTO.username}"/>
						<input type="hidden" name="password" value="${userDTO.password}"/>
						<input type="hidden" name="created_at" value="${userDTO.created_at}"/>
						<input type="hidden" name="userId" value="${userDTO.id}"/>
						<input class="form-control" type="submit" value="Submit"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>