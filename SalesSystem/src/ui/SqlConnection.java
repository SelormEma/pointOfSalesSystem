package ui;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
	

	public static Connection Conn(){
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			//String a = Admin.class.getResource("/ui/images-2.png");
			//String url = "jdbc:sqlite:" + Admin.class.getResource("/ui/CHEMUNAA.db")+"";
			String url = "jdbc:sqlite:C:/PERSONAL PROJECTS/SalesSystem/Sales.db";
			Connection conn = DriverManager.getConnection(url);
			
			System.out.println("Database Connected");
			
			//JOptionPane.showMessageDialog(null, "Database Connected");
			
			return conn;
		}
		catch(Exception e) {
			return null;
		}
		
	}
}
