package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

	public static void main(String[] args) {
		Connection con = null;
		
		String user="sa";
		String password="samtec0553....";
		
		String query;
		query="jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=SALES_SYSTEM";
		
		
		
		
			//query="jdbc:sqlserver://MSSQLSERVER;database=SALES SYSTEM;integratedSecurity=true;";
			
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					con=DriverManager.getConnection(query,user,password);
					System.out.println("Connected");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				try {
					String query1 = "SELECT * FROM EMPLOYEE";
					Statement pst = con.createStatement();
					ResultSet rs = pst.executeQuery(query1);
					int i=1;
					for(i=1; i<rs.getFetchSize();i--) {
					if(rs.next()) {
						System.out.println(rs.getString(i));
						
					}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		// TODO Auto-generated method stub

	}

}
