<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <!-- Обязательные метатеги -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS files-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- My CSS files -->
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

    <title>Conference info</title>
</head>
<body>
    <!-- HEADER -->
    <jsp:include page="/headerAllPages.jsp"/>

    <!-- Include a main variable  -->
    <c:set var="conf" value="${conferences[indexConf]}" scope="application"/>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <h2 class="fw-light">${conf.title}</h2>
            <p class="lead text-muted">Place: ${conf.place}</p>
            <p class="lead text-muted">Date: ${conf.date}</p>
            <p class="lead text-muted">ID: ${conf.id}</p>

            <h4 class="fw-light">Conference program:</h4>
            <table class="table table-striped table-hover">
                <tr>
                    <th>Event</th>
                    <th>Time</th>
                </tr>
                <c:forEach var="event" items="${conf.events}">
                    <tr>
                        <td>${event.name}</td>
                        <td>${event.time}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <!-- Кнопка редактировани конфиренции -->
        <div class="col-12">
            <input type="button" value="Edit Conference" class="btn btn-primary" onclick="editConf(${conf.id})">
        </div>
    </section>

    <!-- Подключаем JavaScript Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
</body>
</html>