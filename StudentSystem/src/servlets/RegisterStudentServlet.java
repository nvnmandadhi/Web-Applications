package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_classes.*;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String gender = request.getParameter("gender");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String branch = request.getParameter("branch");
		
		int status = RegisterStudentDAO.save(gender, fname, lname, email, password, dob, branch);
		
		request.getRequestDispatcher("header.html").include(request, response);
		
		if(status>0){
			out.println("<p>Student Registration Successful!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		}else{
			out.println("<p>Registration not successful!</p>");
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
