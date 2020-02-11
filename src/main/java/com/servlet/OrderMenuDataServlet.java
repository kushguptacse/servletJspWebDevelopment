package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MenuDao;
import data.MenuDaoFactory;
import domain.MenuItem;

@WebServlet("/ordermenu")
public class OrderMenuDataServlet extends HttpServlet {

	private static final long serialVersionUID = 9170355760313656038L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		try (PrintWriter out = resp.getWriter()) {

			MenuDao menuDao = MenuDaoFactory.getMenuDao();
			List<MenuItem> menuItems = menuDao.getFullMenu();
			req.setAttribute("menuItems", menuItems);
			getServletContext().getRequestDispatcher("/order-menu.jsp").forward(req, resp);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
