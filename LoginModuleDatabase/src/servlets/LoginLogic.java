package servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;;

public class LoginLogic {

	public Boolean validate(String username, String password) {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?"+"user=Naveen&password=Naveen");

			String sql = "SELECT count(*) as count FROM login.user where username=? and password=?";

			PreparedStatement pst = conn.prepareStatement(sql+";");

			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			int count =0;
			
			if(rs.next()){
				count = rs.getInt("count");
			}
			rs.close();
			
			if(count == 0){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
