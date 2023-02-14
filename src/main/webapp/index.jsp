<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Обязательные метатеги -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <!-- My CSS files -->
  <link rel="stylesheet" href='<c:url value ="/css/main.css"/>'>

  <title>Main Page</title>
</head>

<body>
  <main>
    <header class="p-3 bg-dark text-white">
      <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
            <img style="fill: aliceblue" class="bi me-2" width="40" height="32" src="img/logo.svg" alt="logo">
          </a>

          <!-- Ссылки с левой стороны шапки -->
          <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
            <c:if test="${not empty user}">
              <li><a href='<c:url value = "/home.jsp"/>' class="nav-link px-2 text-secondary"><c:out value="Hello, ${user.login}!"></c:out></a></li>
              <li><a href="JavaScript:sendData('conf_by_user')" class="nav-link px-2 text-white"> Cabinet </a></li>
            </c:if>
            <li><a href="#" class="nav-link px-2 text-white">All Conferences</a></li>
            <li><a href="#" class="nav-link px-2 text-white">About me</a></li>
          </ul>

          <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
            <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
          </form>

          <div class="text-end">
            <!-- Ссылки с правой стороны шапки-->
            <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
              <c:choose>
                <c:when test="${not empty user}">
                  <li>
                    <a href='<c:url value="/logout"/>' class="nav-link text-secondary">
                      <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi d-block mx-auto mb-1" width="24" height="24" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                        <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                      </svg>
                      Logout
                    </a>
                  </li>
                </c:when>

                <c:otherwise>
                  <li>
                    <a href='<c:url value="/login"/>' class="nav-link text-secondary">
                      <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi d-block mx-auto mb-1" width="24" height="24" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z"/>
                        <path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                      </svg>
                      Login
                    </a>
                  </li>
                  <li>
                    <a href='<c:url value="/regist.jsp"/>' class="nav-link text-secondary">
                      <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi d-block mx-auto mb-1" width="24" height="24" viewBox="0 0 16 16">
                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z"/>
                        <path d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z"/>
                      </svg>
                      Registration
                    </a>
                  </li>
                </c:otherwise>
              </c:choose>
            </ul>
          </div>
        </div>
      </div>
    </header>
  </main>

    <c:if test="${not empty message}">
      <span style="color: red">${message}</span>
    </c:if>
    </div>
    <table>
        <tr>
            <th><a href="JavaScript: sendData('all')">All</a></th>
            <th><a href="JavaScript: sendData('today')">Today</a></th>
            <th><a href="JavaScript: sendData('tomorrow')">Tomorrow</a></th>
            <th><a href="JavaScript: sendData('soon')">Soon</a></th>
            <th><a href="JavaScript: sendData('past')">Past</a></th>
        </tr>
    </table>
    <!-- Включаю страницу шаблонную -->
    <jsp:include page="/viewConfList.jsp"/>

<!-- Подключаем JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<!-- My JavaScript -->
<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
</body>
</html>
