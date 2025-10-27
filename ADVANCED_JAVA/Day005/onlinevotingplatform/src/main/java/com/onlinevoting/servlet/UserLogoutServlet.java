package com.onlinevoting.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.onlinevoting.model.Voter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogoutServlet
 */
@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		
		String status = request.getParameter("status"); 
		Voter voter = (session != null) ? (Voter) session.getAttribute("voter") : null;

		try (PrintWriter pw = response.getWriter()) {
		
			if (voter != null) {
				pw.println("<h3>Hello " + voter.getFirst_name() + " " + voter.getLast_name() + "</h3>");
			}
			
			if ("success".equals(status)) {
				pw.println("<p>You have cast your vote successfully.</p>");
			
			} else if ("alreadyVoted".equals(status)) {
				pw.println("<p>You have already voted.</p>");
			
			} else {
				pw.println("<p>Logged out.</p>");
			}
			pw.print("<a href='login.html'>PLease login</a>");
		}
		if (session != null) {
			session.invalidate();
		}
	}
}
