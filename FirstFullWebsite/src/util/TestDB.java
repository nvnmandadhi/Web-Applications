package util;

import java.sql.Connection;

public class TestDB {

	public static void main(String[] args) {
		
		Connection conn = DB_Connection_Provider.getConnection();
		
		System.out.println(conn.toString());

	}

}
