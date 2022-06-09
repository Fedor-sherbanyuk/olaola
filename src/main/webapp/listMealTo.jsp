<%--<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<%--  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">--%>

<%--&lt;%&ndash;<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">&ndash;%&gt;--%>

<%--<html>--%>
<%--<head>--%>
<%--&lt;%&ndash;  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">&ndash;%&gt;--%>
<%--  <title>Show All MealTos</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table border=1>--%>
<%--  <thead>--%>
<%--  <tr>--%>
<%--    <th>MealTo Id</th>--%>
<%--    <th>DateTime</th>--%>
<%--    <th>Description</th>--%>
<%--    <th>Calories</th>--%>
<%--    <th>Excess</th>--%>
<%--    <th colspan=2>Action</th>--%>
<%--  </tr>--%>
<%--  </thead>--%>
<%--  <tbody>--%>
<%--<br/>--%>
<%--  <h2>Все пользователи</h2> <br/>--%>
<%--  <c:forEach var="mea" items="${requestScope.atomicIntegerMealToMap.values()}">--%>
<%--    <ul>--%>
<%--      <li><c:out value="${mea.id}" /></li>--%>
<%--      <li><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></li>--%>
<%--      <li><c:out value="${mea.description}" /></li>--%>
<%--      <li><c:out value="${mea.calories}" /></li>--%>
<%--      <li><c:out value="${mea.excess}" /></li>--%>

<%--    </ul>--%>
<%--    <hr/>--%>
<%--</c:forEach>--%>


<%--    <h2>Создание нового пользователя</h2><br />--%>
<%--<form method="post" action="">--%>

<%--  <label>input type ="text" name="mealTo id"</label>MealTo id<br >--%>
<%--  <label>input type ="text" name="dateTime"</label>DateTime<br >--%>
<%--  <label>input type ="text" name="description"</label>Description <br >--%>
<%--  <label>input type ="text" name="calories"</label>Calories <br >--%>
<%--  <label>input type ="text" name="excess"</label>Excess<br >--%>
<%--  <input type="submit" value="OK" name="OK"><br>--%>
<%--&lt;%&ndash;  <form method="POST" action='MealServletNew' name="frmAddmealTo">&ndash;%&gt;--%>
<%--&lt;%&ndash;    MealTo Id : <input type="text" readonly="readonly" name="mealToid"&ndash;%&gt;--%>
<%--&lt;%&ndash;                       value="<c:out value="${mealTo.id}" />" /> <br />&ndash;%&gt;--%>
<%--&lt;%&ndash;    DateTime : <input&ndash;%&gt;--%>
<%--&lt;%&ndash;          type="text" name="dateTime"&ndash;%&gt;--%>
<%--&lt;%&ndash;          value="<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${mealTo.dateTime}" />" /> <br />&ndash;%&gt;--%>
<%--&lt;%&ndash;    Description : <input&ndash;%&gt;--%>
<%--&lt;%&ndash;          type="text" name="description"&ndash;%&gt;--%>
<%--&lt;%&ndash;          value="<c:out value="${mealTo.description}" />" /> <br />&ndash;%&gt;--%>
<%--&lt;%&ndash;    Calories : <input&ndash;%&gt;--%>
<%--&lt;%&ndash;          type="text" name="calories"&ndash;%&gt;--%>
<%--&lt;%&ndash;          value="<c:out value="${mealTo.calories}" />" /> <br />&ndash;%&gt;--%>
<%--&lt;%&ndash;    Excess : <input type="text" name="excess"&ndash;%&gt;--%>
<%--&lt;%&ndash;                    value="<c:out value="${mealTo.excess}" />" /> <br /> <input&ndash;%&gt;--%>
<%--&lt;%&ndash;          type="submit" value="Submit" />&ndash;%&gt;--%>
<%--  </form>--%>
<%--  <p><a href="index.html">Home</a></p>--%>


<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><c:out value="${mea.id}" /></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><c:out value="${mea.description}" /></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><c:out value="${mea.calories}" /></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><c:out value="${mea.excess}" /></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><a href="MealServletNew?action=edit&mealToId=<c:out value="${mea.id}"/>">Update</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;      <td><a href="MealServletNew?action=delete&mealToId=<c:out value="${mea.id}"/>">Delete</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;  </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;  </tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--&lt;%&ndash;<p><a href="MealServletNew?action=insert">Add MealTo</a></p> &lt;%&ndash;///что это или как добавить???&ndash;%&gt;&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Admin--%>
<%--  Date: 07.06.2022--%>
<%--  Time: 19:00--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ page contentType="text/html;charset=UTF-8" language="java" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <title>Title</title>&ndash;%&gt;--%>
<%--&lt;%&ndash;</head>&ndash;%&gt;--%>
<%--&lt;%&ndash;<body>&ndash;%&gt;--%>

<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>