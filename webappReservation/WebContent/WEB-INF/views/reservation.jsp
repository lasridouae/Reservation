<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>

<body>
        <h1>hello if you are here you are user</h1>

<div align="center">
    <h1>Reservation list</h1>
    <h3>
        <a href="newReservation">New Reservation</a>
    </h3>
    <table border="1">

        <th>idReservation</th>
        <th>Date</th>
        <th>Confirmation</th>
        <th>IdUser</th>
        <th>Action</th>


        <c:forEach var="reservation" items="${listReservation}">
            <tr>

                <td>${reservation.idReservation}</td>
                <td>${reservation.Date}</td>
                <td>${reservation.confirmation}</td>
                <td>${reservation.idUser}</td>
                <td><a href="editReservation?id=${reservation.id}">Edit</a>
                    <a href="removeReservation?id=${reservation.id}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
		<a href="logout"></a>
	</div>
        </body>
        </html>
