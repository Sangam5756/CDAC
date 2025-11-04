<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- import spring supplied form tag library --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Details</title>
</head>

<body>

	<form:form method="post" modelAttribute="emp_details">

		<table style="background-color: lightgrey; margin: auto">
			<caption>Update Employee Details</caption>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input type="email" path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td>Join Date</td>
				<td><form:input type="date" path="joinDate"  /></td>
			</tr>
			<tr>
				<td>Choose Employment Type</td>
				<td><form:radiobuttons path="type" items="${empTypes}"/>
				</td>
			</tr>	
			<tr>
				<td>Salary</td>
				<td><form:input type="number" path="salary" /></td>
			</tr>		
			<tr>
				<td><input type="submit" value="Update Emp Details" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>