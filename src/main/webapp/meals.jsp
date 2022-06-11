<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">--%>
    <title>Show All MealTos</title>
</head>
<tbody>
<table border=1>
    <thead>
    <tr>
        <th>MealTo Id</th>
        <th>DateTime</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Excess</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <%--    <tbody>--%>
    <br/>
    <h2>Привет Артем!!!</h2> <br/>
<%--    <c:forEach var="meal" items="${requestScope.meals}">--%>
<%--        <tr>--%>
        <c:forEach var="mea" items="${requestScope.keySet()}">--%>
                <ul>
                  <li><c:out value="${mea.id}" /></li>
                  <li><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></li>
                  <li><c:out value="${mea.description}" /></li>
                  <li><c:out value="${mea.calories}" /></li>
                  <li><c:out value="${mea.excess}" /></li>

                </ul>
                <hr/>
            </c:forEach>

<%--            <td><c:out value="${meals.id}" /></td>--%>
<%--            <td><c:out value="${meals.dateTime}"/></td>--%>
<%--                &lt;%&ndash;        <li><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></li>&ndash;%&gt;--%>
<%--            <td><c:out value="${meals.description}" /></td>--%>
<%--            <td><c:out value="${meals.calories}" /></td>--%>
<%--            <td><c:out value="${meals.excess}" /></td>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>
        <hr/>


</table>

<h2>Привет Артем????</h2><br />
<form method="post" action="">
    <%--<c:forEach var="mea" items="${requestScope.atomicIntegerMealToMap}">--%>
    <tr>
        <section>
            <h3>Привет Артем????!!!!!!!!!!!!!!!!!</h3>
            <jsp:useBean id="meals" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>
    <tr>
     <td>   ID: ${meals.id} |DateTime: ${meals.dateTime} | Description: ${meals.description} |--%>
            Calories :${meals.calories}|Excess :${meals.excess}</td>
        <td><a href="meals?action=update">Update</a></td>
    </tr>


    <%--            <input type ="text" name="mealToid"></td>--%>
    <%--        <td> DateTime: <input type ="text" name="dateTime"></td>--%>
    <%--        <td> Description <input type ="text" name="description"></td>--%>
    <%--        <td> Calories <input type ="text" name="calories"></td>--%>
    <%--        <td> Excess <input type ="text" name="excess"></td>--%>


    <input type="submit" value="OK" name="OK"><br>
    </section>
    <%--</c:forEach>--%>

</form>
</tbody>

</html>

<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<html lang="ru">--%>
<%--<head>--%>
<%--    <title>Meals Util</title>--%>

<%--<style type="text/css">--%>
<%--    TABLE {--%>
<%--        width: 500px; /* Ширина таблицы */--%>
<%--        border-collapse: collapse; /* Убираем двойные линии между ячейками */--%>
<%--    }--%>
<%--    TD, TH {--%>
<%--        padding: 3px; /* Поля вокруг содержимого таблицы */--%>

<%--        border: 1px solid black; /* Параметры рамки */--%>
<%--    }--%>
<%--    TH {--%>
<%--        background: #b0e0e6; /* Цвет фона */--%>
<%--    }--%>

<%--</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table>--%>
<%--<caption>Таблица Meals Util</caption>--%>
<%--    <tr>--%>
<%--        <th>Дата</th>--%>
<%--        <th>Какой прием пищи</th>--%>
<%--        <th>Калории</th>--%>
<%--        <th>Значение за день</th>--%>
<%--    </tr>--%>
<%--    <tbody>--%>
<%--<c:forEach items="${mealsTo}" var="mea">--%>
<%--<tr style="color:${ (mea.excess == true ? 'red' : 'lime')}; background-color: ghostwhite">--%>
<%--<fmt:parseDate value="${ mea.dateTime }" pattern="yyyy-mm-dd'T'HH:mm" var="parsedDateTime" type="both"/>--%>
<%--    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/></td>--%>
<%--        <td><c:out value="${mea.description}"/></td>--%>
<%--        <td><c:out value="${mea.calories}"/></td>--%>
<%--        <td><c:out value="${mea.excess}"/></td>--%>

<%--    </tr>--%>
<%--</c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--&lt;%&ndash;<p><a href="index.jsp">Home</a></p>&ndash;%&gt;--%>

<%--</body>--%>
<%--</html>--%>