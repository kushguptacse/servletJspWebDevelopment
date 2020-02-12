package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.MenuDao;
import data.MenuDaoFactory;
import domain.Order;

@WebServlet("/orderReceived")
public class OrderReceivedServlet extends HttpServlet {

	private static final long serialVersionUID = 3470816338280531038L;
	private MenuDao menuDao = MenuDaoFactory.getMenuDao();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		int maxId = menuDao.getFullMenu().size();
		Order order = menuDao.newOrder(request.getUserPrincipal().getName());
		for (int i = 1; i <= maxId; i++) {
			String quantity = request.getParameter("item_" + i);
			try {
				int q = Integer.parseInt(quantity);
				if (q > 0)
					menuDao.addToOrder(order.getId(), menuDao.getItem(i), q);
				order.addToOrder(menuDao.getItem(i), q);
			} catch (NumberFormatException nfe) {
				// that's fine it just means there wasn't an order for this item
			}

		}

		HttpSession session = request.getSession();
		session.setAttribute("orderId", order.getId());
		// if cookie is disabled then session id needed to be send in request param
		// which is called url-rewriting.
		// in java this can be done directly by using encode method. encode method
		// append jsession id only if cookie is disabled.
		String url = response.encodeURL("thankYou");
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
