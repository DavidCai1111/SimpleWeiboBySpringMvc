<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>注册</title>
    <jsp:include page="header/header.jsp"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/signUp.js"></script>
</head>
<body>
<h1 class="text-center">注册页</h1>
<div class="container">
    <form action="/doSignup" method="post" class="col-md-5 col-md-offset-4">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input id="username"  name="username" class="form-control" type="text" placeholder="请输入用户名"><span id="validateUserName" class="text-success"></span>
        </div>
        <div class="form-group">
            <label for="passowrd">密码：</label>
            <input id="passowrd" name="password" class="form-control" type="password" placeholder="请输入密码">
        </div>
        <button type="submit" class="btn btn-default">注册</button>
        <a href="/login" class="btn btn-primary">登录</a>
    </form>
</div>

</body>
</html>
