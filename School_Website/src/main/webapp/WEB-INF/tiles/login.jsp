<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="container">

	<div class="col-md-4 col-md-offset-4">

		<div class="panel panel-primary">

			<div class="panel-heading">
				<h2 class="form-signin-heading">Please sign in</h2>
			</div>

			<div class="panel-body">

				<form class="form-signin" action="/login" method="post">
					<label for="inputEmail" class="sr-only">User Name</label> <input
						type="text" id="inputUserName" class="form-control"
						placeholder="User Name" required autofocus name="username"> <label
						for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="inputPassword" class="form-control"
						placeholder="Password" required name="password">
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember me
						</label>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</form>

			</div>

		</div>

	</div>

</div>