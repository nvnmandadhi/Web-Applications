<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Insert title here</title>
</head>
<body>
<%@ page session="false" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="left">
<form action="/JavaSystem/UserController" method="post">
<h3>Please enter login details to delete account</h3>
<table class="form">
	<tr>
		<td>Email :</td>
		<td><input type="email" name="email"></input></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><input type="password" name="password"></input></td>
	</tr>
	<tr>
		<td><input id="submit" type="submit" value="Delete Account"></input></td>
	</tr>
</table>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>