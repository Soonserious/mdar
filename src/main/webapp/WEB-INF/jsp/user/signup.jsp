<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>로그인 / 회원가입 폼 템플릿</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="wrap">
    <div class="form-wrap">
        <div class="button-wrap">
            <div id="btn"></div>
            <button type="button" class="togglebtn" onclick="login()">LOG IN</button>
            <button type="button" class="togglebtn" onclick="register()">REGISTER</button>
        </div>
        <div class="social-icons">
            <img src="img/fb.png" alt="facebook">
            <img src="img/tw.png" alt="twitter">
            <img src="img/gl.png" alt="google">
        </div>
        <form id="login" action="/user/login" class="input-group" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="text" name="username" class="input-field" placeholder="User name or Email" required>
            <input type="password" name="password" class="input-field" placeholder="Enter Password" required>
            <input type="checkbox" class="checkbox"><span>Remember Password</span>
            <button class="submit">Login</button>
        </form>
        <form id="register" action="signup" method="post" class="input-group">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="text" class="input-field" placeholder="User name or Email" name="userID" required >
            <input type="email" class="input-field" placeholder="Your Email" name="email" required>
            <input type="password" class="input-field" placeholder="Enter Password" name="password" required>
            <input type="password" class="input-field" placeholder="Enter Password" name="checkPassword" required>
            <input type="" class="input-field" placeholder="Your Email" name="" required>
            patient <input type="radio" name="userRole" value="Patient"/> doctor <input type="radio" name="userRole" value="Doctor"/> admin <input type="radio" name="userRole" value="Admin"/>
            <input type="submit" class="submit">
        </form>
    </div>
</div>
<script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");


            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
        </script>
</body>
</html>