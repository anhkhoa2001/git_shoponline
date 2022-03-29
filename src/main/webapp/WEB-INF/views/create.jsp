<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/registor.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/all.min.css" />" />
</head>
<body>
<div class="main">
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>
                    <div class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="name"><i class="fas fa-user"></i></label>
                            <input type="text" name="name" id="name" placeholder="Your Name" />
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="fas fa-envelope"></i></label>
                            <input type="email" name="email" id="email" placeholder="Your Email" />
                            <i class="fas fa-times-circle" id = "email-false"></i>
                        </div>
                        <div class="form-group">
                            <label for="phone"><i class="fas fa-mobile"></i></label>
                            <input type="number" name="phone" id="phone" placeholder="Your Phone" />
                            <i class="fas fa-times-circle" id = "phone-false"></i>
                        </div>
                        <div class="form-group">
                            <label for="username"><i class="fas fa-user-secret"></i></label>
                            <input type="text" name="username" id="username" placeholder="Username" />
                            <i class="fas fa-times-circle" id = "username-false"></i>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="fas fa-lock"></i></label>
                            <input type="password" name="pass" id="pass" placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <label for="re-pass"><i class="fas fa-unlock"></i></label>
                            <input type="password" name="re_pass" id="repeat-pass" placeholder="Repeat your password" />
                            <i class="fas fa-times-circle" id = "undupli-pass"></i>
                            <i class="fas fa-check" id = "dupli-pass"></i>
                        </div>
                        <div class="form-group">
                            <label for="address"><i class="fas fa-map-marker-alt"></i></label>
                            <input type="text" name="address" id="address" placeholder="Your Address" />
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group form-button">
                            <button name="signup" id="signup" class="form-submit" onclick = "submitForm()">Register</button>
                        </div>
                    </div>
                </div>
                <div class="signup-image">
                    <figure><img src="https://colorlib.com/etc/regform/colorlib-regform-7/images/signup-image.jpg" alt="sing up image"></figure>
                    <a href="#" class="signup-image-link">I am already member</a>
                </div>
            </div>
        </div>
    </section>
</div>
<script>
    const inputUserName = document.getElementById("username");
    const inputEmail = document.getElementById("email");
    const inputPhone = document.getElementById("phone");
    const inputPass = document.getElementById("pass");
    const inputRepeatPass = document.getElementById("repeat-pass");
    const checkDupliPass = document.getElementById("dupli-pass");
    const checkUnDupliPass = document.getElementById("undupli-pass");
    const checkEmailFalse = document.getElementById("email-false");
    const checkPhoneFalse = document.getElementById("phone-false");
    const checkUserFalse = document.getElementById("username-false");

    var passs = [];

    inputPass.addEventListener('input', function(e) {
        passs = [];
        passs[passs.length++] = e.target.value;
    });
    inputRepeatPass.addEventListener('input', function(e) {
        if(e.target.value === passs[passs.length-1]) {
            checkDupliPass.classList.add("open");
            checkDupliPass.classList.add("true");
            checkUnDupliPass.classList.remove("open");
            checkSubmit();
        } else {
            checkUnDupliPass.classList.add("open");
            checkDupliPass.classList.remove("open");
            checkSubmit();
        }
    });
    
    fetch("/myspring/apiaccount", {
        method: 'GET',
    }).then(resp => {
        if(resp.status === 200) {
            return resp.json();
        }
    }).then(dataJSON => {
    	for(let d of dataJSON) {
    		usernames[usernames.length++] = d.username;
    		emails[emails.length++] = d.email;
    		phones[emails.length++] = d.phone;
    	}
    	checkSubmit();
    });


    let usernames = [];

    let emails = [];
    function checkEmail(e) {
        console.log(e.target.value);
        if(e.target.value.indexOf('@gmail.com') != -1) {
            for(var v of emails) {
                if(e.target.value === v) {
                    checkEmailFalse.classList.add("open");
                    checkSubmit();
                    break;
                } else {
                    checkEmailFalse.classList.remove("open");
                    checkSubmit();
                }
            }
        } else {
            checkEmailFalse.classList.add("open");
        }
    }
    let phones = [];
    function checkPhone(e) {
        for(var v of phones) {
            if(Number(e.target.value) === Number(v) || e.target.value.length != 10 || e.target.value === '') {
                checkPhoneFalse.classList.add("open");
                checkSubmit();
                break;
            } else {
                checkPhoneFalse.classList.remove("open");
                checkSubmit();
            }
        }
    }
    function checkUsername(e) {
        for(var v of usernames) {
            if(e.target.value === v) {
                checkUserFalse.classList.add("open");
                checkSubmit();
                break;
            } else {
                checkUserFalse.classList.remove("open");
                checkSubmit();
            }
        }
    }

    inputEmail.addEventListener('input', checkEmail);
    inputPhone.addEventListener('input', checkPhone);
    inputUserName.addEventListener('input', checkUsername);

    function checkSubmit() {
        if(checkEmailFalse.className.indexOf("open") === -1 && 
            checkPhoneFalse.className.indexOf("open") === -1 &&
            checkUserFalse.className.indexOf("open") === -1 &&
            checkDupliPass.className.indexOf("open") != -1) {
            document.getElementById("signup").disabled = false;
        } else {
            document.getElementById("signup").disabled = true;
        }
    }

    
    function submitForm() {
    	var name = document.querySelector("#register-form #name").value;
    	var email = document.querySelector("#register-form #email").value;
    	var phone = document.querySelector("#register-form #phone").value;
    	var username = document.querySelector("#register-form #username").value;
    	var pass = document.querySelector("#register-form #pass").value;
    	var address = document.querySelector("#register-form #address").value;
    	
    	var dataJSON = {
    		"name": name,
    		"email": email,
    		"phone": phone,
    		"username": username,
    		"pass": pass,
    		"address": address
    	}
    	fetch("/myspring/registor", { 
    		method: 'POST',
    		headers: {
    		    'Content-Type': 'application/json ;charset=UTF-8',
    		},
    		body: JSON.stringify(dataJSON),
    	})
    	.then(response => response.json())
    	.then(data => {
    	  	console.log(data);
    		if(data == '1') {
    			alert("Tạo tài khoản thành công!!");
    			location.replace("/myspring/home");
    		} else {
    			alert("Tạo tài khoản thất bại!!");
    			location.replace("/myspring/registor");
    		}
    	});
    }
    
</script>
</body>
</html>