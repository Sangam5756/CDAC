<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4 align="center">${requestScope.message}</h4>

	<br />
	<c:url var="url" value="/emps/list" />
	<form method="post" action="${url}">
		<table style="background-color: lightgrey; margin: auto">

			<tr>
				<td>Choose Department</td>
				<td><select name="departmentId">

						<c:forEach var="dept" items="${department_list}">
							<option value="${dept.id}">${dept.deptName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose" /></td>
			</tr>

		</table>
	</form>

	<h5 align="center">
		<c:url var="url" value="/department/add_form" />
		<a href="${url}">Add New Department</a>
	</h5>
</body>
</html>