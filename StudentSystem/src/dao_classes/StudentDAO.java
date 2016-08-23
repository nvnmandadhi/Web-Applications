package dao_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db_connection.DBConnectionProvider;

public class StudentDAO {

	public static boolean changePassword(String email, String newpassword) {

		Connection conn = DBConnectionProvider.getConnection();

		try {

			String updatePasswordSql = "update student_user set password=? where email=?";

			PreparedStatement pst = conn.prepareStatement(updatePasswordSql);
			pst.setString(1, newpassword);
			pst.setString(2, email);
			int status = pst.executeUpdate();

			if (status > 0) {

				return true;
			}

		} catch (Exception e) {

			System.out.println("Couldn't change password");
			e.printStackTrace();
		}
		return false;
	}

}
