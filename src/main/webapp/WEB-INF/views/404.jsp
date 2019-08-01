<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/404.css"/>"/>
</head>
<body>
	<div class="error">
		<h1>${error}</h1>
		<h2>Aww Snap!</h2>
		<p>Something went wrong or that page doesn't exist yet</p>
		<c:url value="/home" var="url"/>
		<a href="${url}">Return Home</a>
	</div>
</body>
</html>