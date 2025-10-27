<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.library.model.Book "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Books</title>
</head>
<body>


	<h2>Available Books</h2>
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Status</th>

		</tr>
		<%
		List<Book> books = (List<Book>) request.getAttribute("books");
		for (Book b : books) {
		%>
		<tr>
			<td><%=b.getId()%></td>
			<td><%=b.getTitle()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.isAvailable() ? "Available" : "Issued"%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>