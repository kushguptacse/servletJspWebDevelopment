package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(value = { "/searchResults" })
public class SearchLoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// it will call getParameter of ServletRequest object.
		String searchTerm = request.getParameter("searchTerm");
		SearchLoggingRequestWrapper reqWrapper = new SearchLoggingRequestWrapper((HttpServletRequest) request);
		// we have set newSearchTerm variable only if search string is chook and in this
		// case we changed it to chicken
		if ("chook".equals(searchTerm)) {
			reqWrapper.setNewSearchTerm("chicken");
		}
		System.out.println("Request recieved to search for item : " + searchTerm);
		// now instead of passing ServletRequest we have passed
		// SearchLoggingRequestWrapper.
		// by this way now in servlet class when we call getParameter method.
		// SearchLoggingRequestWrapper.getParameter will get invoked and there we will
		// return NewSearchTerm if field is not null.
		chain.doFilter(reqWrapper, response);
	}

	@Override
	public void destroy() {
	}

}
