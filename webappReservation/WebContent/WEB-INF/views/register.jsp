<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>

<body>
	<div id="register">
	<h2>this is a form (kinda)</h2>
	<div align="center">
		<form:form action="/webappReservation/processForm" method="post"
			modelAttribute="users">
			<p>
				<label>Name</label>
				<form:input path="userNom" />
			</p>
			<p>
				<label>lastName</label>
				<form:input path="userPrenom" />
			</p>
				<p>
				<label>Email</label>
				<form:input path="userEmail" />
			</p>
				<p>
				<label>Password</label>
				<form:input type="password" path="userPassword" />
			</p>
				<p>
				<label>re-password</label>
				<input type="password" placeholder="Repeat your password"/>
			</p>
						<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
	</div>
</body>
</html>
			
			
			
			
			
