package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_classes.StudentDAO;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String newpassword = request.getParameter("newpassword1");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		boolean status = StudentDAO.changePassword(email,newpassword);
		
		request.getRequestDispatcher("header.html").include(request, response);
		
		if(status){
			out.println("Password changed Successfully!");
			request.getRequestDispatcher("login.html").include(request, response);
		}else{
			out.println("Unable to change password, try again!");
			request.getRequestDispatcher("studentHome.html").include(request, response);
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
	}

}
