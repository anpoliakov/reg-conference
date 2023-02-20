<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Обязательные метатеги -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS files-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <!-- My CSS files -->
  <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

  <title>Main Page</title>
</head>

<body>
    <!-- HEADER -->
    <jsp:include page="/headerAllPages.jsp"/>

    <c:if test="${not empty message}">
        <span style="color: red">${message}</span>
    </c:if>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">List of conferences</h1>
                <p class="lead text-muted">Click at the bottom to sort:</p>
                <p>
                    <a href="JavaScript: sendData('all')" class="btn btn-outline-secondary my-2">All</a>
                    <a href="JavaScript: sendData('today')" class="btn btn-outline-secondary my-2">Today</a>
                    <a href="JavaScript: sendData('tomorrow')" class="btn btn-outline-secondary my-2">Tomorrow</a>
                    <a href="JavaScript: sendData('soon')" class="btn btn-outline-secondary my-2">Soon</a>
                    <a href="JavaScript: sendData('past')" class="btn btn-outline-secondary my-2">Past</a>
                </p>
            </div>
        </div>

        <!-- Включаю страницу c выводом conferences -->
        <jsp:include page="/viewConfList.jsp"/>
    </section>

    <!-- Подключаем JavaScript Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <!-- My JavaScript -->
    <script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
</body>
</html>
