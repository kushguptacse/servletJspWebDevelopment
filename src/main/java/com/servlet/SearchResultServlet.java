package com.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MenuDataService;

public class SearchResultServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			out.println("<html><body><h2>Searched Item</h2>");
			String searchTerm = req.getParameter("searchTerm");
			if (searchTerm == null) {
				out.println("Error!!! Missing search term</body></html>");
			}
			MenuDataService service = new MenuDataService();
			out.println("<ul>");
			service.find(searchTerm).forEach(o -> out.println("<li>" + o + "  " + o.getDescription() + "</li>"));
			out.println("</ul></body></html>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
