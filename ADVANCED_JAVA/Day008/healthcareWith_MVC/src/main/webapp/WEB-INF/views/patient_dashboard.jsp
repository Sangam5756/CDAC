<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome, ${patient.name}</h3>

	<c:if test="${not empty message}">
		<p style="color: green;">${message}</p>
	</c:if>

	<h5>Upcoming Appointments</h5>
	<table border="1">
		<thead>
			<tr>
				<th>Appointment ID</th>
				<th>Doctor Name</th>
				<th>Appointment Date</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${appointments}">
				<tr>
					<td>${a.appointment_id}</td>
					<td>${a.docName}</td>
					<td>${a.appointMentDateTime}</td>
					<td><a
						href="cancelappointment?appointmentId=${a.appointment_id}">Cancel</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="logout">Logout</a>
	</p>

</body>
</html>