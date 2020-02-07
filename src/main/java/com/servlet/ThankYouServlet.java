package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThankYouServlet extends HttpServlet {

	private static final long serialVersionUID = 2037970152616559803L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			HttpSession session = req.getSession();
			Object total = session.getAttribute("total");
			if (total == null) {
				resp.sendRedirect("menu");
			}
			out.println("<html><body><h1>Ricky's Restaurant</h1>");
			out.println("<h2>Order your food</h2>");
			out.println("Thank you - your order has been received. You need to pay $" + total);

			out.println("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
