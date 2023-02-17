<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Bootstrap CSS files-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- My CSS files -->
    <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

    <title>Home page</title>
</head>
<body>
    <!-- Have conferences -->
    <c:if test="${not empty conferences}">
        <section class="py-5 text-center container">
            <h1 class="fw-light">List your conferences, ${user.firstName}!</h1>
            <form id="formDeleteConf" method="POST" action='<c:url value="/removeConf"/>'>
                <jsp:include page="/viewConfList.jsp"/>
            </form>
            <input type="submit" value="Delete conferences" form="formDeleteConf" class="btn btn-outline-secondary my-2">
        </section>
    </c:if>

    <!-- Don't have conferences -->
    <c:if test="${empty conferences}">
        <section class="py-5 text-center container">
            <div class="row py-lg-5">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <h1 class="fw-light">List your conferences</h1>
                    <p>You don't have any conferences! Please click on 'Add conference'</p>
                    <p>
                        <a href='<c:url value = "/addConf.jsp"/>' class="btn btn-outline-secondary my-2">Add Conference</a>
                        <a href='<c:url value = "/index.jsp"/>' class="btn btn-outline-secondary my-2">Return</a>
                    </p>
                </div>
            </div>
        </section>
    </c:if>

    <!-- Подключаем JavaScript Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
</body>
</html>
