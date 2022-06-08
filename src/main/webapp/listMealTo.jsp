<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
  <c:forEach items="${mealTos}" var="mea">
    <tr>
      <td><c:out value="${mea.id}" /></td>
      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${mea.dateTime}"/></td>
      <td><c:out value="${mea.description}" /></td>
      <td><c:out value="${mea.calories}" /></td>
      <td><c:out value="${mea.excess}" /></td>
      <td><a href="MealServletNew?action=edit&mealToId=<c:out value="${mea.id}"/>">Update</a></td>
      <td><a href="MealServletNew?action=delete&mealToId=<c:out value="${mea.id}"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="MealServletNew?action=insert">Add MealTo</a></p> <%--///что это или как добавить???--%>
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