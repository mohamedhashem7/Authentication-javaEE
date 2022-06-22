

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class users
 */
@WebServlet("/users")
public class users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public users() {
        super();
        // TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession();
		try {
		
			Connection con = (Connection) getServletContext().getAttribute("con");
			String sql = "select * from Hr.persons ";
			PreparedStatement stmt = con.prepareStatement(sql);
		

			System.out.println(sql);

			ResultSet rs = stmt.executeQuery();

			List <String> myList = new ArrayList<>();
			while (rs.next()) {
			            String UniqueId,ClientId,RequestedDateTime,ConnectionStatus;
			            UniqueId = rs.getString("UniqueID");
			            ClientId = rs.getString("ClientId");
			            RequestedDateTime = rs.getString("RequestDateTime");
			            ConnectionStatus = rs.getString("ConnectionStatus");
			            BeanClass beanVar= new BeanClass();
			            beanVar.setUniqueId(UniqueId);
			            beanVar.setClientId(ClientId);
			            beanVar.setConnectionStatus(ConnectionStatus);
			            beanVar.setRequestDateTime(RequestedDateTime);
			            myList.add(beanVar);
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("Display.jsp").forward(request, response);
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
