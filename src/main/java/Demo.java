

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Demo extends HttpServlet {
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
		
		out.println("<html><body>");
		out.println("<p> WELnOME mmnm "+"</p>");
		out.println("</body></html>");
		
		
	}
	

}
