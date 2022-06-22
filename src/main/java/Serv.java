
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Serv")
public class Serv extends HttpServlet {
	Person p = new Person();

	public Serv() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("ID"));
		String pass = request.getParameter("pass");
		System.out.println(id);
		System.out.println(pass);
		HttpSession session = request.getSession();
		try {
		
			Connection con = (Connection) getServletContext().getAttribute("con");
			String sql = "select * from Hr.persons where ID= ? And PASSWORD= ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.setString(2, pass);

			System.out.println(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				System.out.println(rs.getString("PASSWORD"));
				
				p.setName(rs.getString("FIRST_NAME"));
				p.setId(rs.getInt("ID"));
				session.setAttribute("per", p);
				String admin =rs.getString("IS_ADMIN");
				System.out.println(admin);
				if (admin.equals("y")) {
					RequestDispatcher z = request.getRequestDispatcher("admin.jsp");
					z.forward(request, response);
				}
				else {
				RequestDispatcher z = request.getRequestDispatcher("Welcome");
				z.forward(request, response);
				}
			} else {
				session.setAttribute("per", null);
				RequestDispatcher z = request.getRequestDispatcher("fail.html");
				z.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
//
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Servlet WebController</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>" + "jhjhjh" + "</h1>");
//		out.println("</body>");
//		out.println("</html>");

	}

}
