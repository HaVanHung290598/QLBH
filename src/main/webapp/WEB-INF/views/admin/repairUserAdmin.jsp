<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
<%-- 		<form action="" method="post"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th>Username:</th> -->
<%-- 					<td><input class="form-control" type="text" name="username" value="${userDTO.username}" placeholder="Username"/></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>Address:</th> -->
<%-- 					<td><input class="form-control" type="text" name="address" value="${userDTO.address}" placeholder="Address"/></td> --%>
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>Phone:</th> -->
<!-- 					<td><input class="form-control" type="text" name="phone" value="" placeholder="Phone number"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>Email:</th> -->
<!-- 					<td><input class="form-control" type="email" name="email" placeholder="Email"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>Role:</th> -->
<!-- 					<td><input class="form-control" type="text" name="role" placeholder="Role"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<th>Enabled:</th> -->
<!-- 					<td><input class="form-control" type="number" name="enabled" placeholder="Enabled" min="0" max="1"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td colspan="2"><input class="form-control" type="submit" value="Submit"/></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 		</form> --%>
		<c:url value="/admin/repairUser" var="url1"/>
		<form:form action="${url1}" method="post" modelAttribute="userDTO">
			<form:input type="hidden" path="id"/>
			<form:input type="hidden" path="fullname"/>
			<form:input type="hidden" path="password"/>
			<form:input type="hidden" path="created_at"/>
			<form:input type="hidden" path="updated_at"/>
			<form:input type="hidden" path="carts"/>
			<form:input type="hidden" path="invoices"/>
			<table>
				<tr>
					<th>Username:</th>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><form:input path="address"/></td>
				</tr>
				<tr>
					<th>Phone:</th>
					<td><form:input path="phone"/></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<th>Role:</th>
					<td><form:input path="role"/></td>
				</tr>
				<tr>
					<th>Enabled:</th>
					<td><form:input path="enabled"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</div>