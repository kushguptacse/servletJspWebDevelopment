package com.servlet;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MenuDao;
import data.MenuDaoFactory;

@WebServlet("/searchResults")
public class SearchResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1586871351487889231L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			out.println("<html><body><h2>Searched Item</h2>");
			String searchTerm = req.getParameter("searchTerm");
			if (searchTerm == null) {
				out.println("Error!!! Missing search term</body></html>");
			}
			MenuDao menuDao = MenuDaoFactory.getMenuDao();
			out.println("<ul>");
			menuDao.find(searchTerm).forEach(o -> out.println("<li>" + o + "  " + o.getDescription() + "</li>"));
			out.println("</ul></body></html>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
