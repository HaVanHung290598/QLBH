<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-12">
		<c:url value="/admin/repairSetting" var="url1"/>
		<h2>Repair Setting</h2>
		<form action="${url1}" method="post">
			<table class="table">
				<tr>
					<th>ID</th>
					<td>
						<input type="hidden" value="${settingDTO.id}" name="id"/>
						<input type="text" value="${settingDTO.id}" class="form-control" disabled/>
					</td>
				</tr>
				<tr>
					<th>Name</th>
					<td><input type="text" value="${settingDTO.setting_name}" name="settingName" class="form-control"/></td>
				</tr>
				<tr>
					<th>Value</th>
					<td><textarea name="value" rows="" cols="" class="form-control">${settingDTO.value}</textarea></td>
				</tr>
				<tr>
					<th>Created at</th>
					<td><input type="datetime" name="created_at" class="form-control" value="${settingDTO.created_at}" disabled/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" class="form-control"/></td>
				</tr>
			</table>
		</form>
	</div>
</div>