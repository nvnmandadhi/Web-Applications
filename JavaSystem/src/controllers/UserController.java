package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LoginBean;
import service.Login;
import service.User;
import service.implementations.LoginImpl;
import service.implementations.UserImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginBean userdelete = new LoginBean(email, password);

		Login user = new LoginImpl();

		boolean authorized = user.authenticateUser(userdelete);

		if (authorized) {

			User obj = new UserImpl();
			
			boolean status = obj.deleteAccount(userdelete);

			if (status) {
				request.getRequestDispatcher("successful.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
	}

}
