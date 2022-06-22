
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Person per = new Person();

	public Register() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse
   response) throws ServletException, IOException {
   response.setContentType("text/html;charset=UTF-8");
   
   PrintWriter out = response.getWriter();
   int id =Integer.parseInt(request.getParameter("ID"));
   String pass =request.getParameter("password"); 
   String fname =request.getParameter("Fname"); System.out.println(fname); 
   String lname =request.getParameter("Lastname"); System.out.println(id);
   HttpSession session= request.getSession(); 
   try { Connection conn = (Connection)getServletContext().getAttribute("con");
   String sql ="INSERT INTO HR.PERSONS VALUES ( ?,?,?,?)"; 
   PreparedStatement stmt =conn.prepareStatement(sql); 
   stmt.setInt(1, id); 
   stmt.setString(2,fname);
   stmt.setString(3,lname ); 
   stmt.setString(4,pass );
   
   System.out.println(sql);
   
   int i=stmt.executeUpdate(); 
   System.out.println(i+" records inserted");
   
   RequestDispatcher z = request.getRequestDispatcher("/index.html");
   z.forward(request, response);
   
   //ResultSet rs = stmt.executeQuery();
   
   } 
   catch (Exception e) { System.out.println(e); } // //
//   out.println("<!DOCTYPE html>"); // out.println("<html>"); //
//   out.println("<head>"); //
//   out.println("<title>Servlet WebController</title>"); //
//   out.println("</head>"); // out.println("<body>"); // out.println("<h1>" +
//   "jhjhjh" + "</h1>"); // out.println("</body>"); // out.println("</html>");
   
   }

}
