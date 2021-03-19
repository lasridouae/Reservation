<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!-- Sing in  Form -->
<link href="${pageContext.request.contextPath}../resources/css/login.css"" rel="stylesheet">
<body>
<section class="sign-in">
    <div class="container">
        <div class="signin-content">
            <div class="signin-image">
                <figure><img src="${pageContext.request.contextPath}/resources/images/signin-image.jpg" alt="sing up image"></figure>
                <a href="register" class="signup-image-link">Create an account</a>
            </div>
            <div class="signin-form">
                <h2 class="form-title">Sign up</h2>
               <form class="register-form" id="login-form" action="/webappReservation/loginAcces" method="post">
				<div class="form-group">
                  <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
				<input type="text" name="userEmail"  placeholder="Email"  id="emailId" class="border-bottom border-primary"> </div>
			 <div class="form-group">
                  <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
				<input type="password" name="userPassword" placeholder="password" id="pwd" class="border-bottom border-primary"> </div>
				<div class="form-group form-button">
                        <input type="submit"  class="form-submit" value="Log in"/>
                    </div>
		</form>
	
            </div>
        </div>
    </div>
</section>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<link href="<c:url value="/resources/vendor/jquery/jquery.min.js" />" rel="stylesheet">
</body>
</html>
		

