<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row setting">
	<div class="col-md-12 col-sm-12">
		<div class="row form-search-setting">
			<div class="col-md-12 col-sm-12">
				<c:url value="/admin/searchSetting" var="url4"/>
				<form action="${url4}" method="get">
					<div class="row">
						<div class="col-md-2"><b>Setting name: </b></div>
						<div class="col-md-4 col-md-offset-4 col-sm-12">
							<input type="text" name="setting_name" value="${params.get('setting_name')}" class="form-control" placeholder="Setting name"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2"><b>Created at: from </b></div>
						<div class="col-md-4"><input type="date" name="created_at_from" value="${params.get('created_at_from')}" class="form-control"/></div>
						<div class="col-md-1"><b>to </b></div>
						<div class="col-md-4"><input type="date" name="created_at_to" value="${params.get('created_at_to')}" class="form-control"/></div>
					</div>
					<div class="row">
						<div class="col-md-2"><b>Updated at: from </b></div>
						<div class="col-md-4"><input type="date" name="updated_at_from" value="${params.get('updated_at_from')}" class="form-control"/></div>
						<div class="col-md-1"><b>to </b></div>
						<div class="col-md-4"><input type="date" name="updated_at_to" value="${params.get('updated_at_to')}" class="form-control"/></div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<input type="submit" value="Submit" class="form-control"/>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row create-setting">
			<div class="col-md-2 col-sm-2">
				<a href="javascript:void(0)" class="update">Create Setting</a>
			</div>
		</div>
		<div class="row form-update-setting">
			<div class="col-md-12">
				<c:url value="/admin/createSetting" var="url1"/>
				<form action="${url1}" method="post">
					<table class="table">
						<tr>
							<th>Name</th>
							<td><input type="text" name="settingName" class="form-control"></td>
						</tr>
						<tr>
							<th>Value</th>
							<td><textarea name="value" rows="3" cols="" class="form-control"></textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Submit" class="form-control"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 information">
				<table class="table">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Value</th>
						<th>Created at</th>
						<th>Updated at</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${settingDTOs}" var="s">
						<tr>
							<td>${s.id}</td>
							<td>${s.setting_name}</td>
							<td>${s.value}</td>
							<td>${s.created_at}</td>
							<td>${s.updated_at}</td>
							<td>
								<c:url value="/admin/deleteSetting?id=${s.id}" var="url2"/>
								<c:url value="/admin/repairSetting?id=${s.id}" var="url3"/>
								<a href="${url3}" title="repair"><i class="fas fa-pencil-alt"></i></a>
								<a class="delete" href="${url2}" title="delete"><i class="far fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-12" style="margin-top: 20px;"> -->
<!-- 				<nav aria-label="Page navigation example"> -->
<!-- 				  <ul class="pagination"> -->
<%-- 				  	<c:url value="/admin/setting?page=${page-1}" var="url6"/> --%>
<%-- 				  	<c:url value="/admin/setting?page=${page+1}" var="url7"/> --%>
<%-- 				    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url6}">Previous</a></li> --%>
<%-- 				    <li class="page-item ${page == Math.ceil(size/8) ? 'disabled' : ''}"><a class="page-link" href="${url7}">Next</a></li> --%>
<!-- 				  </ul> -->
<!-- 				</nav> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="row">
			<c:choose>
				<c:when test="${not empty params}">
					<div class="col-md-12" style="margin-top: 20px;">
						<nav aria-label="Page navigation example">
						  <ul class="pagination">
						  	<c:url value="/admin/searchSetting?page=${page-1}&&setting_name=${params.get('setting_name')}&&created_at_from=${params.get('created_at_from')}&&created_at_to=${params.get('created_at_to')}&&updated_at_from=${params.get('updated_at_from')}&&updated_at_to=${params.get('updated_at_to')}" var="url6"/>
						  	<c:url value="/admin/searchSetting?page=${page+1}&&setting_name=${params.get('setting_name')}&&created_at_from=${params.get('created_at_from')}&&created_at_to=${params.get('created_at_to')}&&updated_at_from=${params.get('updated_at_from')}&&updated_at_to=${params.get('updated_at_to')}" var="url7"/>
						    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url6}">Previous</a></li>
						    <li class="page-item ${page == Math.ceil(size/8) ? 'disabled' : ''}"><a class="page-link" href="${url7}">Next</a></li>
						  </ul>
						</nav>
					</div>
				</c:when>
				<c:when test="${empty params}">
					<div class="col-md-12" style="margin-top: 20px;">
						<nav aria-label="Page navigation example">
						  <ul class="pagination">
						  	<c:url value="/admin/setting?page=${page-1}" var="url8"/>
						  	<c:url value="/admin/setting?page=${page+1}" var="url9"/>
						    <li class="page-item ${page-1 < 1 ? 'disabled' : ''}"><a class="page-link" href="${url8}">Previous</a></li>
						    <li class="page-item ${page == Math.ceil(size/8) ? 'disabled' : ''}"><a class="page-link" href="${url9}">Next</a></li>
						  </ul>
						</nav>
					</div>
				</c:when>
			</c:choose>				
		</div>
	</div>
</div>