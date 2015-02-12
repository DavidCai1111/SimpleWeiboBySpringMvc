<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/signUp.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.json-2.2.js"></script>
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
        <a href="/" class="btn btn-danger">返回首页</a>
    </form>
</div>

</body>
</html>
