<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/signUp.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/fontawesome-free-5.8.1-web/css/all.css"/>"/>
</head>
<body>
	<div class="over"></div>
	<div class="container-fluid signUp">
		<div class="container">
			<div class="row logo">
				<div class="col-md-12">
					<h1><a href="home">H2S</a></h1>
					<p>Enter your information to sign up.</p>
				</div>
			</div>
			<div class="row form">
				<div class="col-md-12">
					<form action="singUp" method="post">
						<input class="form-control" name="fullname" placeholder="FullName" type="text" required />
						<input class="form-control" name="address" placeholder="Address" type="text" required />
						<input class="form-control" name="phonenumber" placeholder="PhoneNumber" type="text" required />
						<input class="form-control" name="username" placeholder="Username" type="text" required />
						<input class="form-control" name="password" placeholder="Password" type="password" required />
						<input class="form-control" name="email" placeholder="Email" type="text" required />
						<input class="form-control" type="submit" value="Sign Up"/>
					</form>
					<a class="signIn" href="login">Sign in</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>