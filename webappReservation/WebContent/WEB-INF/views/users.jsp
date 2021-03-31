<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<body>
	<h2>
		Welcome
		<%= request.getSession().getAttribute("userNom") %></h2>
	<div align="center">
		<h1>Users list</h1>

		<table class="table table-bordered" border="1" border="1">
			<thead>
				<tr class="bg-primary">
					<th>idUser</th>
					<th>UserNom</th>
					<th>UserPrenom</th>
					<th>UserEmail</th>
				

				</tr>
			</thead>
			<tbody>
				<c:forEach var="users" items="${listUsers}">
					<tr>
						<td>${users.userId}</td>
						<td>${users.userNom}</td>
						<td>${users.userPrenom}</td>
						<td>${users.userEmail}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<a href="logout" type="button" class="btn btn-outline-dark btn-sm"">logout</a>
</body>
</html>
