package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		System.out.println(" in init " + getClass());
	}

	public void destroy() {
		System.out.println(" in Destroy " + getClass());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
				
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2= Integer.parseInt(request.getParameter("num2"));
			String action = request.getParameter("action");

			double result=0;
			if(action.equals("add")) {
				
				pw.print("result of addition is  "+(num1+num2));
			}else if(action.equals("subtract")) {
				pw.print("result of addition is  "+(num1-num2));

			}else if(action.equals("multiply")) {
				pw.print("result of addition is  "+(num1*num2));

				
			}else if(action.equals("divide")) {
				result=Math.ceil(num1/num2);
				pw.print("result of addition is  "+result);

			}else {
				System.out.println("Wrong action");
			}
	
		}

	}

}
