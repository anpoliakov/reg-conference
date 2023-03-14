<!-- Набор JSP функций (базовый - core, ещё есть function) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="constants.Constants" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Обязательные метатеги -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- My CSS files -->
    <link href='<c:url value ="/css/main.css"/>' rel="stylesheet">
    <link href='<c:url value ="/css/signin.css"/>' rel="stylesheet">

    <title>Login</title>
</head>
<body class="text-center">
    <main class="form-signin">
        <form action='<c:url value="/login"/>' method="POST">
            <img class="mb-4" src="img/logo.svg" alt="" width="60" height="60">
            <h3 class="h3 mb-3 fw-normal">Please,enter your login and password</h3>

            <!-- Вывод сообщений об ошибках -->
            <c:if test="${not empty message}">
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                        ${message}
                </div>
            </c:if>

            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" name="<%= Constants.LOGIN %>" placeholder="name@example.com">
                <label for="floatingInput">Login</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="<%= Constants.PASSWORD %>" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
            <a href='<c:url value = "/index.jsp"/>' class="w-100 btn btn-sm btn-secondary" id="distBetweenButLogin">Main Page</a>
            <p class="mt-5 mb-3 text-muted">&copy; 2021-2022</p>
        </form>
    </main>

    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>

    <!-- Подключаем JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>