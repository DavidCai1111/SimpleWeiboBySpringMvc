<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/resources/js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<h1 class="text-center">注册页</h1>

<div class="container">
    <form action="/doSignup" method="post" class="col-md-5 col-md-offset-4">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input id="username"  name="username" class="form-control" type="text" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="passowrd">密码：</label>
            <input id="passowrd" name="password" class="form-control" type="password" placeholder="请输入密码">
        </div>
        <button type="submit" class="btn btn-default">注册</button>
    </form>
</div>

</body>
</html>
