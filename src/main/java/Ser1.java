

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ser1")
public class Ser1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Date d = new Date(); int h = d.getHours();
		 * 
		 * PrintWriter out = response.getWriter(); out.println(h);
		 */
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response. setContentType("text/html;charset=UTF-8");
		String s =request.getParameter("nam");
		PrintWriter out = response.getWriter();
		FileWriter f = new FileWriter("D:\\Projects\\samples\\lol.txt");
		BufferedWriter b =new BufferedWriter(f);
		b.write(s);
		b.close();
		String x= getServletContext().getInitParameter("phone");
		String e = getServletConfig().getInitParameter("email");
		out.println("<html><body>");
		out.println("<p> WELCOME "+"<b>"+x+"</b>"+"</p>");
		out.println("</body></html>");
		
		
	}

}
