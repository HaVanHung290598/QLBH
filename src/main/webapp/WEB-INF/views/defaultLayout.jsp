<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="com.hvh.service.SettingService"%>
<%@page import="com.hvh.service.impl.SettingServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${head}</title>
<meta name="description" content="${description.value}">
<meta name="author" content="${author.value}">
<meta name="keywords" content="${keywords.value}">
<link rel="stylesheet" href="<c:url value="/resources/fontawesome-free-5.8.1-web/css/all.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/header-collection.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/products.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/productSingle.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/cart.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/subscribe.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.js"/>"></script>
</head>
<body>
	<tiles:insertAttribute name="header-collection"/>
	<tiles:insertAttribute name="content"/>
	<tiles:insertAttribute name="products"/>
	<tiles:insertAttribute name="subscribe"/>
	<tiles:insertAttribute name="footer"/>
<script type="text/javascript" src="<c:url value="/resources/js/scroll.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/cart.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/menu.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/numberProduct.js"/>"></script>
</body>
</html>