package dao_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db_connection.DBConnectionProvider;

public class LoginDAO {

	public static boolean validate(String email, String password) {
		
		Connection conn = DBConnectionProvider.getConnection();
		PreparedStatement pst= null;
		boolean status = false;
		
		try {
			
			String sql = "select * from student_user where email=? and password=? and authorized=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, "yes");
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				status = true;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}

}
