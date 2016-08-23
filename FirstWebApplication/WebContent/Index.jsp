<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		for (int i = 0; i < 5; i++) {
	%>
	<p>
		This is in the for loop:
		<%=i%></p>
	<%
		}
	%>

	<%
		String name = request.getParameter("name");
	%>
	<%
		if (name == null) {
	%>

	<!-- For content that changes a lot!!!! -->

	<jsp:include page="hello.html" />

	<%
		} else {
	%>
	<p />
	<!-- For content that is fixed!!!! -->
	<jsp:include page="hello.jsp" />

	<%
		}
	%>
	<%@ page import="gui.*"%>
	<%
		TestJSP obj = new TestJSP();
	%>
	<p />
	<%
		out.println(obj.display());
	%>
	<p />
	<a href="/FirstWebApplication/Controller?action=login">Go to login
		page</a>
	<p />
	<a href="/FirstWebApplication/Controller?action=about">Go to about
		page</a>
</body>
</html>