<%@ page import="jalasoft.com.models.ToDoListPersister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New To Do</title>
<style>
h1 {
	font-family: Arial, sans-serif;
	color: #e61e1e;
	text-align: Center;
	background-color: #1a1919;
}

p {
	font-family: Arial, sans-serif;
	font-size: 14px;
	text-align: default;
	color: #2f2d2d;
}

table {
	width: 70%;
	height: 70%;
	border: 1px none #b3adad;
	border-collapse: collapse;
	padding: 5px;
}

table th {
	border: 1px none #b3adad;
	padding: 5px;
	background: #e12d2d;
	color: #313030;
}

table td {
	border: 1px none #b3adad;
	text-align: center;
	padding: 5px;
	background: #ffffff;
	color: #313030;
}

form {
	margin: 0 auto;
	width: 250px;
}

input[type=button], input[type=submit], input[type=reset] {
  background-color: #04AA6D;
  border: none;
  color: #000;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>
<body>
	<h1>ToDo App</h1>
	<h2>Register new task</h2>
	<hr>

	<form action="register" method="post">
		<table style="with: 100%">
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><select name="status">
						<option value="PENDING">Pending</option>
						<option value="DONE" selected>Complete</option>
				</select></td>
			</tr>
			<tr>
				<td>Initial Date</td>
				<td><input type="date" name="initialDate" /></td>
			</tr>
			<tr>
				<td>Due Date</td>
				<td><input type="date" name="dueDate" /></td>
			</tr>
		</table>
		<input type="submit" value="Save" />
	</form>

</body>
</html>