package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CancelAppointment
 */
@WebServlet("/cancelappointment")
public class CancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentDao appointmentDao;

	
	
	public void init() throws ServletException {

		try {
			appointmentDao = new AppointmentDaoImpl();
		} catch (SQLException e) {

			throw new ServletException("Error in" + getClass(), e);
		}
	}

	
	
	public void destroy() {
		try {
			appointmentDao.cleanup();
		} catch (SQLException e) {

			throw new RuntimeException("Error in" + getClass(), e);
		}
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");

//				take the patientid and appointmentid and current user id match with patient id
		HttpSession session = request.getSession();

		try (PrintWriter pw = response.getWriter()) {

			Patient p = (Patient) (session.getAttribute("patientDetails"));
			System.out.println(p);
			if (p != null) {

//				here call the person 
				int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
//				got the appointment id and now will also have patientid
			int rows =	appointmentDao.CancelAppointment(appointmentId, p.getId());
			if(rows ==1) {
				
				session.setAttribute("message","SuccessFully Cancel the apppointment");
				response.sendRedirect("patientdashboard");
			}
			} else {
				pw.print("<a href='login.html'>please login </a>");

			}

		} catch (Exception e) {
			throw new ServletException("error in " + getClass(), e);
		}

	}

}
