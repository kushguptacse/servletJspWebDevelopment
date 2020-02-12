package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.MenuDao;
import data.MenuDaoFactory;
import domain.Order;

@WebServlet("/thankYou")
public class ThankYouServlet extends HttpServlet {
	private MenuDao menuDao = MenuDaoFactory.getMenuDao();
	private static final long serialVersionUID = 2037970152616559803L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Long orderId = (Long) session.getAttribute("orderId");
		Double total = menuDao.getOrderTotal(orderId);
		if (total == null) {
			resp.sendRedirect("menu");
		} else {
			ServletContext context = getServletContext();
			req.setAttribute("currency", "USD");
			req.setAttribute("total", total);
			Order order = menuDao.getOrder(orderId);
			req.setAttribute("status", order.getStatus());
			RequestDispatcher reqDispatch = context.getRequestDispatcher("/thank-you.jsp");
			reqDispatch.forward(req, resp);
		}
	}

}
