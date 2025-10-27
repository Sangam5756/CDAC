package com.library.controller;

import java.sql.SQLException;

import com.library.dao.UserDao;
import com.library.dao.UserDaoImpl;
import com.library.model.ROLE;
import com.library.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() throws ServletException {
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {

			throw new ServletException("error in " + getClass(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			User user = userDao.loginUser(email, password);

			if (user != null) {

				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				if (user.getRole() == ROLE.STUDENT) {
					response.sendRedirect("StudentDashBoard");
				}
				if (user.getRole() == ROLE.ADMIN) {
					response.sendRedirect("AdminDashBoard");
				}

			} else {
				request.setAttribute("message", "Invalid email or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

}
