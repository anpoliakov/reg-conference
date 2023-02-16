<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constants.Constants"%>

<html>
<head>
    <!-- Обязательные метатеги -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- My CSS files -->
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

    <title>Registration</title>
</head>
<body>
    <c:if test="${not empty message}">
        <span style="color:red">
            ${message}
        </span>
    </c:if>

    <h2> Registration form </h2>
    <form action="/registration" method="POST">
        <input type="text" name="<%= Constants.LOGIN %>" placeholder="Login"><br>
        <input type="password" name="<%= Constants.PASSWORD %>" placeholder="Password" > <br>
        <input type="text" name="<%= Constants.FIRST_NAME %>" placeholder="First name" > <br>
        <input type="text" name="<%= Constants.SECOND_NAME %>" placeholder="Last name" > <br>
        <input type="text" name="<%= Constants.EMAIL %>" placeholder="Email" > <br>
        <input type="submit" value="Registration" >
    </form>

    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>

    <!-- Подключаем JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>
