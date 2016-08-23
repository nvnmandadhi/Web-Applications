<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bean" class="beans.UserDetails" scope="page"></jsp:useBean>

	<jsp:setProperty name="bean" property="*" />

	<%
		/**
		String username = "";
		String password = "";
		**/
	
		String username = bean.getUsername();
		String password = bean.getPassword();
	%>
	<%
		try {
			if (username.equals("nvnmandadhi@gmail.com") && password.equals("Naveen")) {

				response.sendRedirect("hello.jsp");
			} else {

				response.sendRedirect("Login.jsp");
			}

		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	%>

</body>
</html>