package com.healthcare.pages;

import java.io.IOException;

import com.healthcare.dao.UserDao;
import com.healthcare.dao.UserDaoImpl;
import com.healthcare.entities.User;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet(value = "/auth", loadOnStartup = 1)
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			System.out.println("in init " + getClass());
			// create user dao instance
			userDao=new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		
			userDao=null;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// get rq params - email , password
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// invoke dao's sign in method
			User User = userDao.signIn(email, password);
			// -> not null=> success -> login success mesg
			if (User == null) {
				// invalid login -->error message & forward to JSP with error mesg
				request.setAttribute("err_mesg", "Invalid Email or Password !");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			} else {
				// 1. Get HttpSession from WC
				HttpSession session = request.getSession();
				// 2. save User details under HttpSession
				session.setAttribute("user_details", User);
				// redirect client -> dash board page
				response.sendRedirect("user_dashboard");
			}

		} catch (Exception e) {
			throw new ServletException("err in do-post " + getClass(), e);
		}

	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request, response);
//	}

}
