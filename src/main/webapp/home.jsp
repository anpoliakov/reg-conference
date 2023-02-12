<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>
    <script type="text/javascript" src = '<c:url value = "/js/main.js"/>'></script>
</head>
<body>
    <h2>This is your cabinet, ${user.firstName}</h2>

    <c:if test="${not empty conferences}">
        <h3>List your conferences</h3>
        <form id="formDeleteConf" method="POST" action='<c:url value="/removeConf"/>'>
            <jsp:include page="/viewConfList.jsp"/>
        </form>

        <br><input type="submit" value="Delete conferences" form="formDeleteConf">
    </c:if>

    <c:if test="${empty conferences}">
        <p>You don't have any conferences! Please click on 'Add conference'</p>
    </c:if>

    <br>
    <a href='<c:url value = "/addConf.jsp"/>'>Add conference</a>
    <a href='<c:url value = "/index.jsp"/>'>View conferences</a>
</body>
</html>
