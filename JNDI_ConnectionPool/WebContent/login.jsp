<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table {border: medium; background-color: gray;}

</style>
<title>This is Login Page</title>
</head>
<body>
<form action="/JNDI_ConnectionPool/Controller" method="post">
<table align="center">
<tr><td>Email :</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="password" name="password">
</tr>
<tr><td ><input type="submit" value="Login"></td></tr>
</table>
<input type="hidden" name="action" value="dologin" >
</form>
</body>
</html>