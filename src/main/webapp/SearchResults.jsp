<%@page import="jalasoft.com.models.WordAutoComplete"%>
<%@page import="jalasoft.com.models.Word"%>
<%@page import="java.util.List"%>
<%@ page import="jalasoft.com.models.Task"%>
<%@ page import="jalasoft.com.models.ToDoListPersister"%>
<%@ page import="jalasoft.com.servlets.ListServlet"%>
<%@ page import="jalasoft.com.models.ToDoDictionary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To Do List</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	<h2>Search a Task</h2>
	<hr>

	<%
	ToDoDictionary dictionary = new ToDoDictionary();
	WordAutoComplete completer = new WordAutoComplete();
	List<String> autocomplete = (List<String>) request.getAttribute("autocomplete");
	%>

	<div>
		<form action="search" method=get oninput="search">
			<input type="text" id="wordList" list="words" name="wordToSearch" />
			<datalist id="words">
				<%
				for (String wordAsString : autocomplete) {
				%>
				<option value="<%=wordAsString%>"></option>
				<%
				}
				%>
			</datalist>
			<input type="submit" value="Search" />
		</form>
	</div>



	<h2>
		These are the results for:
		<%=request.getAttribute("result")%></h2>
	<h1>
		<%
		List<Task> resultSet = (List<Task>) request.getAttribute("resultSet");
		%>
	</h1>
	<table style="width: 100%">
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Status</th>
				<th>Initial Date</th>
				<th>Due Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Task task : resultSet) {
			%>
			<tr>
				<td><%=task.getTitle()%></td>
				<td><%=task.getDescription()%></td>
				<td><%=task.getStatus()%></td>
				<td><%=task.getInitialDate().toString()%></td>
				<td><%=task.getDueDate().toString()%></td>
				<td><a
					href="http://localhost:8080/TaskHandler/edit?id=<%=task.getId()%>">Edit</a>
					/ <a
					href="http://localhost:8080/TaskHandler/delete?id=<%=task.getId()%>">Delete</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>