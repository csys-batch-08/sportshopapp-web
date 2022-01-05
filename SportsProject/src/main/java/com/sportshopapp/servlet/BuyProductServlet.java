package com.sportshopapp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.OderItemsDAOImpl;
import com.sportshopapp.daoimpl.OrderDetailDAOImpl;

import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;

public class BuyProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		UserReg currentUser = (UserReg)session.getAttribute("user");
		Product currentproduct = (Product)session.getAttribute("currentproduct");
		int qty = Integer.parseInt(req.getParameter("quantity"));
		double price= Double.parseDouble(req.getParameter("totalPrice"));
		OderDetails order = new OderDetails();
		OrderDetailDAOImpl orderDao = new OrderDetailDAOImpl();
		OderItemsDAOImpl orderItemsDaoImpl = new OderItemsDAOImpl();
		
	}

}
