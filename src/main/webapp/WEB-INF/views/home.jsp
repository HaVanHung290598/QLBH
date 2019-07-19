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
<% 
	SettingService settingService = new SettingServiceImpl();
//  	String title = settingService.getSettingById(1).getTitle();
%>
<title></title>
<link rel="stylesheet" href="<c:url value="/resources/fontawesome-free-5.8.1-web/css/all.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/overlay.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/trending-product.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/products.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/bkground.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/management.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/statistical.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/subscribe.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.js"/>"></script>
</head>
<body style="position: relative;">
	<tiles:insertAttribute name="overlay"/>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="trending-product"/>
	<tiles:insertAttribute name="products"/>
	<tiles:insertAttribute name="bkground"/>
	<tiles:insertAttribute name="management"/>
	<tiles:insertAttribute name="statistical"/>
	<tiles:insertAttribute name="subscribe"/>
	<tiles:insertAttribute name="footer"/>
	<script type="text/javascript" src="<c:url value="/resources/js/slider.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/scroll.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/check.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>