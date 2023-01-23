<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>
    <script type="text/javascript" src = '<c:url value = "/js/main.js"/>'></script>
</head>
<body>
    <h2>Hello ${user.login}</h2>
    <p>Your name: ${user.firstName} ${user.secondName}</p>
    <p>email: ${user.email}</p>

    <h3>List conferences</h3>
    <c:forEach var="confs" items="${conferences}">
        <c:out value="${confs}"></c:out><br>
    </c:forEach>
</body>
</html>
