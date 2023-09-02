

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hard-coded values for demonstration purposes
        String validEmail = "user@example.com";
        String validPassword = "password";

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && password != null &&email.equals(validEmail) && password.equals(validPassword)) {
            // Successful login, redirect to dashboard
        	HttpSession session = request.getSession(true); // Create a new session or get the existing one
            session.setAttribute("userEmail", email);
            response.sendRedirect("DashboardServlet");
        } else {
            // Invalid login, show error message
            response.sendRedirect("ErrorPage.html");
        }
    }

}
