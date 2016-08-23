<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Welcome to Home Page</title>
</head>
<body>
<%@ page session="false" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="left">
<ul>
	<li><a href="register.jsp">Register</a></li>
	<li><a href="login.jsp">Login</a></li>
</ul>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>