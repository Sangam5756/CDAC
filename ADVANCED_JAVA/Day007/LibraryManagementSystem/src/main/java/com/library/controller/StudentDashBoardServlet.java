// com.library.controller.BookController.java
package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.library.dao.BookDao;
import com.library.dao.BookDaoImpl;
import com.library.model.Book;
import com.library.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StudentDashBoard")
public class StudentDashBoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public void init() throws ServletException {
		try {
			bookDao = new BookDaoImpl();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> books;
		try {
			books = bookDao.getAllBooks();

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			if (user == null) {
				request.setAttribute("message", "please login to access dashboard");
				response.sendRedirect("login.jsp");
			}else {
				

			request.setAttribute("books", books);
			RequestDispatcher rd = request.getRequestDispatcher("/StudentDashBoard.jsp");
			rd.forward(request, response);
		}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}
}
