<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.Constants"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <c:if test="${not empty message}">
        <span style="color:red">
            ${message}
        </span>
    </c:if>

    <h2> Registration form </h2>
    <form>
        <input type="text" name="<%= Constants.LOGIN %>" placeholder="Login"><br>
        <input type="password" name="<%= Constants.PASSWORD %>" placeholder="Password" > <br>
        <input type="text" name="<%= Constants.FIRST_NAME %>" placeholder="First name" > <br>
        <input type="text" name="<%= Constants.SECOND_NAME %>" placeholder="Last name" > <br>
        <input type="text" name="<%= Constants.EMAIL %>" placeholder="Email" > <br>
        <input type="submit" value="Registration" >
    </form>
</body>
</html>
