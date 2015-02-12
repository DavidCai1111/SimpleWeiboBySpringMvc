<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/resources/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.json-2.2.js"></script>
</head>
<body>
    <h1 class="text-center">登录页</h1>

    <div class="container">
        <form action="/j_spring_security_check" method="post" class="col-md-5 col-md-offset-4">
            <c:if test="${signUpSucceed}">
                <p class="text-success">注册成功，请登录</p>
            </c:if>
            <div class="form-group">
                <label for="username">用户名：</label>
                <input id="username"  name="j_username" class="form-control" type="text" placeholder="请输入用户名"/>
            </div>
            <div class="form-group">
                <label for="passowrd">密码：</label>
                <input id="passowrd" name="j_password" class="form-control" type="password" placeholder="请输入密码"/>
            </div>
            <div class="form-control">
                <label for="rememberMe">自动登录</label>
                <input id="rememberMe" name="_spring_security_remember_me" type="checkbox"/>
            </div>
            <button type="submit" class="btn btn-default">提交</button>
            <a href="/signUp" class="btn btn-primary">注册</a>
            <a href="/" class="btn btn-danger">返回首页</a>
        </form>
    </div>

</body>
</html>
