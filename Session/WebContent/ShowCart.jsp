<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="sessionDemo.*" %>

<% Cart cart = (Cart)session.getAttribute("cart"); %>

Items in the cart : <%= cart == null ? "error" : cart.getNumberOfItems() %>

<p>

<a href="<%= response.encodeURL(request.getContextPath() + "/ShowCart2.jsp")%>">Click here to see cart without cookies.</a>

</body>
</html>