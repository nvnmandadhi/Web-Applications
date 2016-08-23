package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_id {
	
	static int nextval;
	
	public static int getNextval(){
		Connection conn = DB_Connection_Provider.getConnection();
		String sql = "select user_id_seq.nextval from dual";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			if(result.next()){
				nextval = result.getInt(1);
				System.out.println(nextval);
			}
		} catch (SQLException e) {
			
			System.out.println("Unable to get user_id");
			e.printStackTrace();
		}
		
		return nextval;
	}
}
