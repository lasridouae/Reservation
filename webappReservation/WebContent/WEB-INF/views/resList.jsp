<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome <%= request.getSession().getAttribute("userNom") %> <%= request.getSession().getAttribute("userPrenom") %></h2>
 <h3>
     <a href="newReservation">New Reservation</a>
     
  </h3>
</body>
</html>