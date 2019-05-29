<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="over"></div>
	<div class="sign-in">
		<h2>SIGN IN</h2>
		<form action="" method="post">
			Username: <input class="form-control" type="text" required /><br/>
			Password: <input class="form-control" type="password" required /><br/>
			<input id="submitSignIn" type="submit" value="Submit" class="btn btn-primary"/>
		</form>
	</div>
	<div class="sign-up">
		<h2>SIGN UP</h2>
		<form action="" method="post">
			Username: <input class="form-control" type="text" required /><br/>
			Password: <input class="form-control" type="password" required /><br/>
			Address: <input class="form-control" type="text" required /><br/>
			Phone: <input class="form-control" type="text" required /><br/>
			Email: <input class="form-control" type="text" required /><br/>
			<input id="submitSignOut" type="submit" value="Submit" class="btn btn-primary"/>
		</form>
		<a href="javascript:void(0)">SIGN IN</a>
	</div>