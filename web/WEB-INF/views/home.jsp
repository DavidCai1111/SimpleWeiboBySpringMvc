<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Just a simple WeiBo</title>
      <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
      <script type="text/javascript" src="/resources/js/jquery-2.1.3.min.js"></script>
      <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
  </head>
  <body>
    <h1>Just a Simple WeiBo</h1>
    <p>请<a href=""><button class="btn btn-default btn-primary">登录</button></a></p>
    <h2>微博列表:</h2>
    <ol>
        <c:forEach var="weibo" items="${weibos}">
            <li>
                <c:out value="${weibo.name}"/>说：  <c:out value="${weibo.content}"/>
            </li>
        </c:forEach>
    </ol>
  </body>
</html>
