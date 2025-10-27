package com.healthcare.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/authenticate")
public class PatientLoginController extends HttpServlet {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	init method to initialize the dao layer
	private PatientDao patientDao;

	public void init() throws ServletException {
		try {
			patientDao = new PatientDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in " + getClass(), e);
		}

	}

//	here need to write the login logic
//		so we need to ovverride the our post request as we are getting the data from form
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		here get the form data from the request
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		here we pass this to our dao layer
		try {

			Patient patient = patientDao.patientSignin(email, password);
			if (patient == null) {
				request.setAttribute("err_msg", "invalid credentials please try again");
				request.getRequestDispatcher("/WEB-INF/jsp/patient_login.jsp").forward(request, response);
				return;
			} else {
//				now user is available so create the session and send user to patientDashboard
				HttpSession session = request.getSession();
				session.setAttribute("patient_Details", patient);
//				and redirect to patient dashboard
//	 how by sendRedirect or request dispatcher
//				here will use the sendRedirect 
				response.sendRedirect("patient_dashboard");

			}

		} catch (Exception e) {
			throw new ServletException("error occur" + getClass(), e);
		}

	}

	public void destroy() {
		try {
			patientDao.cleanup();
		} catch (SQLException e) {
			throw new RuntimeException("error in" + getClass(), e);
		}
	}

}
