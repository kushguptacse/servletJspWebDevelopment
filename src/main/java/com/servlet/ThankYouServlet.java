package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThankYouServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			out.println("<html><body><h1>Ricky's Restaurant</h1>");
			out.println("<h2>Order your food</h2>");

			out.println("Thank you - your order has been received. You need to pay $" + req.getParameter("total"));

			out.println("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
