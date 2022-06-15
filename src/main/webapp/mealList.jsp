<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="ru">
<head>
    <title>Meals Util</title>

<style type="text/css">
    TABLE {
        width: 500px; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    TD, TH {
        padding: 3px; /* Поля вокруг содержимого таблицы */

        border: 1px solid black; /* Параметры рамки */
    }
    TH {
        background: #b0e0e6; /* Цвет фона */
    }

</style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <h3>MEAL LIST</h3>
    <a href="meals?action=create">Add Meal</a>
    <hr>

<table>
<caption>Таблица Meals Util</caption>

    <tr>
        <th>Дата</th>
        <th>Какой прием пищи</th>
        <th>Калории</th>
        <th></th>
        <th></th>
<%--        <th>Значение за день</th>--%>
    </tr>

<%--    <tbody>--%>
<c:forEach items="${mealList}" var="mea">
    <jsp:useBean id="mea" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
<tr style="color:${ (mea.excess == true ? 'red' : 'lime')}; background-color: ghostwhite">
<fmt:parseDate value="${ mea.dateTime }" pattern="yyyy-mm-dd'T'HH:mm" var="parsedDateTime" type="both"/>
    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/></td>
        <td>${mea.description}/></td>
        <td>${mea.calories}/></td>
    <td><a href="meals?action=update&id=${mea.id}">Update</a> </td>
    <td><a href="meals?action=delete&id=${mea.id}">Delete</a> </td>
<%--        <td><c:out value="${mea.excess}"/></td>--%>

    </tr>
</c:forEach>
</table>
<%--    </tbody>--%>
</section>
<%--<p><a href="index.jsp">Home</a></p>--%>

</body>
</html>






<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    &lt;%&ndash;  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">&ndash;%&gt;--%>
<%--    <title>Show All MealTos</title>--%>
<%--</head>--%>
<%--<tbody>--%>
<%--<table border=1>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>MealTo Id</th>--%>
<%--        <th>DateTime</th>--%>
<%--        <th>Description</th>--%>
<%--        <th>Calories</th>--%>
<%--        <th>Excess</th>--%>
<%--        <th colspan=2>Action</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    &lt;%&ndash;    <tbody>&ndash;%&gt;--%>
<%--    <br/>--%>
<%--    <h2>Привет Артем!!!</h2> <br/>--%>
<%--    &lt;%&ndash;    <c:forEach var="meal" items="${requestScope.meals}">&ndash;%&gt;--%>
<%--    &lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--    <c:forEach var="mea" items="${requestScope.keySet()}">&ndash;%&gt;--%>
<%--        <ul>--%>
<%--            <li><c:out value="${mea.id}" /></li>--%>
<%--            <li><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></li>--%>
<%--            <li><c:out value="${mea.description}" /></li>--%>
<%--            <li><c:out value="${mea.calories}" /></li>--%>
<%--            <li><c:out value="${mea.excess}" /></li>--%>

<%--        </ul>--%>
<%--        <hr/>--%>
<%--    </c:forEach>--%>

<%--    &lt;%&ndash;            <td><c:out value="${meals.id}" /></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;            <td><c:out value="${meals.dateTime}"/></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;                &lt;%&ndash;        <li><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></li>&ndash;%&gt;&ndash;%&gt;--%>
<%--    &lt;%&ndash;            <td><c:out value="${meals.description}" /></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;            <td><c:out value="${meals.calories}" /></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;            <td><c:out value="${meals.excess}" /></td>&ndash;%&gt;--%>

<%--    &lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--    &lt;%&ndash;    </c:forEach>&ndash;%&gt;--%>
<%--    <hr/>--%>


<%--</table>--%>

<%--<h2>Привет Артем????</h2><br />--%>
<%--<form method="post" action="">--%>
<%--    &lt;%&ndash;<c:forEach var="mea" items="${requestScope.atomicIntegerMealToMap}">&ndash;%&gt;--%>
<%--    <tr>--%>
<%--        <section>--%>
<%--            <h3>Привет Артем????!!!!!!!!!!!!!!!!!</h3>--%>
<%--            <jsp:useBean id="meals" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>--%>
<%--    <tr>--%>
<%--        <td>   ID: ${meals.id} |DateTime: ${meals.dateTime} | Description: ${meals.description} |&ndash;%&gt;--%>
<%--            Calories :${meals.calories}|Excess :${meals.excess}</td>--%>
<%--        <td><a href="meals?action=update">Update</a></td>--%>
<%--    </tr>--%>


<%--    &lt;%&ndash;            <input type ="text" name="mealToid"></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;        <td> DateTime: <input type ="text" name="dateTime"></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;        <td> Description <input type ="text" name="description"></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;        <td> Calories <input type ="text" name="calories"></td>&ndash;%&gt;--%>
<%--    &lt;%&ndash;        <td> Excess <input type ="text" name="excess"></td>&ndash;%&gt;--%>


<%--    <input type="submit" value="OK" name="OK"><br>--%>
<%--    </section>--%>
<%--    &lt;%&ndash;</c:forEach>&ndash;%&gt;--%>

<%--</form>--%>
<%--</tbody>--%>

<%--</html>--%>