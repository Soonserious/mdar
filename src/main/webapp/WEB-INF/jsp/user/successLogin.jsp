<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <sec:authorize access="hasRole('ROLE_PATIENT')">
                <button type="button" class="togglebtn" onclick="location.href='/patient/main'">LOG IN</button>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_DOCTOR')">
                <button type="button" class="togglebtn" onclick="location.href='/doctor/main'">DOCTOR</button>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <button type="button" class="togglebtn" onclick="location.href='/admin/main'">ADMIN</button>
            </sec:authorize>
        </div>
</div>
</body>
</html>

