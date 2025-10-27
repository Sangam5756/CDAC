package com.healthcare.pages;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/patientdashboard")
public class PatientDashboard extends HttpServlet {
	private AppointmentDao appointment;

	public void init() throws ServletException {
		try {
			appointment = new AppointmentDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("Error in " + getClass(), e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Patient p = (Patient) session.getAttribute("patientDetails");

		if (p == null) {
			response.sendRedirect("patient_login.jsp");
			return;
		}

		try {
			List<AppointmentDetailsDto> appointments = appointment.DisplayAppointment(p.getId());
			String message = (String) session.getAttribute("message");
			session.removeAttribute("message"); // show once

			request.setAttribute("patient", p);
			request.setAttribute("appointments", appointments);
			request.setAttribute("message", message);

			request.getRequestDispatcher("/WEB-INF/views/patient_dashboard.jsp").forward(request, response);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
