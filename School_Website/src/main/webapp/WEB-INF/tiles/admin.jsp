<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<c:forEach items="${students}" var="var">
					<tr>
						<td>${var.getId()}</td>
						<td>${var.getFname()}</td>
						<td>${var.getLname()}</td>
						<td>${var.getEmail()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

