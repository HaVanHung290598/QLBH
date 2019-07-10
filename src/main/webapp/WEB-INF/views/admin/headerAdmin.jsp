<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="container-fluid">
	<div class="row">
		<div class="col-md-2 col-sm-12 logo">
			<a class="show-menu" href="javascript:void(0)"><i class="fas fa-bars"></i></a>
			<a href="#"><b><i class="fab fa-neos"></i></b>NICE ADMIN</a>
			<a class="show-search" href="javascript:void(0)"><i class="fas fa-search"></i></a>
		</div>
		<div class="col-md-10 col-sm-12 header-right">
			<div class="row">
				<div class="col-md-11 col-sm-10 search">
					<ul>
						<li>
							<a href="#"><i class="fas fa-search"></i> Search</a>							
						</li>
					</ul>
				</div>
				<div class="col-md-1 col-sm-2 admin">
					<a href="#">Admin</a>
				</div>
			</div>
		</div>
	</div>
	<div class="row app-search">
		<div class="col-md-11 col-sm-11 header-search">
			<c:url value="/admin/search" var="url"/>
			<form action="${url}" method="get">
				<input type="text" name="productName" placeholder="Search & enter">
			</form>
		</div>
		<div class="col-md-1 col-sm-1 close-search">
			<button><i class="fas fa-times"></i></button>
		</div>
	</div>
</header>