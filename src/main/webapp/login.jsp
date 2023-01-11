<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="constants.Constants"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <c:if test="${not empty message}">
        ${message}
    </c:if>
    <h2>Login form</h2>
    <form method="post" action='<c:url value="/login"/>'>
        <input type="text" name="<%= Constants.LOGIN %>" placeholder="Login">
        <input type="password" name="<%= Constants.PASSWORD %>" placeholder="Password">
        <input type="submit" value="LogIn" >
    </form>
</body>
</html>
