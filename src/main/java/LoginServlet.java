import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("login.html");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if ("admin".equals(username) && "admin".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute(username, username);
			session.setMaxInactiveInterval(300);

			request.getRequestDispatcher("Welcome.html").include(request, response);

		} else {
			out.println("<h1>Login Failed</h1>");
		}
	}

}
