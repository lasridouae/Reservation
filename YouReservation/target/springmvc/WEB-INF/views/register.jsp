<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>

<body>
	<div id="register">
	<h2>this is a form (kinda)</h2>
		<form:form action="/webappReservation/processForm" method="post"
			modelAttribute="users">
			<p>
				<label>Nom</label>
				<form:input path="userNom" />
			</p>
			<p>
				<label>Prenom</label>
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
</body>
</html>
			
			
			
			
			
