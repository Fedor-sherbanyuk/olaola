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
<%--&lt;%&ndash;<p><a href="index.html">Home</a></p>&ndash;%&gt;--%>

<%--</body>--%>
<%--</html>--%>