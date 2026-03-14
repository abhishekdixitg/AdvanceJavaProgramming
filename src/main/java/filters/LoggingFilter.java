package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("LoggingFilter destroyed");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ipAdd = request.getRemoteAddr();
		String url = ((HttpServletRequest) request).getRequestURI();
		System.out.println("Incoming request from IP: " + ipAdd + " for URI: " + url);

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("LoggingFilter initialized");
	}
}
