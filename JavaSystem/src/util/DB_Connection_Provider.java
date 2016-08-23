package util;

import java.sql.*;

public class DB_Connection_Provider {

	static Connection conn = null;

	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@infoident.c2qzkkbu36rg.us-west-2.rds.amazonaws.com:1521:ORCL", "naveen", "password");
			System.out.println("Database Connection is successful!");
			
		} catch (Exception e) {

			System.out.println("Unable to get the database connection");
			e.printStackTrace();
		}
		return conn;
	}
}
