 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
<body>
        <h1>hello if you are here you are user</h1>
<h2>Welcome ${userName}</h2>
<div align="center">
    <h1>Reservation list</h1>
  <h3>
            <a href="newReservation">New Reservation</a>
        </h3>
    <table border="1">
        <th>idReservation</th>
        <th>Date</th> 
        <th>typeReservation</th> 
        <th>confirmation</th>
        
        
            <c:forEach var="reservation" items="${listReservation}">
                <tr>
 
                    <td>${reservation.idReservation}</td>
                    <td>${reservation.dateReservation}</td>
                    <td>${reservation.typeReservation}</td>
                    <td>${reservation.confirmation}</td>
                    
      <td    class="d-flex flex-row">
                        <form action="deleteReservation"  method="post">
                            <input type="hidden" value="${reservation.idReservation}"  name="id" class="form-control"/>
                            <input type="submit" value="Supprimer" class="btn btn-danger  btn-sm">
                        </form>
                        <c:if test="${reservation.confirmation == false}">
                            <form action="ApprouveReservation"  method="post">
                                <input type="hidden" value="${reservation.idReservation}"  name="id" class="form-control"/>
                                <input type="submit" value="Accepter" class="btn btn-primary  btn-sm">
                            </form>
                        </c:if>
                    </td>
                    
                 
                </tr>
            </c:forEach>
    </table>
</div>
		<a href="logout">logout</a>
        </body>
        </html>
