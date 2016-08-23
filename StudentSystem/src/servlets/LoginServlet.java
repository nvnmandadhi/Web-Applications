package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao_classes.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	PrintWriter out;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		//String message = "Logout Successful! You can login again below if you wish!";
		
		request.getRequestDispatcher("header.html").include(request, response);
		
		if(action.equals("logout")){
			
			//String username = (String) request.getSession(false).getAttribute("user");
			request.getSession().invalidate();
			/*out.println(username);
			out.println("User logged out");
			out.print(message);*/
			request.getRequestDispatcher("login.html").include(request, response);
		}
		request.getRequestDispatcher("footer.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		boolean status = LoginDAO.validate(email,password);
		
		
		if(status){
			
			HttpSession session = request.getSession(false);
			
			if(session == null){
				System.out.println("Creating a new session");
				request.getSession();
				request.getRequestDispatcher("studentHome.html").include(request, response);
			}else{
				out.println("Can't login again! Would like to logout instead?");
				out.println("<a href=\"/StudentSystem/LoginServlet?action=logout\">Logout</a>");
				
			}
			
		}else{
			out.println("<p>Sorry you are not authorized!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
