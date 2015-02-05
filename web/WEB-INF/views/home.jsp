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
    <h1 class="text-center">Just a Simple WeiBo</h1>
    <hr/>
    <c:choose>
        <c:when test="${username != null}">
            <p class="text-center">欢迎<c:out value="${username}"/>,<a href="/logout"><button class="btn btn-default btn-primary">登出</button></a></p>
        </c:when>
        <c:otherwise>
            <p class="text-center">请<a href="/login"><button class="btn btn-default btn-primary">登录</button></a></p>
            <p class="text-center">或<a href="/signUp"><button class="btn btn-default btn-primary">注册</button></a></p>
        </c:otherwise>
    </c:choose>

    <h2 class="text-center">微博列表:</h2>

    <ul class="text-center">
        <c:forEach var="weibo" items="${weibos}">
            <li style="list-style: none">
                <c:out value="${weibo.name}"/>说：  <c:out value="${weibo.content}"/>
            </li>
        </c:forEach>
    </ul>

    <c:if test="${username != null}">
        <div class="container">
            <form action="/say" method="post" class="form-horizontal col-md-5 col-md-offset-4">
                <input type="text" name="userOfWeibo" class="hidden" value="${username}">
                <p><c:out value="${username}"/>说：<input type="text" name="contentOfWeibo" class="form-control" placeholder="说点什么..."/><button type="submit" class="btn btn-primary">发送</button></p>
            </form>
        </div>
    </c:if>

  </body>
</html>
