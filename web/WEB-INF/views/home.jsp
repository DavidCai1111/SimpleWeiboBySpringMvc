<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
  <head>
    <title>Just a simple WeiBo</title>
      <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
      <script type="text/javascript" src="/resources/js/jquery-2.1.3.min.js"></script>
      <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="/resources/js/home.js"></script>
  </head>

  <body>
    <h1 class="text-center">Just a Simple WeiBo</h1>
    <hr/>

            <p class="text-center">欢迎<s:authentication property="name" var="nameLogin"/>${nameLogin},<a href="/logout"><button class="btn btn-default btn-primary">登出</button></a></p>

    <hr/>

    <h2 class="text-center">微博列表:</h2>

    <ul class="text-center">
        <c:forEach var="weibo" items="${weibos}">
            <li style="list-style: none">
                <c:out value="${weibo.name}"/>说：  <c:out value="${weibo.content}"/>
                <c:if test="${weibo.name == nameLogin}">
                    <form action="/delete" method="post" style="display: inline">
                        <input type="hidden" name="_method" value="delete" />
                        <input type="text" name="idForDelete" value="${weibo.id}" class="hidden"/>
                        <button class="btn btn-danger" type="submit">删除</button>
                    </form>
                </c:if>
            </li>
            <br/>
        </c:forEach>
    </ul>
    <br/>

    <div class="text-center">
        <span>共${page.totalWeibos}条 &nbsp;</span>
        <a id="previousPage" class="btn btn-primary <c:if test='${page.pageNow == 1}'>disabled</c:if>">上一页</a>
        <span class="text-info"> <span id="${page.pageNow}">${page.pageNow}</span>/${page.totalPage}页  </span>
        <a id="nextPage" class="btn btn-primary <c:if test='${page.pageNow == page.totalPage}'>disabled</c:if>">下一页</a>

    </div>
    <hr/>

        <div class="container">
            <form action="/say" method="post" class="form-horizontal form-inline col-md-5 col-md-offset-4">
                <input type="text" name="userOfWeibo" class="hidden" value="<s:authentication property="name"/>">
                <p><s:authentication property="name"/>说：<input type="text" name="contentOfWeibo" class="form-control" placeholder="说点什么..."/>&nbsp;<button type="submit" class="btn btn-primary">发送</button></p>
            </form>
        </div>

  </body>
</html>
