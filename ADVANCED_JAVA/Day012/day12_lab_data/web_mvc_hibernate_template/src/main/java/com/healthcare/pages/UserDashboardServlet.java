package com.healthcare.pages;

import java.io.IOException;

import com.healthcare.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDashboardServlet
 */
@WebServlet(value = "/user_dash")
public class UserDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1. get HttpSession from WC, returns null in case of no existing session
			HttpSession hs = request.getSession(false);
			if (hs != null) {
				request.getRequestDispatcher("/WEB-INF/views/user_dashboard.jsp").forward(request, response);

			} else {
				// => no session found -> redirect the client to the login page, with error mesg
				response.sendRedirect(
						request.getContextPath() + "?message=Login again , after accepting the cookies....");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get " + getClass(), e);
		}
	}

}
