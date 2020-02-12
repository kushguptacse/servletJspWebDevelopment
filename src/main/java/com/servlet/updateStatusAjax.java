package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import data.MenuDao;
import data.MenuDaoFactory;
import domain.Order;

@WebServlet("/updateStatus")
public class updateStatusAjax extends HttpServlet {
	private static final long serialVersionUID = 6427024196082163969L;
	private MenuDao menuDao = MenuDaoFactory.getMenuDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Long orderId = Long.valueOf(id);
		Order order = menuDao.getOrder(orderId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", order.getStatus());
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		jsonObject.put("time", sdf.format(new Date()));
		PrintWriter out = resp.getWriter();
		out.print(jsonObject.toString());
		out.close();
	}
}
