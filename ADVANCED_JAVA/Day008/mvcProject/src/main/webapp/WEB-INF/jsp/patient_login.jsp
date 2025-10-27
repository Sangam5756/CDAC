<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">

	<div class="bg-white p-8 rounded shadow-md w-96">
		<h2 class="text-2xl font-bold mb-6 text-center">Login</h2>
		<c:if test="${err_msg}">

			<h3 class="text-xl font-bold mb-6 text-center text-red-500">${requestScope.err_msg }</h3>
		</c:if>

		<c:if test="${param.msg}">

			<h3 class="text-xl font-bold mb-6 text-center text-red-500">${param.msg}</h3>
		</c:if>

		<form action="authenticate" method="post" class="space-y-4">
			<div>
				<label for="email" class="block text-sm font-medium text-gray-700">Email</label>
				<input type="email" id="email" name="email" required
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded shadow-sm focus:outline-none focus:ring focus:ring-blue-300">
			</div>

			<div>
				<label for="password"
					class="block text-sm font-medium text-gray-700">Password</label> <input
					type="password" id="password" name="password" required
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded shadow-sm focus:outline-none focus:ring focus:ring-blue-300">
			</div>


			<div>
				<button type="submit"
					class="w-full bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-600 transition">
					Login</button>
			</div>

		</form>

		<p class="mt-4 text-center text-sm text-gray-600">
			Don't have an account? <a href="register.jsp"
				class="text-blue-500 hover:underline">Register</a>
		</p>

	</div>


</body>
</html>
