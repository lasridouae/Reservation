<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>home</title>
   <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Satisfy" rel="stylesheet">



<%-- <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/style.css"> 
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/vendor/boxicons/css/boxicons.min.css"> 
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/vendor/icofont/icofont.min.css"> 
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/img/homePage.jpg">  --%>
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<header id="header" class="fixed-top  d-flex justify-content-center align-items-center header-transparent">

    <nav class="nav-menu d-none d-lg-block">
        <ul>
            <li class="active"><a href="home">Home</a></li>
            <li><a href="reservation">Reservation</a></li>
            <li><a href="login">Login</a></li>
            <li><a href="register">Register</a></li>
        </ul>
    </nav><!-- .nav-menu -->

</header><!-- End Header -->

<!-- ======= Hero Section ======= -->
<section id="hero">
    <div class="hero-container">
        <h1>Welcome</h1>
        <h2>Reserve your place at Youcode</h2>
    </div>
</section><!-- End Hero -->


<!-- ======= Footer ======= -->
<footer id="footer">
    <div class="container">

        <div class="social-links">
            <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
            <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
            <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
        </div>
        <div class="copyright">
            &copy; Copyright <strong><span>Youcode</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
            Designed by <a href="#">Dlas</a>
        </div>
    </div>
</footer><!-- End Footer -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!-- jquery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</body>
</html>