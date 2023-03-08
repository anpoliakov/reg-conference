<%@ page import="constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Обязательные метатеги -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS files-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- My CSS files -->
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

    <title>New conference</title>
</head>
<body>
    <!-- HEADER -->
    <jsp:include page="/headerAllPages.jsp"/>

    <div class="container">
        <form class="row g-3" id="addConf" method="POST" action='<c:url value = "/addConf"/>'>
            <h4 class="mb-3" id="distBetweenHeaderAndBody">Creating a new conference</h4>

            <!-- Вывод сообщений об ошибках -->
            <c:if test="${not empty message}">
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                        ${message}
                </div>
            </c:if>

            <!-- TITLE -->
            <div class="col-6">
                <label for="inputTitle" class="form-label">Title</label>
                <input name="<%= Constants.TITLE %>" class="form-control" id="inputTitle">
            </div>

            <!-- DESCRIPTION -->
            <div class="col-md-12">
                <label for="inputDescription" class="form-label">Description</label>
                <input type="text" name="<%= Constants.DESCR %>" class="form-control" id="inputDescription">
            </div>

            <!-- PLACE -->
            <div class="col-md-6">
                <label for="inputPlace" class="form-label">Place</label>
                <input type="text" name="<%= Constants.PLACE %>" class="form-control" id="inputPlace">
            </div>

            <!-- DATE -->
            <div class="col-md-6">
                <label for="inputDate" class="form-label">Date</label>
                <input type="date" name="<%= Constants.DATE %>" class="form-control" id="inputDate" placeholder="19.02.2022">
            </div>

            <h4 class="mb-3" id="distBetweenHeaderAndBody">Add events</h4>

            <div id="event" class="row">
                <div class="col-md-6">
                    <label for="inputNameEvent" class="form-label">Name event</label>
                    <input type="text" name="<%= Constants.TITLE_EV%>" class="form-control" id="inputNameEvent">
                </div>
                <div class="col-md-5">
                    <label for="inputTimeEvent" class="form-label">Time</label>
                    <input type="time" name="<%= Constants.TIME_EV %>" class="form-control" id="inputTimeEvent">
                </div>
            </div>

        </form>

        <div class="col-12">
            <input type="button" value="Add Event" onclick="addEvent()" class="btn btn-dark">
        </div>

        <div class="col-12" style="margin-top: 30px;">
            <input type="submit" value="Create Conference" form = "addConf" class="btn btn-primary">
        </div>
    </div>

    <!-- Подключаем JavaScript Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
</body>
</html>
