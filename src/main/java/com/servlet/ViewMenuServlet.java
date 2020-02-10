package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MenuDao;
import data.MenuDaoFactory;
import domain.MenuItem;

@WebServlet("")
public class ViewMenuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1951743804810133298L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();

		out.println("<html><body><h1>Ricky's Restaurant</h1>");
		out.println("<h2>Menu</h2><ul>");
		for (MenuItem menuItem : menuItems) {
			out.println("<li>" + menuItem + "</li>");
		}
		out.println("</ul>");
		out.println("<a href='searchResults?searchTerm=veg' >View all of our Veg dishes</a>");
		out.println("</body></html>");
		out.close();
	}

}
