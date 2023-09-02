

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the dashboard page
    	HttpSession session = request.getSession(false); // Get the existing session or return null

        if (session != null && session.getAttribute("userEmail") != null) {
            // User is logged in, show the dashboard
        	 response.setContentType("text/html");
             
             // Prevent caching by setting HTTP headers
             response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
             response.setHeader("Pragma", "no-cache");
             response.setHeader("Expires", "0");
        	String email = (String) session.getAttribute("userEmail");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><head><title>Dashboard</title></head><body>");
            out.println("<h2>Welcome to the Dashboard "+ email + "</h2>");
            out.println("<a href='LogoutServlet'>Logout</a>");
            out.println("</body></html>");
        } else {
            // User is not logged in, redirect to the login page
            response.sendRedirect("index.html");
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
