package dao_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sql_date.*;

import db_connection.DBConnectionProvider;

public class RegisterStudentDAO {

	public static int save(String gender, String fname, String lname, String email, String password, String dob, String branch){
		int status = 0;
		
		java.sql.Date sqlDOB = DateFormatter.getSqlDate(dob);
		
		Connection conn = DBConnectionProvider.getConnection();
		PreparedStatement pst = null;
		
		try {
			int id = 0;
			String idSql = "select id_seq.nextval from dual";
			
			pst = conn.prepareStatement(idSql);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				id = rs.getInt(1);
				System.out.println(id);
			}
			
			String sql = "insert into student_user(id,gender,fname,lname,email,password,dob,branch,authorized) values(?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,id);
			pst.setString(2, gender);
			pst.setString(3, fname);
			pst.setString(4, lname);
			pst.setString(5, email);
			pst.setString(6, password);
			pst.setDate(7, sqlDOB);
			pst.setString(8, branch);
			pst.setString(9, "yes");
			
			status = pst.executeUpdate();
			
/*			String idSql1 = "UPDATE STUDENT_USER SET id = id_seq.NEXTVAL";
			
			pst = conn.prepareStatement(idSql1);
			pst.executeUpdate();
*/
			pst.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
		
	}
}
