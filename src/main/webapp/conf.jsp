<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Conference info</title>
</head>
<body>
    <c:set var="conf" value="${conferences[indexConf]}" scope="page"/>
    <h2>${conf.title}</h2>
    <p>Place: ${conf.place}</p>
    <p>Date: ${conf.date}</p>

    <h3>Conference program</h3>
    <table style="border: 1px solid">
        <tr>
            <th>Event</th>
            <th>Time</th>
        </tr>
        <c:forEach var="event" items="${conf.events}">
            <tr>
                <td>${event.title}</td>
                <td>${event.time}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
