<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.06.2022
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update</title>
</head>
<body>
<section>
  <jsp:useBean id="meals" scope="request" type="ru.javawebinar.topjava.model.MealTo"/>
  <form method="post" action="meals?action=submit">
    <dl>
      <dt>ID: </dt>
      <dd><input type="number" name="id" value="${meals.id}" placeholder="${meals.id}" /></dd>
    </dl>
    <dl>
      <dt>Name: </dt>
      <dd><input type="text" name="name" value="${meals.dateTime}" placeholder="${meals.dateTime}" /></dd>
    </dl>
    <dl>
      <dt>Serial number: </dt>
      <dd><input type="number" name="serial" value="${meals.description}" placeholder="${meals.description}" /></dd>
    </dl>
    <dl>
      <dt>Name: </dt>
      <dd><input type="text" name="name" value="${meals.calories}" placeholder="${meals.calories}" /></dd>
    </dl>
    <dl>
      <dt>Name: </dt>
      <dd><input type="text" name="name" value="${meals.excess}" placeholder="${meals.excess}" /></dd>
    </dl>
    <button type="submit">Save</button>
  </form>
</section>
</body>
</html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
