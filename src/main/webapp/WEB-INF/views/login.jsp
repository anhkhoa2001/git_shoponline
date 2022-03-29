<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Sign In</title>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/login.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />" />
	<meta name="robots" content="noindex, follow">
</head>
<body>
<div class="main">
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure><a href="/myspring"> <img src="<c:url value="/resources/img/login/login1.jpg" />" alt="sing up image" /></a></figure>
                    <a href="/myspring/registor" class="signup-image-link">Create an account</a>
                </div>
                <div class="signin-form">
                    <h2 class="form-title">Sign in</h2>
                    <form action="/myspring/login?status=access" method="POST" name = "login" class="register-form" id="login-form">
                        <div class="form-group">
                            <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="your_name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="your_pass" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                            <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            <a href="#" class = "form-forgot">Forgot password?</a>
                        </div>
                        <div id = "wrong-pass">
                            <p class = "pass_wrong" style="display: none; color: red; font-size: 13px;">Wrong account or password!!</p>
                        </div>
                        <div class="form-group form-button">
                            <button type = "submit" name="signin" id="signin" class="form-submit">Login</button>
                        </div>
                    </form>
                    <div class="social-login">
                    <ul class="socials">
                        <span class="social-label">Or login with</span>
                        <li class = "social-fb"><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                        <li class = "social-tw"><a href="#"><i class="fab fa-twitter"></i></a></li>
                        <li class = "social-gg"><a href="#"><i class="fab fa-google"></i></a></li>
                    </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script src = "<c:url value="/resources/js/login.js" />"></script>
</body>
</html>