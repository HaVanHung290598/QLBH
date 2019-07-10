<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/fontawesome-free-5.8.1-web/css/all.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/admin/headerAdmin.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/admin/menuAdmin.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/admin/collectionAdmin.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.js"/>"></script>
</head>
<body>
	<tiles:insertAttribute name="headerAdmin"></tiles:insertAttribute>
	<div class="container-fluid main-content">
		<div class="row">
			<div class="col-md-2 menu">
				<tiles:insertAttribute name="menuAdmin"></tiles:insertAttribute>
			</div>
			<div class="col-md-10 col-sm-12 content">
				<tiles:insertAttribute name="contentAdmin"></tiles:insertAttribute>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value="/resources/js/admin/headerAdmin.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/admin/menuAdmin.js"/>"></script>
</body>
</html>