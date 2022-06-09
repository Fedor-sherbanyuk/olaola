<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">--%>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>

<html>
<head>
    <%--  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">--%>
    <title>Show All MealTos</title>
</head>
<body>
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
    <tbody>
    <br/>
    <h2>Все пользователи</h2> <br/>
    <c:forEach var="mea" items="${requestScope.atomicIntegerMealToMap}">
    <ul>
        <li><c:out value="${mea.id}" /></li>
        <li><c:out value="${mea.dateTime}"/></li>
<%--        <li><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></li>--%>
        <li><c:out value="${mea.description}" /></li>
        <li><c:out value="${mea.calories}" /></li>
        <li><c:out value="${mea.excess}" /></li>

    </ul>
    <hr/>
    </c:forEach>


    <h2>Создание нового пользователя</h2><br />
    <form method="post" action="">

        <label>input type ="text" name="mealToid"</label>mealToid<br >
        <label>input type ="text" name="dateTime"</label>DateTime<br >
        <label>input type ="text" name="description"</label>Description <br >
        <label>input type ="text" name="calories"</label>Calories <br >
        <label>input type ="text" name="excess"</label>Excess<br >
        <input type="submit" value="OK" name="OK"><br>
        <%--  <form method="POST" action='MealServletNew' name="frmAddmealTo">--%>
        <%--    MealTo Id : <input type="text" readonly="readonly" name="mealToid"--%>
        <%--                       value="<c:out value="${mealTo.id}" />" /> <br />--%>
        <%--    DateTime : <input--%>
        <%--          type="text" name="dateTime"--%>
        <%--          value="<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${mealTo.dateTime}" />" /> <br />--%>
        <%--    Description : <input--%>
        <%--          type="text" name="description"--%>
        <%--          value="<c:out value="${mealTo.description}" />" /> <br />--%>
        <%--    Calories : <input--%>
        <%--          type="text" name="calories"--%>
        <%--          value="<c:out value="${mealTo.calories}" />" /> <br />--%>
        <%--    Excess : <input type="text" name="excess"--%>
        <%--                    value="<c:out value="${mealTo.excess}" />" /> <br /> <input--%>
        <%--          type="submit" value="Submit" />--%>
    </form>
    <p><a href="index.html">Home</a></p>


    <%--    <tr>--%>
    <%--      <td><c:out value="${mea.id}" /></td>--%>
    <%--      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></td>--%>
    <%--      <td><c:out value="${mea.description}" /></td>--%>
    <%--      <td><c:out value="${mea.calories}" /></td>--%>
    <%--      <td><c:out value="${mea.excess}" /></td>--%>
    <%--      <td><a href="MealServletNew?action=edit&mealToId=<c:out value="${mea.id}"/>">Update</a></td>--%>
    <%--      <td><a href="MealServletNew?action=delete&mealToId=<c:out value="${mea.id}"/>">Delete</a></td>--%>
    <%--    </tr>--%>
    <%--  </c:forEach>--%>
    <%--  </tbody>--%>
    <%--</table>--%>
    <%--<p><a href="MealServletNew?action=insert">Add MealTo</a></p> &lt;%&ndash;///что это или как добавить???&ndash;%&gt;--%>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.06.2022
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>