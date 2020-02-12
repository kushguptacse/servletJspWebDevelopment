package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/thankYou")
public class ThankYouServlet extends HttpServlet {

	private static final long serialVersionUID = 2037970152616559803L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object total = session.getAttribute("total");

		if (total == null) {
			resp.sendRedirect("menu");
		} else {
			ServletContext context = getServletContext();
			req.setAttribute("currency", "USD");
			RequestDispatcher reqDispatch = context.getRequestDispatcher("/thank-you.jsp");
			reqDispatch.forward(req, resp);
		}
	}

}
