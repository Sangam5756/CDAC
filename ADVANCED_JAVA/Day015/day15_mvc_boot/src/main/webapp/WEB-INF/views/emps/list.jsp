<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department's Employee List</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Employees from Department ID ${param.departmentId}</caption>
		<tr>
			<th>Name</th>
			<th>Employment Type</th>
			<th>Join Date</th>
			<th>Salary</th>
			<th>Last Updated</th>
			<th>Action</th>
			<th>Action</th>
		</tr>

		<c:forEach var="emp" items="${emp_list}">
			<tr>
				<td>${emp.firstName}${emp.lastName}</td>
				<td>${emp.type}</td>
				<td>${emp.joinDate}</td>
				<td>${emp.salary}</td>
				<td>${emp.lastUpdated}</td>
				<c:url var="url" value="/emps/delete?id=${emp.id}" />
				<c:url var="img" value="/images/delete.png" />
				<td><a href="${url}"><img src="${img}" width="20"
						height="20" /></a></td>
				<c:url var="url" value="/emps/update?id=${emp.id}" />
				<c:url var="img" value="/images/edit.png" />
				<td><a href="${url}"><img src="${img}" width="20"
						height="20" /></a></td>
			</tr>
		</c:forEach>
	</table>

	<c:url var="url" value="/emps/add" />
	<h5 align="center">
		<a href="${url}">Add New Employee</a>
	</h5>





</body>
</html>