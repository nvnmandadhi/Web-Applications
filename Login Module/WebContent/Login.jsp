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

<%

String action = request.getParameter("action");

if(action != null && action.equals("loginsubmit")){
	if(handler.validate()){
		request.getRequestDispatcher("hello.jsp").forward(request, response);
	}
	
}

%>
	<div align="center">
		<form action="/Login_Module/LoginHandler.jsp" method="post">

			<h4><jsp:getProperty property="message" name="handler"/></h4>
			<br>
			UserName: <input type="text" name="username"> <br>
			Password: <input type="password" name="password"> <br> 
			<input type="submit" value="Submit">
			<input type="hidden" name="loginsubmit" >

		</form>
	</div>
</body>
</html>