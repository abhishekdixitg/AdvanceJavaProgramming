import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		if ("admin".equals(user) && "admin123".equals(pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user);
			session.setMaxInactiveInterval(300);

			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setHttpOnly(true);
			cookie.setMaxAge(300);
			response.addCookie(cookie);

			String encodedURL = response.encodeRedirectURL("DashboardServlet");
			response.sendRedirect(encodedURL);
		} else {
			out.println("<h3>Login Failed. Try again.</h3>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}
}
