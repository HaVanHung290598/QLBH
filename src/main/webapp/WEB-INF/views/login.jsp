<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="log" method="post">
						Username: <input class="form-control" name="username" type="text" required /><br/>
						Password: <input class="form-control" name="password" type="password" required /><br/>
						<input id="submitSignIn" type="submit" value="Submit" class="btn btn-primary"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>