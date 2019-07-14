<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
	<c:url value="/admin/product" var="url1"/>
	<c:url value="/admin/addProduct" var="url2"/>
	<li><a href="${url1}"><i class="fab fa-accusoft"></i> &nbsp; <span>Product</span></a></li>
	<li><a href="${url2}"><i class="fas fa-users"></i> &nbsp; <span>Create Product</span></a></li>
	<li><a href="#"><i class="fab fa-wpforms"></i> &nbsp; <span>Form Basic</span></a></li>
	<li><a href="#"><i class="fas fa-table"></i> &nbsp; <span>Table</span></a></li>
	<li><a href="#"><i class="fab fa-contao"></i> &nbsp; <span>Icon</span></a></li>
	<li><a href="#"><i class="fab fa-black-tie"></i> &nbsp; <span>Blank</span></a></li>
	<li><a href="#"><i class="fas fa-bug"></i> &nbsp; <span>404</span></a></li>
</ul>