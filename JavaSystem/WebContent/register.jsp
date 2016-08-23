<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Registration Form</title>
</head>
<body>
<%@ page session="false" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="dataform">
<h3 class="formheading">Registration Form</h3>
<form action="/JavaSystem/RegistrationController" method="post">
<table class="form">
	<tr>
		<td>First Name :</td>
		<td><input type="text" name="fname"></input></td>
	</tr>
	<tr>
		<td>Last Name :</td>
		<td><input type="text" name="lname"></input></td>
	</tr>
	<tr>
		<td>Email :</td>
		<td><input type="email" name="email" ></input></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><input type="password" name="password" ></input></td>
	</tr>
	<tr>
		<td>Address :</td>
		<td>
			<textarea name="address">Enter address here....</textarea>
		</td>
	</tr>
	<tr>
		<td><input id="submit" type="submit" value="Submit Query"></input></td>
		<td><input id="reset" type="reset" value="Reset"></input></td>
	</tr>
</table>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>