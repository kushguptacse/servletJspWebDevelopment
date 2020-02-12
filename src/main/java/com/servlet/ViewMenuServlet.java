package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

	public void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();
		request.setAttribute("menuItems", menuItems);
		getServletContext().getRequestDispatcher("/view-menu.jsp").forward(request, response);
	}

}
