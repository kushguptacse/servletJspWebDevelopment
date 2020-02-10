package com.servlet.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SearchLoggingRequestWrapper extends HttpServletRequestWrapper {

	private String newSearchTerm;

	public SearchLoggingRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {
		if (key.equalsIgnoreCase("searchTerm") && newSearchTerm != null && !newSearchTerm.isEmpty()) {
			return newSearchTerm;
		}
		return super.getParameter(key);
	}

	/**
	 * @param newSearchTerm the newSearchTerm to set
	 */
	public void setNewSearchTerm(String newSearchTerm) {
		this.newSearchTerm = newSearchTerm;
	}

}
