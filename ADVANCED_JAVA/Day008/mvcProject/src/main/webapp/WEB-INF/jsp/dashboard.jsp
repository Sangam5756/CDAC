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
					<td>${appointment.appointment_id}</td>
					<td>${appointment.docName}</td>
					<td>${appointment.appointMentDateTime}</td>
					<td><a href="appointments?action=cancel">cancel</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="appointments?action=book">Bookappointment</a>
	<a href="logout">Logout</a>




</body>
</html>