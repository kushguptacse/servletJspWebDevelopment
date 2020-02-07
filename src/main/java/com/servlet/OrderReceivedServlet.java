package com.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.MenuDataService;

public class OrderReceivedServlet extends HttpServlet {

	private static final long serialVersionUID = 3470816338280531038L;
	MenuDataService menuDataService = new MenuDataService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {

		int maxId = menuDataService.getFullMenu().size();
		for (int i = 0; i < maxId; i++) {
			String quantity = request.getParameter("item_" + i);
			try {
				int q = Integer.parseInt(quantity);
				if (q > 0)
					menuDataService.addToOrder(menuDataService.getItem(i), q);
			} catch (NumberFormatException nfe) {
				// that's fine it just means there wasn't an order for this item
			}

		}

		double total = menuDataService.getOrderTotal();
		HttpSession session = request.getSession();
		session.setAttribute("total", total);
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
