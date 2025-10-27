package com.onlinevoting.servlet;

import java.io.IOException;
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

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VoterDao voterDao;

	public void init() throws ServletException {
		try {
			voterDao = new VoterDaoImpl();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		Voter voter = (session != null) ? (Voter) session.getAttribute("voter") : null;
		if (voter == null) {
			resp.sendRedirect("login.html");
			return;
		}
		
		String cid = req.getParameter("candidateId");
		if (cid == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "candidateId required");
			return;
		}
		
		int candidateId;
		try {
			candidateId = Integer.parseInt(cid);
		} catch (NumberFormatException ex) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid candidateId");
			return;
		}

		try {
			int ok = voterDao.voteCandidate(voter.getId(), candidateId); 
			System.out.println(ok);
			if (ok == 0) {
				resp.sendRedirect("logout?status=alreadyVoted");
			} else {
				resp.sendRedirect("logout?status=success");
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
