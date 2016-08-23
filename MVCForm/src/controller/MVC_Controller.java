package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class MVC_Controller
 */
@WebServlet("/MVC_Controller")
public class MVC_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MVC_Controller() {
		super();
		// TODO Auto-generated constructor stub
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
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "enter fields in the required format");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (action.equals("dologin")) {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			
			User obj = new User(email,password);
			
			if(obj.validate()){
				request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
			}else{
				
				request.setAttribute("message", obj.getMessage());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
			}
		}
	}

}
