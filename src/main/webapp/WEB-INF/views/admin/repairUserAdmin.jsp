<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<c:url value="/admin/${url}" var="url1"/>
		<form action="${url1}" method="post">
			<table class="table">
				<tr>
					<th>Username:</th>
					<td><input class="form-control" type="text" name="username" value="${userDTO.username}" placeholder="Username" ${disabled}/></td>
				</tr>
				<tr style="display:${display2}">
					<th>Password:</th>
					<td><input class="form-control" type="password" name="password" value="${userDTO.password}" placeholder="Password"/></td>
				</tr>
				<tr style="display:${display2}">
					<th>Retype password:</th>
					<td><input class="form-control" type="password" name="retypePassword" placeholder="Retype Password"/></td>
				</tr>
				<tr>
					<th>Fullname:</th>
					<td><input class="form-control" type="text" name="fullname" value="${userDTO.fullname}" placeholder="Fullname"/></td>
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
				<tr style="display:${display}">
					<th>Created at:</th>
					<td><input class="form-control" type="date" name="created_at" value="${userDTO.created_at}" ${disabled}/></td>
				</tr>
				<tr>
					<th>Role:</th>
					<td>
						<select class="form-control" name="role">
							<option value="ROLE_ADMIN" ${userDTO.role == 'ROLE_ADMIN' ? 'selected' : ''}>Admin</option>
							<option value="ROLE_USER" ${userDTO.role == 'ROLE_USER' ? 'selected' : ''}>User</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Enabled:</th>
					<td>
						<input type="radio" name="enabled" value="1" ${userDTO.enabled == 1 or userDTO.enabled == null ? 'checked' : ''}/> None Lock<br/>
						<input type="radio" name="enabled" value="0" ${userDTO.enabled == 0 ? 'checked' : ''}/> Lock
 					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="userId" value="${userDTO.id}"/>
						<input class="form-control" type="submit" value="Submit"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>