
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidenav {
	height: 100%;
	width: 160px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	padding-top: 20px;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.main {
	margin-left: 160px; /* Same as the width of the sidenav */
	font-size: 28px; /* Increased text to enable scrolling */
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
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
		<a href="newReservation">New Reservation</a>

	</h3>
	<table border="1">

		
		<th>DateReservation</th>
		<th>TypeReservation</th>
		<th>Confirmation</th>

		<c:forEach var="reservation" items="${list}">
			<tr>
				<td>${reservation.dateReservation}</td> 
			    <td>${reservation.typeReservation}</td> 
				<td>${reservation.confirmation}</td>  
			</tr>
		</c:forEach>
	</table>
</body>
</html>