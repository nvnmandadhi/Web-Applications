package servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionTest {

	public static void main(String[] args) {
		
		ConnectionTest obj = new ConnectionTest();
		obj.go();

	}

	private void go() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"+"user=Naveen&password=Naveen");
			System.out.println("Connection Successful");
			
			String sql = "SELECT * FROM login.user where username=? and password=?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, null);
			pst.setString(2, null);
			
			ResultSet rs = pst.executeQuery();
			
			System.out.println(rs.next());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
