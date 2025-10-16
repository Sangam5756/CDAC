package com.healthcare.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PatientLoginServlet
 */
@WebServlet("/authenticate")
public class PatientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}




	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

	}




	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
