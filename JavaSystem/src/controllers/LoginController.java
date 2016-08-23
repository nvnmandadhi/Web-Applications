package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.LoginBean;
import service.Login;
import service.implementations.LoginImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter out;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("logout")) {
			request.getSession().invalidate();
			request.getRequestDispatcher("successful.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		LoginBean newuserlogin = new LoginBean(email, password);

		Login authenticate = new LoginImpl();

		boolean isAuthorized = authenticate.authenticateUser(newuserlogin);

		if (isAuthorized) {

			HttpSession session = request.getSession(false);
			
			System.out.println(session);

			if (session == null) {

				System.out.println("Creating new user session");
				session = request.getSession();
				session.setAttribute("user", newuserlogin);
				request.getRequestDispatcher("userHome.jsp").forward(request, response);
			} else {
				out = response.getWriter();
				response.setContentType("text/html");
				out.println("You're already logged in<br>");
				out.println("<a href=\"userHome.jsp\">Goto MyHomePage</a>");
				out.println("<a href=\"/JavaSystem/LoginController?action=logout\">Logout</a>");
			}

		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
