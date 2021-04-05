
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Welcome <%= request.getSession().getAttribute("userNom") %>
					<%= request.getSession().getAttribute("userPrenom") %>
				</a>
			</div>

			<ul class="navbar-nav">
				<li>
				<li><a href="logout" class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<h3>
		<a href="newReservation" class="btn btn-success">New Reservation</a>

	</h3>
	
	<p><c:out value="${msg}"></c:out></p>
<table class="table table-bordered" border="1" border="1">
			<thead>
				<tr class="bg-primary">
		<th>DateReservation</th>
		<th>TypeReservation</th>
		<th>Confirmation</th>
</thead>
<tbody>
		<c:forEach var="reservation" items="${list}">
			<tr>
				<td>${reservation.dateReservation}</td> 
			    <td>${reservation.typeReservation}</td> 
					<td>
						<c:if test="${reservation.confirmation == true}" var="variable">
   							 <p>confirmer</p>
						</c:if>
						<c:if test="${reservation.confirmation == false}" var="variable">
   							 <p>rejeter</p>
						</c:if>
						</td>  
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>