package com.servlet;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MenuDao;
import data.MenuDaoFactory;
import domain.MenuItem;

@WebServlet("/searchResults")
public class SearchResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1586871351487889231L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			String searchTerm = req.getParameter("searchTerm");
			if (searchTerm == null) {
				out.println("Error!!! Missing search term");
			}
			MenuDao menuDao = MenuDaoFactory.getMenuDao();
			List<MenuItem> menuItems = menuDao.find(searchTerm);
			req.setAttribute("menuItems", menuItems);
			getServletContext().getRequestDispatcher("/search-results.jsp").forward(req, resp);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
