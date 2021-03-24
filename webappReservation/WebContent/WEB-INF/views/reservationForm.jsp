<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

        <!DOCTYPE>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation</title>
        </head>
        <body>
        <div align="center">
        <h1>Reseravtion</h1>
        <form:form action="saveReservation" method="post" modelAttribute="reservation">
        <td>Date:</td>
        <form:input type="date" id="start" name="trip-start"  value="2021-07-22" min="2021-01-01" max="2022-12-31" path="dateReservation" />
        <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </form:form>
        </div>

        </body>
        </html> 