
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

	<%-- <%@ include file ="users.jsp"%> --%>

	<div align="center">
		<h1>Reservation list</h1>

		<table class="table table-bordered" border="1" border="1">
			<thead>
				<tr class="bg-primary">
					<th>idUser</th>
					<th>UserNom</th>
					<th>UserPrenom</th>
					<th>idReservation</th>
					<th>Date</th>
					<th>typeReservation</th>
					<th>confirmation</th>

					<th>Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="reservation" items="${listReservation}">
					<tr>
						<td>${reservation.apprenant.userId}</td>
						<td>${reservation.apprenant.userNom}</td>
						<td>${reservation.apprenant.userPrenom}</td>
						<td>${reservation.idReservation}</td>
						<td>${reservation.dateReservation}</td>
						<td>${reservation.typeReservation}</td>
						<td>
						<c:if test="${reservation.confirmation == true}" var="variable">
   							 <p>confirmer</p>
						</c:if>
						<c:if test="${reservation.confirmation == false}" var="variable">
   							 <p>non confirmer</p>
						</c:if>
						</td>



						<td class="d-flex flex-row">
						
							<c:if test="${reservation.confirmation == false}">
								<form action="ApprouveReservation" method="post">
									<input type="hidden" value="${reservation.idReservation}"
										name="id" class="form-control" /> <input type="submit"
										value="Accepter" class="btn btn-primary  btn-sm">
								</form>
							</c:if></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<a href="logout" type="button" class="btn btn-outline-dark btn-sm">logout</a>
</body>
</html>
