import java.sql.*;
import java.util.*;


public class Db {

    public static void main(String[] args){
		conn();
	}
	
	public static Connection conn (){
    Connection con =null;
	try {
//step1 load the driver class  
         Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object  
          con = DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

//step3 create the statement object  
         Statement stmt = con.createStatement();

//         String sql = "insert into COUNTRIES values('" + a + "','" + b + "'," + c + ")";
//         System.out.println(sql);
//         stmt.executeUpdate(sql);

         ResultSet rs = stmt.executeQuery("select * from COUNTRIES where REGION_ID=4");
         while (rs.next()) {
             System.out.println(rs.getString(1));
         }

         con.close();

     } 
    catch (Exception e) {
         System.out.println(e);
     }
return con;
	}}

