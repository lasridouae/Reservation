 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>

<body>
        <h1>hello if you are here you are user</h1>
<h2>Welcome ${ userName }</h2>
<div align="center">
    <h1>Reservation list</h1>
    <h3>
            <a href="newReservation">New Reservation</a>
        </h3>
    <table border="1">
        <th>idReservation</th>
        <th>Date</th> 
        
             <c:forEach  var="reservation" items="${reservations}"  >
            <tr>
                <td>${reservation.idReservation}</td>
                <td>${reservation.dateReservation}</td>
            </tr>
            </c:forEach>
    </table>
</div>
		<a href="logout">logout</a>
        </body>
        </html>
