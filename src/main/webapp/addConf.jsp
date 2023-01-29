<%@ page import="constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New conference</title>
    <script type="text/javascript" src = '<c:url value = "/js/main.js"/>'></script>
</head>
<body>
    <c:if test="${not empty message}">
        <span style="color: red">${message}</span>
    </c:if>

    <h1> Conference </h1>
    <form id="addConf" method="POST" action='<c:url value = "/addConf"/>'>
        <input type="text" name="<%= Constants.TITLE%>" placeholder="Title"><br>
        <input type="text" name="<%= Constants.DESCR %>" placeholder="Description"><br>
        <input type="text" name="<%= Constants.PLACE %>" placeholder="Place"><br>
        <input type="date" name="<%= Constants.DATE %>" placeholder="Date"><br>

        <p>Events</p>
        <div id="event">
            <input type="text" name="<%= Constants.TITLE_EV%>" placeholder="Title" required>
            <input type="time" name="<%= Constants.TIME %>" placeholder="Time" required>
        </div>
    </form>

    <br>
    <a href="JavaScript:addEvent()">Add event</a><br>
    <input type="submit" value="Create" form = "addConf">
</body>
</html>
