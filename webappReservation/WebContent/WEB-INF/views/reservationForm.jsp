<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/style.css?<%=System.currentTimeMillis()%>"> 
<title>Reservation</title>
</head>
<body>

<h2>Welcome <%= request.getSession().getAttribute("userNom") %> <%= request.getSession().getAttribute("userPrenom") %></h2>
	<div align="center">
		<h1>Reservation</h1>
		<form:form action="saveReservation" method="post" modelAttribute="reservation">
		
<%-- 		<form:input id="select-box-input" type="checkbox" path="typeReservation">
		
   <label for="select-box-input" class="select-box" tabindex="-1">

  <form:input id="item-1" type="radio"  value ="Weekend" name="select" checked />
  
  <label for="item-1">Weekend</label>
  <form:input id="item-2" type="radio" value ="Matin" name="select"/>
  
  <label for="item-2" >Matin</label>
  
  <form:input id="item-3" type="radio" value ="matin" name="select"/>
  
  <label for="item-3">Soir</label> --%>
		
		
<div class="form-group col-md-4">
      <label for="inputState">Type</label>
      <form:select id="inputState" class="form-control" path="typeReservation">
        <form:option value ="weekend" >weekend</form:option>
        <form:option value ="matin">matin</form:option>
        <form:option value ="soir">soir</form:option>
      </form:select>
    </div> 
			<td>Date:</td>
			<form:input type="date" id="start" name="trip-start"
				value="2021-07-22" min="2021-01-01" max="2022-12-31"
				path="dateReservation" />
			<td colspan="2" align="center"><input type="submit" value="Save"></td>
		</form:form>
	</div>

</body>
</html>
