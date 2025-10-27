package com.healthcare.pages;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
 * Servlet implementation class AppointmentsServlet
 */
@WebServlet(value = "/appointments", loadOnStartup = 3)
public class AppointmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentDao appointmentDao;

	@Override
	public void destroy() {
		try {
			appointmentDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			appointmentDao = new AppointmentDaoImpl();
		} catch (Exception e) {
			// to inform WC - about init's failure
			throw new ServletException("err in init " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set reps cont type
		try {
			// get session from WC
			HttpSession session = request.getSession();
			System.out.println("from " + getClass() + " session is new " + session.isNew());
			Patient patient = (Patient) session.getAttribute("patient_details");
			// get req parameters
			String action1 = request.getParameter("action");
			int doctorId = Integer.parseInt(request.getParameter("doc_id"));
			String timeStamp = request.getParameter("appointment_ts");
			System.out.println(timeStamp);// yyyy-MM-ddThh:mm:ss
			Timestamp ts = Timestamp.valueOf(LocalDateTime.parse(timeStamp));
			if (action1.equals("book")) {
				// book appointment- call dao's method
				String message = appointmentDao.bookAppointment(doctorId, patient.getId(), ts);
				// add session scoped attribute
				session.setAttribute("mesg", message);
				response.sendRedirect("patient_dashboard");

			}
		} catch (Exception e) {
			throw new ServletException("err in do post " + getClass(), e);
		}
	}

//http://localhost:8080/day5.1/appointments?action=cancel&id=12
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");
			
			// read req params
			if (action.equals("cancel")) {

				int appointmentId = Integer.parseInt(req.getParameter("id"));
				HttpSession session = req.getSession();
				int patientId = ((Patient) session.getAttribute("patient_details")).getId();
				// call dao's method

				String mesg = appointmentDao.cancelAppointment(appointmentId, patientId);
				session.setAttribute(mesg, mesg);
				resp.sendRedirect("patient_dashboard");
			} else {
				// call dao's method
				HttpSession session = req.getSession();

				resp.sendRedirect("WEB-INF/views/book_appointment");

			}
		} catch (Exception e) {
			throw new ServletException("err in do post " + getClass(), e);
		}

	}

}
