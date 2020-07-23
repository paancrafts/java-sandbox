package paan.hibernates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HibernateStart {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		    String user      = "root";
		    String password  = "rootpass";
			
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here
		    System.out.println("Connection established!");
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		} finally {
			try{
		           if (conn != null) {
		        	   conn.close();
		           }
		             
			}
			catch(SQLException ex ){
		         System.out.println(ex.getMessage());
			}
		}
		
	}

}
