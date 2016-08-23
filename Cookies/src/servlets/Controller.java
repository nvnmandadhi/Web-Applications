package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		out.println("<html>");

		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			out.println("No Cookies found! </br>");
		} else {
			for (Cookie reCookie : cookies) {

				String name = reCookie.getName();
				String value = reCookie.getValue();

				out.println("Cookie name : " + name);
				out.println("</br>");
				out.print("Cookie value : " + value);
				out.println("</br>");
			}
		}
		Cookie cookie = new Cookie("user", "Naveen");
		
		cookie.setMaxAge(300);
		
		response.addCookie(cookie);
		
		out.println("Cookie set! <br/>");
		
		out.print("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
