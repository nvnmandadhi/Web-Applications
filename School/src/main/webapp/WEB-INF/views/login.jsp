<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/styles.css"></c:url>'>
<title>Welcome</title>
</head>
<body
	background='<c:url value="/resources/images/reptiles.jpg"></c:url>'
	class="bgimage">
	<header class="bgimage">
		<div class="container">
			<h1>School Management System</h1>
		</div>
	</header>
	<div class="container">
		<form action='<c:url value="/login"></c:url>' method="post">
			<table class="table">
				<thead>
					<tr>
						<th><h1>Login Here</h1></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>UserName:</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"></td>
					</tr>
					<security:csrfInput />
					<tr>
						<td colspan="3"><input type="submit" name="submit"
							value="submit"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src='<c:url value="/resources/js/script.js"></c:url>'></script>
</body>
</html>