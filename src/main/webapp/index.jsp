<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Main page of project</title>
    <script type="text/javascript" src='<c:url value="/JS/main.js"/>'></script>
  </head>
  <body>
    <h1> Hello, dear friend! </h1>
    <c:if test="${not empty message}">
      <span style="color: red">${message}</span>
    </c:if>


    <!-- аналог switch в Java-->
    <c:choose>
      <c:when test="${not empty user}">
        <p>Your login : ${user.login}</p>
        <a href='<c:url value="/logout"/>'>Logout</a>
      </c:when>

      <c:otherwise>
        <a href='<c:url value="/login"/>'>LogIn</a><br>
        <a href='<c:url value="/registration"/>'>Registration</a>
      </c:otherwise>
    </c:choose>

    <br>
    <a href="JavaScript:sendSect('all')">All</a>
    <a href="JavaScript:sendSect('today')">Today</a>
    <a href="JavaScript:sendSect('tomorrow')">Tomorrow</a>
    <a href="JavaScript:sendSect('soon')">Soon</a>
    <a href="JavaScript:sendSect('finished')">Finished</a>
    <br>

    <c:if test="${not empty conferences}">
      <table style="border:1px solid">
        <tr>
          <td>ID</td>
          <td>Name</td>
          <td>Place</td>
          <td>Date</td>
        </tr>
        <c:forEach var="conf" items="${conferences}">
          <tr>
            <td>${conf.id}</td>
            <td>${conf.name}</td>
            <td>${conf.place}</td>
            <td>${conf.date}</td>
          </tr>
        </c:forEach>
      </table>
    </c:if>

  </body>
</html>
