package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/authenticate")
public class PatientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PatientDao patientDao;

	public void init() throws ServletException {
		try {
			patientDao = new PatientDaoImpl();
		} catch (SQLException e) {
//			here the the init is overrid method doenst allow to throw exceptiion sql so will throw it using servlet exception by catching
			throw new ServletException("Error in init" + getClass(), e);
		}
	}

	public void destroy() {
		try {
			patientDao.cleanup();
		} catch (SQLException e) {
//			here we can still throw unchecked exception
			throw new RuntimeException("Error in " + getClass(), e);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		set the content type

		response.setContentType("text/html");

//		create the printwriter
		try {

//		get the parameter
			String email = request.getParameter("em");
			String password = request.getParameter("pass");

//		call the patientlogin
			Patient p = patientDao.patientSignin(email, password);
			HttpSession session = request.getSession();
//				but here along with that need to send the cookies
			if (p != null) {

				session.setAttribute("patientDetails", p);

				response.sendRedirect("patientdashboard");
			} else {
				request.setAttribute("err_msg", "invalid credentital please try again");
				request.getRequestDispatcher("/WEB-INF/views/patient_login.jsp").forward(request, response);

			}
//      done
		} catch (Exception e) {
			throw new ServletException("err in do-post " + getClass(), e);
		}

	}

}
