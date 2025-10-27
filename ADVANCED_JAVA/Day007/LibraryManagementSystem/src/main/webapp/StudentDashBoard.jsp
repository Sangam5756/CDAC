<%@ page import="com.library.model.Book"%>
<%@ page import="com.library.model.User"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">

	<nav
		class="bg-blue-600 p-4 text-white flex justify-between items-center shadow-md">
		<h1 class="text-xl font-bold">📘 Library Management System</h1>
		<div>
			<a href="logout"
				class="bg-red-500 px-3 py-1 rounded hover:bg-red-600">Logout</a>
		</div>
	</nav>

	<main class="max-w-5xl mx-auto mt-10 p-6 bg-white shadow rounded-lg">

		<h2 class="text-2xl font-semibold mb-6">
			<%
			User user = (User) session.getAttribute("user");
			%>
			Welcome,
			<%=user.getName()%>



		</h2>

		<h3 class="text-lg font-semibold mb-3">Available Books</h3>

		<%
		List<Book> books = (List<Book>) request.getAttribute("books");
		if (books == null || books.isEmpty()) {
		%>
		<div class="text-center text-gray-600 py-10 border rounded">
			<p class="text-lg font-medium">No books available right now 📚</p>
			<p class="text-sm text-gray-500 mt-1">Please check back later or
				contact the librarian.</p>
		</div>
		<%
		} else {
		%>

		<table class="w-full border-collapse">
			<thead>
				<tr class="bg-gray-200 text-left">
					<th class="p-3 border">ID</th>
					<th class="p-3 border">Title</th>
					<th class="p-3 border">Author</th>
					<th class="p-3 border">Available Copies</th>
					<th class="p-3 border">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Book b : books) {
				%>
				<tr class="hover:bg-gray-50">
					<td class="p-3 border"><%=b.getId()%></td>
					<td class="p-3 border"><%=b.getTitle()%></td>
					<td class="p-3 border"><%=b.getAuthor()%></td>
					<td class="p-3 border"><%=b.isAvailable() ? "Available" : "Issued"%></td>
					<td class="p-3 border">
						<form action="issueBook" method="post">
							<input type="hidden" name="bookId" value="<%=b.getId()%>" />
							<button type="submit"
								class="bg-green-500 text-white px-3 py-1 rounded hover:bg-green-600 transition">
								Issue</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<%
		}
		%>
	</main>

</body>
</html>
