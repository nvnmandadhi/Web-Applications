<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title><tiles:insertAttribute name="title" /></title>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- Bootstrap -->
<link href='${contextRoot}/resources/css/bootstrap.min.css'
	rel="stylesheet">
<link href='${contextRoot}/resources/css/styles.css' rel="stylesheet">
</head>
<body>
	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextRoot}/">School
					Application</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href='<c:url value="/"></c:url>'>Home</a></li>
					<li><a href="${contextRoot}/about">About</a></li>
					<li><a href="${contextRoot}/contact">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href='<c:url value="/users"></c:url>'>Users</a></li>
					</sec:authorize>
					<sec:authorize access="! isAuthenticated()">
						<li><a href="${contextRoot}/login">Login</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href='<c:url value="/logout"></c:url>'>Logout</a></li>
					</sec:authorize>
					<li><a href="${contextRoot}/register">Register</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<tiles:insertAttribute name="content" />
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy;Copyrights Reserved</p>
		</div>
	</footer>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src='${contextRoot}/resources/js/bootstrap.min.js'></script>
</body>
</html>