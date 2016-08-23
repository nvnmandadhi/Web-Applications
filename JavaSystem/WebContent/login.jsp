<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<%@ page session="false"%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="dataform">
		<h3 class="formheading">Login Form</h3>
		<form
			action="/JavaSystem/LoginController"
			method="post">
			<span></span>
			<table class="form">
				<tr>
					<td>Email :</td>
					<td><input
						id="email"
						type="email"
						name="email"></input></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input
						id="password"
						type="password"
						name="password"></input></td>
				</tr>
				<tr>
					<td><input
						id="submit"
						type="submit"
						value="Login"></input></td>
					<td><input
						id="reset"
						type="reset"
						value="Reset"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			
			$("#submit").click(function(){

			//var message = $("<p>Fields can't be empty!</p>").css("color","red");
			
			//getting form input values
			var e = $("#email").val();
			var p = $("#password").val();

			if (e == ""||password == ""){

				$("span").text("Please enter all the fields!").css("color","red").show().fadeOut(4000);
				
				event.preventDefault();
				
			}
			
			});
		});
	</script>
</body>
</html>