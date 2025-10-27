package com.onlinevoting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.onlinevoting.dao.VoterDao;
import com.onlinevoting.dao.VoterDaoImpl;
import com.onlinevoting.model.Voter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class VoterLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDao voterDao;

	public void init() throws ServletException {
//		here create the object of VoterDao
		try {
			voterDao = new VoterDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("err in " + getClass(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		first we set the contentType and redirect to the page which directly to the candidateList
//		so if we use redirect then there will be two request first server send location and cookies  status in header and empty response if there's
//		and then browser will also send one request to server with location that we send that will be get request user will go to that page
//		so instead of that we can use request.forward directly forward the   to that site instead browser doing that for me

		response.setContentType("text/html");
//		get the request body parameter email and password
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Voter voter;
		try (PrintWriter pw = response.getWriter()) {

			voter = voterDao.voterLogin(email, password);
			if (voter != null) {

//		create the httpSession
				HttpSession session = request.getSession();

				session.setAttribute("voter", voter);

//		request.getRequestDispatcher("/list").forward(request, response);
				if(voter.getRole().equals("voter")) {
					
				response.sendRedirect("list");
				}else {
					response.sendRedirect("admin");
				}

			} else {
				pw.print("<h5>invalid credentials </h5>");
				pw.print("<a href='login.html'>PLease login</a>");
			}
		} catch (SQLException e) {
			throw new ServletException("error in" + getClass(), e);
		}

	}

	public void destroy() {
		try {
			voterDao.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("error in" + getClass(), e);
		}

	}

}
