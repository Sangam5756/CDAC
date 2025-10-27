package com.onlinevoting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.onlinevoting.dao.CandidatesDao;
import com.onlinevoting.dao.CandidatesDaoImpl;
import com.onlinevoting.dto.CandidateNameDto;
import com.onlinevoting.model.Voter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/list")
public class CandidatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatesDao candidateDao;

	public void init() throws ServletException {
		try {
			candidateDao = new CandidatesDaoImpl();

		} catch (SQLException e) {
			throw new ServletException("error in" + getClass(), e);
		}

	}

	public void destroy() {
		try {
			candidateDao.cleanUp();
		} catch (SQLException e) {

			throw new RuntimeException("error in" + getClass(), e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		try (PrintWriter pw = response.getWriter()) {
			Voter voter = (session != null) ? (Voter) session.getAttribute("voter") : null;
			if (voter == null) {
				response.sendRedirect("login.html");
				return;
			}
			List<CandidateNameDto> candidates = candidateDao.listAllCandidatesNames();
			pw.println("<h3>Hello, " + voter.getFirst_name() + " " + voter.getLast_name() + "</h3>");
			pw.println("<ul>");
			for (CandidateNameDto c : candidates) {
				pw.println("<li>" + c.name() + " <a href='vote?candidateId=" + c.id() + "'>Vote</a></li>");
			}
			pw.println("</ul>");
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
