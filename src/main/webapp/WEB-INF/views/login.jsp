<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/fontawesome-free-5.8.1-web/css/all.css"/>"/>
</head>
<body>
	<div class="over"></div>
	<div class="container-fluid login">
		<div class="container">
			<div class="row logo">
				<div class="col-md-9">
					<h1><a href="home">H2S</a></h1>
					<p>Enter your username and password to log on.</p>
				</div>
				<div class="col-md-3">
					<i class="fab fa-keycdn"></i>
				</div>
			</div>
			<div class="row form">
				<div class="col-md-12">
					<form action="log" method="post">
						<input class="form-control" name="username" placeholder="Username" type="text" required />
						<input class="form-control" name="password" placeholder="Password" type="password" required />
						<input class="form-control" type="submit" value="Sign in"/>
					</form>
					<a class="signUp" href="signUp">Sign up</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>