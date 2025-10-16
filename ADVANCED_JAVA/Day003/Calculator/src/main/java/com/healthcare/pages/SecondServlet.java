package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println(" in init " + getClass());
	}

	public void destroy() {
		System.out.println(" in Destroy " + getClass());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do get ");
//		first step set the response type 
		response.setContentType("text/html");
//  2nd create the writer for sending the printwriter
//		if want to send the object binary response then use the object

		try (PrintWriter pw = response.getWriter()) {

			pw.print("<h5>Hello From " + getClass() + "@" + LocalTime.now() + "</h5>");

		}

	}

}
