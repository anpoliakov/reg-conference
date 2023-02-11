<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Main page of project</title>
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
  </head>

  <body>
    <!-- аналог switch -->
    <c:choose>
      <c:when test="${not empty user}">
        <p>Login: ${user.login}</p>
        <a href= "JavaScript:sendData('conf_by_user')">Cabinet</a>
        <a href='<c:url value="/logout"/>'>Logout</a>
      </c:when>

      <c:otherwise>
        <a href='<c:url value="/login"/>'>LogIn</a><br>
        <a href='<c:url value="/registration"/>'>Registration</a>
      </c:otherwise>
    </c:choose>

    <c:if test="${not empty message}">
      <span style="color: red">${message}</span>
    </c:if>

    <br>

    <table>
      <tr>
        <th><a href="JavaScript: sendData('all')">All</a></th>
        <th><a href="JavaScript: sendData('today')">Today</a></th>
        <th><a href="JavaScript: sendData('tomorrow')">Tomorrow</a></th>
        <th><a href="JavaScript: sendData('soon')">Soon</a></th>
        <th><a href="JavaScript: sendData('past')">Past</a></th>
      </tr>
    </table>

    <!-- Включаю страницу шаблонную -->
    <jsp:include page="/viewConfList.jsp"/>

  </body>
</html>
