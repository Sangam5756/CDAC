package com.healthcare.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.dto.AppointmentDetailsDto;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/patient_dashboard")
public class Patient_DashboardController extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	init method to initialize the dao layer
	private AppointmentDao appointmentDao;

	public void init() throws ServletException {
		try {
			appointmentDao = new AppointmentDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in " + getClass(), e);
		}

	}

//	here will use the doGet the reason to use that we just want to show the dashboard 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * now here need to check the session of user then retrived the appointments so
		 * now we passed the false because we dont wnat to create new session as if its
		 * not present so we pass false it will not create the session return null
		 * otherwise session
		 */
		HttpSession session = request.getSession(false);
		try {
			System.out.println("inside the patient" + (session == null));
			/*
			 * if check for session is presoent or null now take the patient from the
			 * session
			 */
			if (session != null && session.getAttribute("patient_Details") != null) {
				Patient patient = (Patient) session.getAttribute("patient_Details");

//	now get the appointmentlist for this patient
				List<AppointmentDetailsDto> appointments = new ArrayList<>();
				appointments = appointmentDao.DisplayAppointment(patient.getId());

				request.setAttribute("appointments", appointments);
				request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(request, response);

			} else {
				request.setAttribute("err_msg", "please login to access the dashboard");
				request.getRequestDispatcher("/WEB-INF/jsp/patient_login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException("error in " + getClass(), e);
		}

	}

	public void destroy() {
		try {
			appointmentDao.cleanup();
		} catch (SQLException e) {
			throw new RuntimeException("error in" + getClass(), e);
		}
	}

}
