<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/style.css">  --%>

<style>

/*--------------------------------------------------------------
# Navigation Menu
--------------------------------------------------------------*/
/* * {
  box-sizing: border-box;
} */

/* body {
  margin: 0px;
  font-family: 'segoe ui';
} */

.nav {
  height: 50px;
  width: 100%;
  background-color: #444444;
  position: relative;
}

.nav > .nav-header {
  display: inline;
}

.nav > .nav-header > .nav-title {
  display: inline-block;
  font-size: 22px;
  color: #fff;
     padding: 1px 10px 10px 10px;
}
.nav-title div{
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}
.nav-title div span{
	color: #5379fa !important;
}

.nav > .nav-btn {
  display: none;
}

.nav > .nav-links {
  display: inline;
  float: right;
  font-size: 18px;
}

.nav > .nav-links > a {
  display: inline-block;
  padding: 13px 10px 13px 10px;
  text-decoration: none;
  color: #efefef;
}

.nav > .nav-links > a:hover {
  background-color: grey ;
}

.nav > #nav-check {
  display: none;
}

@media (max-width:600px) {
  .nav > .nav-btn {
    display: inline-block;
    position: absolute;
    right: 0px;
    top: 0px;
  }
  .nav > .nav-btn > label {
    display: inline-block;
    width: 50px;
    height: 50px;
    padding: 13px;
  }
  .nav > .nav-btn > label:hover,.nav  #nav-check:checked ~ .nav-btn > label {
    background-color: rgba(0, 0, 0, 0.3);
  }
  .nav > .nav-btn > label > span {
    display: block;
    width: 25px;
    height: 10px;
    border-top: 2px solid #eee;
  }
  .nav > .nav-links {
    position: absolute;
    display: block;
    width: 100%;
    background-color: #444444;
    height: 0px;
    transition: all 0.3s ease-in;
    overflow-y: hidden;
    top: 50px;
    left: 0px;
  }
  .nav > .nav-links > a {
    display: block;
    width: 100%;
  }
  .nav > #nav-check:not(:checked) ~ .nav-links {
    height: 0px;
  }
  .nav > #nav-check:checked ~ .nav-links {
    height: calc(100vh - 50px);
    overflow-y: auto;
  }
}



</style>
</head>
<body>
<header id="header" class="fixed-top  d-flex justify-content-center align-items-center header-transparent">
<div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
     <div>You<span>Code</span></div>
    </div>
  </div>
  <div class="nav-btn">
    <label for="nav-check">
      <span></span>
      <span></span>
      <span></span>
    </label>
  </div>
  
  <div class="nav-links">
    <a href="home" >Home</a>
    <a href="register" >Register</a>
    <a href="login" >Login</a>
  </div>
</div>

 <!--    <nav class="nav-menu d-none d-lg-block">
        <ul>
            <li class="active"><a href="home">Home</a></li>
            <li><a href="reservation">Reservation</a></li>
            <li><a href="login">Login</a></li>
            <li><a href="register">Register</a></li>
        </ul>
    </nav> -->
    <!-- .nav-menu -->

</header><!-- End Header -->
</body>
</html>