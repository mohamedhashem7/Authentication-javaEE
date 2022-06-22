
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Welcome() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
		if(session != null) {
			Person p1 = (Person) session.getAttribute("per");
			if(p1 != null) {
				String n =p1.getName();
			
				PrintWriter out = response.getWriter();
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Servlet WebController</title>");
				out.println("</head>");
				out.println("<body>");
				
				out.println("<p>" + "Welcome " +n+ "</p>");
				out.println(" <form action=\"Failed\" method = \"POST\" >");
				out.println("<button type=\"submit\" value=\"Submit\">logout</button>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				
			}
		}else {
			RequestDispatcher z = request.getRequestDispatcher("index.html");
			z.forward(request, response);
		}
	}
}
