<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Hello from Java Vision!</h1><br />

<h2>Все пользователи</h2><br />

<c:forEach var="mea" items="${requestScope.meal}">
    <ul>

        <li>DateTime: <c:out value="${mea.dateTime}"/></li>

        <li>Description: <c:out value="${mea.description}"/></li>

        <li>Calories: <c:out value="${mea.calories}"/></li>

        <li>Excess: <c:out value="${mea.excess}"/></li>

        <form method="post" action="<c:url value='/delete'/>">
            <input type="number" hidden name="id" value="${mea.id}" />
            <input type="submit" name="delete" value="Удалить"/>
        </form>

        <form method="get" action="<c:url value='/update'/>">
            <input type="number" hidden name="id" value="${mea.id}" />
            <input type="submit" value="Редактировать"/>
        </form>
    </ul>
    <hr />

</c:forEach>

<h2>Создание нового пользователя</h2><br />

<form method="post" action="<c:url value='/add_meal'/>">

    <label><input type="text" name="dateTime"></label>DateTime<br>
    <label><input type="text" name="description"></label>Description<br>
    <label><input type="text" name="calories"></label>Calories<br>

    <label><input type="text" name="excess"></label>Excess<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
