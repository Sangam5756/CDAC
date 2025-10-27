package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.dto.AppointmentDetailsDto;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/patientdashboard")
public class PatientDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentDao appointment;

	public void init(ServletConfig config) throws ServletException {
//	here need the patient appointment details using the patient email
		try {
			appointment = new AppointmentDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("Error in " + getClass(), e);
		}
	}

	public void destroy() {
		try {
			appointment.cleanup();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();

		try (PrintWriter pw = response.getWriter()) {

			Patient p = (Patient) (session.getAttribute("patientDetails"));
				String message = (String)session.getAttribute("message");
				System.out.println(message);
			if (p != null) {
				List<AppointmentDetailsDto> allAppointments = appointment.DisplayAppointment(p.getId());

				pw.print("<h3>Hello &nbsp;&nbsp;" + p.getName() + "</h3>");

				pw.println("<h5>Upcomming Appointments</h5>");
				pw.println("<table style='border:2px solid black'>");
				pw.println("<thead style='border:2px solid black'>");
				pw.println("<tr>");

//       headings
				pw.println("<th>Appointment ID</th>");
				pw.println("<th>Doctor Name</th>");
				pw.println("<th>Appointment Date</th>");
				pw.println("<th>Status</th>");
				pw.println("</tr>");
				pw.println("</thead>");
				pw.println("<tbody>");

//       printing the rows
				for (AppointmentDetailsDto a : allAppointments) {
					pw.println("<tr>");

					pw.println("<td>" + a.getAppointment_id() + "</td>");
					pw.println("<td>" + a.getDocName() + "</td>");
					pw.println("<td>" + a.getAppointMentDateTime() + "</td>");

					pw.println("<td>" + "<p><a href='cancelappointment?appointmentId="+a.getAppointment_id()+"'> Cancel</a> </p>" + "</td>");

					pw.println("</tr>");
				}
//        ending the body of table and table itself;
				pw.println("</tbody>");
				pw.println("</table>");
				pw.println("<p><a href='logout'> Logout User</a> </p>");

			} else {
				pw.print("<a href='login.html'> please login session time out</a>");
			}
		} catch (Exception e) {
			throw new ServletException("error in " + getClass(), e);

		}
	}

}
