import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			out.println("<h3>Session expired. Please <a href='login.html'>login</a> again.</h3>");
		} else {
			String user = (String) session.getAttribute("username");
			out.println("<h2>Welcome, " + user + "!</h2>");
			out.println("<a href='LogoutServlet'>Logout</a>");
		}
	}
}
