<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Report</title>
</head>
<body>
<h3>Expenses: </h3>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allExpenses}" var ="currentitem">
<tr>
	<td><input type="radio" name="id"value="${currentitem.id}" ></td>
	<td>${currentitem.item}</td>
	<td>${currentitem.amount}</td>
	<td>${currentitem.frequency}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>