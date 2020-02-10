package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeCurrentDateServlet extends HttpServlet {
	private static final long serialVersionUID = -6678464044266343762L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			out.println(
					"<html><body><h1>Hello " + (req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "")
							+ " !!</h1><p>" + new Date() + "</p></body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
