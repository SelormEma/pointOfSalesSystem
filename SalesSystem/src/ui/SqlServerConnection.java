package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SqlServerConnection {
	
	static Connection con=null;
	
	
	public static Connection Conns() {
		
		
		
		String user="sa";
		String password="samtec0553....";
		
		String query;
		query="jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=SALES_SYSTEM";
		
		
		
		
			//query="jdbc:sqlserver://MSSQLSERVER;database=SALES SYSTEM;integratedSecurity=true;";
			
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con=DriverManager.getConnection(query,user,password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		//JOptionPane.showMessageDialog(null, "Connected");
		//System.out.println("Connected");
				return null;
		
	}
	
	

	
	
	/*
	 * public static void main (String []args) {
	 * 
	 * Connection cons=null; con=SqlServerConnection.Conns();
	 * 
	 * 
	 * 
	 * 
	 * try { String query = "SELECT * FROM EMPLOYEE"; Statement pst =
	 * cons.createStatement(); ResultSet rs = pst.executeQuery(query);
	 * 
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
