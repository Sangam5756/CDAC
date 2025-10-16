package com.healthcare.pages;
//package com.healthcare.pages;

//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * Servlet implementation class PatientDashboard
// */
//@WebServlet("/patientdashboard")
//public class PatientDashboard extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//			
////		crete pw
//		try(PrintWriter pw = response.getWriter()){
//			Cookie[] cookies = request.getCookies();
//			System.err.println(cookies[0].getValue());
////			using the email of the patient we can find the patient and based on that we can find the user details
//			
//			
//			
//			pw.print("Patient DashBoard");
//			
//		}
//	}
//
//}

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PatientDashboard //
 */

@WebServlet("/patientdashboard")
public class PatientDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
//	here need the patient appointment details using the patient email
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

//		crete pw
		try (PrintWriter pw = response.getWriter()) {
			Cookie[] cookies = request.getCookies();
			System.err.println(cookies[0].getValue());
//			using the email of the patient we can find the patient and based on that we can find the user details

			pw.print("Patient DashBoard");

		}
	}

}
