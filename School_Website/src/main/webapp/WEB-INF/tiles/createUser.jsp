<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>

<div class="container">
	<div class="col-md-4 col-md-offset-4">

		<div class="panel panel-primary">

			<div class="panel-heading">
				<h2 class="form-signup-heading">Please Register</h2>
			</div>

			<div class="panel-body">
				<div class="form-wrapper">
					<spring:form action="${contextRoot}/register"
						accept-charset="UTF-8" method="post">

						<div class="form-group">
							<label class="sr-only" for="user_name">User Name</label> <input
								autofocus="autofocus" class="form-control input-hg"
								placeholder="User Name" type="text" name="username"
								id="user_name" />
						</div>

						<div class="form-group">
							<label class="sr-only" for="full_name">First Name</label> <input
								autofocus="autofocus" class="form-control input-hg"
								placeholder="First Name" type="text" name="fname" id="full_name" />
						</div>

						<div class="form-group">
							<label class="sr-only" for="full_name">Last Name</label> <input
								autofocus="autofocus" class="form-control input-hg"
								placeholder="Last Name" type="text" name="lname" id="full_name" />
						</div>

						<div class="form-group">
							<label class="sr-only" for="user_email">Email Address</label> <input
								class="form-control input-hg" placeholder="Email Address"
								type="email" name="email" id="user_email" />
						</div>
						<div class="form-group">
							<label class="sr-only" for="user_password">Password</label> <input
								autocomplete="off" class="form-control input-hg"
								placeholder="Password" type="password" name="password"
								id="user_password" />
						</div>

						<input type="submit" name="commit" value="Sign up"
							class="btn btn-primary btn-hg btn-block signup-button" />
					</spring:form>
					<br>
					<p class="text-center">
						Already signed up? <a class=" login-button"
							href="${contextRoot}/login">Log in</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
