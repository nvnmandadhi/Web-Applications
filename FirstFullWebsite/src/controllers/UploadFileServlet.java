package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.DB_Connection_Provider;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(maxFileSize = 20000000)
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double song_id = Math.random();
		
		song_id = song_id*100;
		
		conn = DB_Connection_Provider.getConnection();
		Part song = request.getPart("song");
		
		String sql = "insert into songs values(?,?)";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if(song != null){
				InputStream is = song.getInputStream();
				
				if(is != null){
					pst.setDouble(1, song_id);
					pst.setBinaryStream(2, is, song.getSize());
					pst.executeUpdate();
				}
			}
		} catch (SQLException e) {
			
			System.out.println("Error uploading File");
			e.printStackTrace();
		}
		
	}

}
