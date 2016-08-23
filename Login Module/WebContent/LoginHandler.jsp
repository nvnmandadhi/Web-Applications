<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="handler" class="beans.UserDetails" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="handler" />
 
	<%
		String username = handler.getUsername();
		String password = handler.getPassword();

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