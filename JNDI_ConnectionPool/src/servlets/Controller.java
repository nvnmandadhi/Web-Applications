package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	public Connection conn;
	public DataSource datasource;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			datasource = (DataSource) envContext.lookup("jdbc/JavaUser");
			conn = datasource.getConnection();

			System.out.println(conn);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (action.equals("login")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (action.equals("signup")) {
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("createaccount")) {

			String username = request.getParameter("username");
			System.out.println(username);
			String password = request.getParameter("password");
			System.out.println(password);

			if (!AccountCheck(username, password)) {
				System.out.println("Account with the username exixts!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				AccountCreate(username, password);
				request.getRequestDispatcher("registrationConfirm.jsp").forward(request, response);
			}
		} else if (action.equals("dologin")) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (AccountValidation(username, password)) {
				System.out.println("Login Successful");
				request.getRequestDispatcher("loginSuccessful.jsp").forward(request, response);
			} else {
				System.out.println("Couldn't complete login");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

	private boolean AccountValidation(String username, String password) {

		try {

			String sql = "select * from user where username=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, username);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	private void AccountCreate(String username, String password) {

		try {

			String sql = "insert into user values(?,?)";

			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, username);
			pst.setString(2, password);

			pst.executeUpdate();

			System.out.println("There ya go! User account created!");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private boolean AccountCheck(String username, String password) {

		try {

			String sql = "select * from user where username=? and password=?";

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				rs.close();
				System.out.println("Account exists!");
				return false;

			} else {

				rs.close();
				System.out.println("Accout does not exist!");
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

}
