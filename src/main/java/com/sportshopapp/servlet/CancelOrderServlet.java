package com.sportshopapp.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.OrderDetailDAOImpl;

@WebServlet("/cancelorderserv")
public class CancelOrderServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	String orderid= req.getParameter("orderId");
//	System.out.println(orderid);
	int orderid = Integer.parseInt(req.getParameter("orderId"));
	HttpSession session = req.getSession();
	
	System.out.println(orderid);
	OrderDetailDAOImpl orderDetailDAOImpl = new OrderDetailDAOImpl();
	try {
		orderDetailDAOImpl.deleteProduct(orderid);
//		System.out.println(order);
		
		session.setAttribute("cancelorder", true);
		resp.sendRedirect("MyOrder.jsp");
	} catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
}
}
