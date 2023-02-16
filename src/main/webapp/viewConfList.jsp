<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty conferences}">
    <table class="table table-striped table-hover">
        <tr>
            <th>Conference</th>
            <th>Place</th>
            <th>Date</th>
        </tr>

        <c:forEach var = "conf" items ="${conferences}">
        <tr>
            <td id = "idConf">${conf.id}</td>
            <td>
                <a href = "JavaScript:getConf('${conf.id}')">${conf.title}</a>
                <br>
                <span>${conf.descr}</span>
            </td>
            <td>${conf.place}</td>
            <td>${conf.date}</td>
        </tr>
        </c:forEach>

    </table>
</c:if>
