package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/currenttime")
public class WelcomeCurrentDateServlet extends HttpServlet {
	private static final long serialVersionUID = -6678464044266343762L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getUserPrincipal() != null) {
			req.setAttribute("user", req.getUserPrincipal().getName());
		} 
		req.setAttribute("date", new Date());
		getServletContext().getRequestDispatcher("/time.jsp").forward(req, resp);
	}

}
