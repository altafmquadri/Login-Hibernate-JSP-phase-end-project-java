<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div style="text-align: center">
	<nav style="margin-left:30%"><a href="login.jsp">Login</a></nav>
	<h1>Registration</h1>

	<form action="registration" method="post">
		Name: <input style="margin-left: 28px; margin-bottom:10px" type="text" name="name" required="required"> <br>
		Password: <input style="margin-left: 5px; margin-bottom:10px" type="password" name="password" required="required">
		<br> <input type="submit" value="Register">
	</form>
	</div>

</body>
</html>