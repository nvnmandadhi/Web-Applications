package util;

import java.sql.*;

public class DB_Connection_Provider {

	static Connection conn = null;

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaUser", "JavaUser", "Naveen");
			System.out.println("Database Connection is successful!");
			
		} catch (Exception e) {

			System.out.println("Unable to get the database connection");
			e.printStackTrace();
		}
		return conn;
	}
}
