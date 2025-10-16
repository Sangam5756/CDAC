

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class hello
 */
@WebServlet("/greet")
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			
			String name = request.getParameter("name");
			if( name == null || name.isEmpty()) {
				name="Geust";
				
			}
	        String json = "{ \"message\": \"Hello " + name + "! Welcome to Java Servlet API\" }";
			
	        PrintWriter out = response.getWriter();
	        out.print(json);
	        out.flush();
		
		
		}

}
