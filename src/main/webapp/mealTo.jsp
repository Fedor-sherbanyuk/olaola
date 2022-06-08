<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.06.2022
  Time: 19:53
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
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Add new mealTo</title>
</head>
<body>
<script>
    $(function() {
        $('input[name=dateTime]').datepicker();
    });
</script>

<form method="POST" action='MealServletNew' name="frmAddmealTo">
    MealTo Id : <input type="text" readonly="readonly" name="mealToid"
                     value="<c:out value="${mealTo.id}" />" /> <br />
    DateTime : <input
        type="text" name="dateTime"
        value="<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${mealTo.dateTime}" />" /> <br />
    Description : <input
        type="text" name="description"
        value="<c:out value="${mealTo.description}" />" /> <br />
    Calories : <input
        type="text" name="calories"
        value="<c:out value="${mealTo.calories}" />" /> <br />
    Excess : <input type="text" name="excess"
                   value="<c:out value="${mealTo.excess}" />" /> <br /> <input
        type="submit" value="Submit" />
</form>
<p><a href="index.html">Home</a></p>
</body>
</html>