package com.healthcare.pages;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 //  url-pattern / => Global interceptor pattern
@WebServlet(value = "/",loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Centralized Dispatching - Front Controller Pattern
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("Path "+path);
		String viewName = null;
		switch (path) {
		case "/":
			viewName = "/WEB-INF/views/login.jsp";
			break;
		case "/authenticate":
			viewName = "auth";
			break;
		case "/user_dashboard":
			viewName = "user_dash";
			break;						
		case "/logout":
			viewName = "user_logout";
			break;
		default:
			viewName = "/WEB-INF/views/login.jsp";
			break;
		}
		request.getRequestDispatcher(viewName).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
