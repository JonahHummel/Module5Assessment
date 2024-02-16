<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expenses</title>
</head>
<body>
<form action = "editExpenseServlet" method="post">
	Expense: <input type="text" name = "item" value ="${itemToEdit.item}"> <br>
	Amount: <input type="number" name ="amount" value ="${itemToEdit.amount}"> <br>
	<input type = "hidden" name = "id" value="${itemToEdit.id}">
	Frequency:
	<select name="frequency">
		<option value="annually" ${itemToEdit.frequency eq 'annually' ? 'selected' : ''}>Annually</option>
        <option value="monthly" ${itemToEdit.frequency eq 'monthly' ? 'selected' : ''}>Monthly</option>
        <option value="weekly" ${itemToEdit.frequency eq 'weekly' ? 'selected' : ''}>Weekly</option>
	</select><br>
	<input type = "submit" value="Save Edited Expense">
</form>
</body>
</html>