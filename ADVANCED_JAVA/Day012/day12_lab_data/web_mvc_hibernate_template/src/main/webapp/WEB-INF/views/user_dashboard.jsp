<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">Welcome to User Dash Board....</h4>

	<h5>Hello , ${user_details.firstName} ${user_details.lastName}</h5>

	<h4 align="center">
		<a href="logout">Log Out</a>
	</h4>
</body>
</html>