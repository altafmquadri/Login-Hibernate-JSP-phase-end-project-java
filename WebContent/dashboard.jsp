<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome <%
	session.getAttribute("name");
%></title>
</head>
<body>
	<div>
		<%
			if (session.getAttribute("name") != null) {
			out.print("<a href='logout'>Logout</a>");
			out.println("<h1>Welcome " + session.getAttribute("name") + "</h1>");	
			}
			else if (session.getAttribute("name") == null) {
				out.println("<p style='color:red;text-align:center;'>You need to be logged in to view this page<p>");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		%>
	</div>
</body>
</html>