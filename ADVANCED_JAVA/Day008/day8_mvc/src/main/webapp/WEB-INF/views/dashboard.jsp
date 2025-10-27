<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Dashboard</title>
</head>
<body>

	<h5>${requestScope.appointments}</h5>
	<table border="2">
	
		<thead>
			<tr>
				<th>Appointment ID</th>
				<th>Doctor Name</th>
				<th>Appointment Date</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${requestScope.appointments}" var="appointment">

				<tr>
					<td>${appointment.appointmentId}</td>
					<td>${appointment.appointmentTS}</td>
					<td>${appointment.docName}</td>
					<td><a href="appointments?action=book">book</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</body>
</html>