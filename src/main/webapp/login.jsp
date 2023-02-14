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
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

    <title>Login</title>
    <link rel="canonical" href="https://getbootstrap.ru/docs/5.1/examples/sign-in/">
    <link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <link rel="stylesheet" href="/docs/5.1/vendor/imazin/imazin.css">
    <meta name="theme-color" content="#7952b3">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link href='<c:url value ="/css/signin.css"/>' rel="stylesheet">
</head>
<body class="text-center">
    <main class="form-signin">
        <form action='<c:url value="/login"/>'>
            <img class="mb-4" src="img/logo.svg" alt="" width="72" height="57">
            <h1 class="h3 mb-3 fw-normal">Please,enter your login and password!</h1>

            <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput" name="<%= Constants.LOGIN %>" placeholder="name@example.com">
                <label for="floatingInput">Login</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="<%= Constants.PASSWORD %>" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
            <p class="mt-5 mb-3 text-muted">© 2017–2022</p>
        </form>
    </main>

    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>

    <!-- Подключаем JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>



<%--<c:if test="${not empty message}">--%>
<%--    ${message}--%>
<%--</c:if>--%>

<%--<main class="form-signin w-100 m-auto">--%>
<%--    <form method="post" action='<c:url value="/login"/>'>--%>
<%--        &lt;%&ndash;            <img class="mb-4" src="img/logo.svg" alt="" width="72" height="57">&ndash;%&gt;--%>
<%--        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>--%>

<%--        <div class="form-floating">--%>
<%--            <input type="email" class="form-control" id="floatingInput" name="<%= Constants.LOGIN %>">--%>
<%--            <label for="floatingInput">Login</label>--%>
<%--        </div>--%>
<%--        <div class="form-floating">--%>
<%--            <input type="password" class="form-control" id="floatingPassword" name="<%= Constants.PASSWORD %>">--%>
<%--            <label for="floatingPassword">Password</label>--%>
<%--        </div>--%>

<%--        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>--%>
<%--        <p class="mt-5 mb-3 text-muted">© 2022–2023</p>--%>
<%--    </form>--%>
<%--</main>--%>
