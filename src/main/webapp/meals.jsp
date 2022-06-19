<%--<h2>Meals</h2>--%>
<%--<form method="GET" action="meals">--%>
<%--    <table border="0" cellpadding="8" cellspacing="0">--%>
<%--        <tr>--%>
<%--            <td>От даты (включая)</td>--%>
<%--            <td>До даты (включая)</td>--%>
<%--            <td></td>--%>
<%--            <td>От времени (включая)</td>--%>
<%--            <td>До времени (включая)</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="date" value="${filter.get('startDate')}" name="startDate"></td>--%>
<%--            <td><input type="date" value="${filter.get('endDate')}" name="endDate"></td>--%>
<%--            <td></td>--%>
<%--            <td><input type="time" value="${filter.get('startTime')}" name="startTime"></td>--%>
<%--            <td><input type="time" value="${filter.get('endTime')}" name="endTime"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <button type="submit">Отфильтровать</button>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <button type="submit" name="cansel" value="true"> Отменить</button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meals</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals</h2>
    <form method="get" action="meals">
        <input type="hidden" name="action" value="filter">
        <dl>
            <dt>From Date (inclusive):</dt>
            <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
        </dl>
        <dl>
            <dt>To Date (inclusive):</dt>
            <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
        </dl>
        <dl>
            <dt>From Time (inclusive):</dt>
            <dd><input type="time" name="startTime" value="${param.startTime}"></dd>
        </dl>
        <dl>
            <dt>To Time (exclusive):</dt>
            <dd><input type="time" name="endTime" value="${param.endTime}"></dd>
        </dl>
        <button type="submit">Filter</button>
    </form>
    <hr/>
    <a href="meals?action=create">Add Meal</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.meals}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.to.MealTo"/>
            <tr data-meal-excess="${meal.excess}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        <%--${fn:replace(meal.dateTime, 'T', ' ')}--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>




<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>--%>
<%--&lt;%&ndash;<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>&ndash;%&gt;--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Meal list</title>--%>
<%--    <style>--%>
<%--        .normal {--%>
<%--            color: green;--%>
<%--        }--%>

<%--        .excess {--%>
<%--            color: red;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<section>--%>
<%--    <h3><a href="index.html">Home</a></h3>--%>
<%--    <hr/>--%>
<%--    <h2>Meals</h2>--%>
<%--    <a href="meals?action=create">Add Meal</a>--%>
<%--    <br><br>--%>
<%--    <table border="1" cellpadding="8" cellspacing="0">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>Date</th>--%>
<%--            <th>Description</th>--%>
<%--            <th>Calories</th>--%>
<%--            <th></th>--%>
<%--            <th></th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <c:forEach items="${requestScope.meals}" var="meal">--%>
<%--            <jsp:useBean id="meal" type="ru.javawebinar.topjava.to.MealTo"/>--%>
<%--            <tr class="${meal.excess ? 'excess' : 'normal'}">--%>
<%--                <td>--%>
<%--                        &lt;%&ndash;${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}&ndash;%&gt;--%>
<%--                        &lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;${fn:replace(meal.dateTime, 'T', ' ')}&ndash;%&gt;--%>
<%--                        ${fn:formatDateTime(meal.dateTime)}--%>
<%--                </td>--%>
<%--                <td>${meal.description}</td>--%>
<%--                <td>${meal.calories}</td>--%>
<%--                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>--%>
<%--                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</section>--%>
<%--</body>--%>
<%--</html>--%>