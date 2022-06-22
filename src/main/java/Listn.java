

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Listn implements ServletContextListener {

  
    public Listn() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	//PreparedStatement stmt = null;
    	try {
    		
    		         Class.forName("oracle.jdbc.driver.OracleDriver");  
    		         Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
    		          //stmt = con.prepareStatement();
//    		          sce.getServletContext().setAttribute("stmt", stmt);
    sce.getServletContext().setAttribute("con", con);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
