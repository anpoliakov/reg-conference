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
    <!-- HEADER -->
    <jsp:include page="/headerAllPages.jsp"/>

    <div class="container">
        <form class="row g-3" action='<c:url value="/registration"/>' method="POST">

            <h4 class="mb-3" id="distBetweenHeaderAndBody">Registration a new user:</h4>

            <!-- Вывод сообщений об ошибках -->
            <c:if test="${not empty message}">
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    ${message}
                </div>
            </c:if>

            <div class="col-md-6">
                <label for="inputFirstName" class="form-label">First Name</label>
                <input type="text" name="<%=Constants.FIRST_NAME%>" class="form-control" id="inputFirstName">
            </div>
            <div class="col-md-6">
                <label for="inputSecondName" class="form-label">Second Name</label>
                <input type="text" name="<%=Constants.SECOND_NAME%>" class="form-control" id="inputSecondName">
            </div>
            <div class="col-12">
                <label for="inputLogin" class="form-label">Login</label>
                <input type="text" name="<%=Constants.LOGIN%>" class="form-control" id="inputLogin">
            </div>
            <div class="col-12">
                <label for="inputEmail" class="form-label">Email</label>
                <input type="email" name="<%=Constants.EMAIL%>" class="form-control" id="inputEmail" placeholder="exam@example.ru">
            </div>
            <div class="col-12">
                <label for="inputPassword" class="form-label">Password</label>
                <input type="password" name="<%=Constants.PASSWORD%>" class="form-control" id="inputPassword">
            </div>

            <div class="col-12">
                <input type="submit" value="Registration" class="btn btn-primary">
            </div>
        </form>
    </div>

    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>

    <!-- Подключаем JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>
