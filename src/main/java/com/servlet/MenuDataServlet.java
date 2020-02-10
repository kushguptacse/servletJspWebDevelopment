package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.MenuDao;
import data.MenuDaoFactory;

@WebServlet("/menu")
public class MenuDataServlet extends HttpServlet {

	private static final long serialVersionUID = 9170355760313656038L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		try (PrintWriter out = resp.getWriter()) {
			resp.setContentType("text/html");
			out.println(
					"<html><body><h1>Restaurant Menu</h1><h2>Order Your Food</h2><form action='orderReceived' method='POST'>");

			MenuDao menuDao = MenuDaoFactory.getMenuDao();
			out.println("<ul>");
			menuDao.getFullMenu()
					.forEach(o -> out.println("<li>" + o + "<input type='text' name='item_" + o.getId() + "'/></li>"));
			out.println("</ul><input type='submit'/></form></body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
