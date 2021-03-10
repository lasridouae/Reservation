<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Youcode Reservation</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->


    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Satisfy" rel="stylesheet">


    <!-- jquery -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <!-- bootstrap -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Vendor CSS Files -->
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/vendor/boxicons/css/boxicons.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/vendor/icofont/icofont.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/img/homePage.jpg" />" rel="stylesheet">





</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="fixed-top  d-flex justify-content-center align-items-center header-transparent">

    <nav class="nav-menu d-none d-lg-block">
        <ul>
            <li class="active"><a href="index.html">Home</a></li>
            <li><a href="#about">Reservation</a></li>
            <li><a href="${pageContext.request.contextPath}/loginPage">Login</a></li>
            <li><a href="#services">Register</a></li>
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


<!-- Vendor JS Files -->
<link href="<c:url value="/resources/vendor/jquery/jquery.min.js" />" rel="stylesheet">
<link href="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />" rel="stylesheet">
</body>

</html>