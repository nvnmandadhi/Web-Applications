package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionProvider {

	static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@infoident.c2qzkkbu36rg.us-west-2.rds.amazonaws.com:1521:ORCL","naveen", "password");
			
			/*Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaUser", "root", "Naveen");*/
			
			System.out.println("DB Connection Successful");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Couldn't get database connection!");
		}
		return conn;
	}
}
