<%@ page import="constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Main page of project</title>
  </head>
  <body>
    <h1> Hello, dear friend! </h1>

    <!-- аналог switch в Java-->
    <c:choose>
      <c:when test="${not empty user}">
        <p>Your login : ${user.login}</p>
        <a href='<c:url value="/logout"/>'>Logout</a>
      </c:when>

      <c:otherwise>
        <a href='<c:url value="/login"/>'>LogIn</a>
      </c:otherwise>
    </c:choose>

  </body>
</html>
