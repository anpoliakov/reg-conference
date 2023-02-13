<!-- Набор JSP функций (базовый - core, ещё есть function) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="constants.Constants" %>

<html>
<head>

</head>
<body>
<c:if test="${not empty message}">
    ${message}
</c:if>

<main class="form-signin w-100 m-auto">
    <form method="post" action='<c:url value="/login"/>'>
        <%--            <img class="mb-4" src="img/logo.svg" alt="" width="72" height="57">--%>
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" name="<%= Constants.LOGIN %>">
            <label for="floatingInput">Login</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="<%= Constants.PASSWORD %>">
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">© 2022–2023</p>
    </form>
</main>
</body>
</html>