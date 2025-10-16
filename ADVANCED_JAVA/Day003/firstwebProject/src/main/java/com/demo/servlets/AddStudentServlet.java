package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PreparedStatement ps;

	public void init() {
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			String name = req.getParameter("name");
			String email = req.getParameter("email");

			ps.setString(1, name);
			ps.setString(2, email);
			int rows = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
