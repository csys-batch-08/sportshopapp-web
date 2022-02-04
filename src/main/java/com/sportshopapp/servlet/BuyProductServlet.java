package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.OderItemsDAOImpl;
import com.sportshopapp.daoimpl.OrderDetailDAOImpl;
import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;

@WebServlet("/prod1")
public class BuyProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		
		HttpSession session = req.getSession();
		UserDAOImpl user = new UserDAOImpl();
		
		Product product = new Product();
		ProductDAOImpl productDao = new ProductDAOImpl();
		
		OderDetails order = new OderDetails();
		OrderDetailDAOImpl orderDao = new OrderDetailDAOImpl();
			
	
		OrderItems orderItems = new OrderItems();
		OderItemsDAOImpl orderItemsDaoImpl = new OderItemsDAOImpl();
		
		UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
		Product currentproduct = (Product)session.getAttribute("currentproduct");
		System.out.println(currentproduct.getProductName());
		System.out.println(currentproduct.getProductId() + "getprodid");
		
		int qty = Integer.parseInt(req.getParameter("quantity"));
		double price= Double.parseDouble(req.getParameter("totalPrice"));
		

		
		if(currentUser.getMyWallet()>=price)
		{   
			
			
			if(currentproduct.getQuantity()>=qty) {
				
		    
		  
		    
		    try {
		    	int updateQty = currentproduct.getQuantity() - qty;
		    	productDao.updateProductQuantity(currentproduct, updateQty);
		    	System.out.println(currentproduct.getQuantity());
		    	System.out.println(qty);
		    	System.out.println(currentproduct.getQuantity() - qty);
			} catch (ClassNotFoundException e1) {
		
				e1.printStackTrace();
			} catch (SQLException e1) {
	
				e1.printStackTrace();
			}
		    order.setUser(currentUser);
		    orderItems.setUser(currentUser);
		    order.setPrice(price);
		    order.setProducts(currentproduct);
//		    order.getUser().setPoints(order.getUser().getPoints() + (currentproduct.getPoints() * qty));
		    order.getUser().setMyWallet(order.getUser().getMyWallet() - price);
			try {
				orderDao.orders(order,currentUser);
			} catch (ClassNotFoundException e1) {
	
				e1.printStackTrace();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		   
		    try {
				user.updateWalletMoney(order);

			} catch (ClassNotFoundException e3) {

				e3.printStackTrace();
			} catch (SQLException e3) {

				e3.printStackTrace();
			}

			
		    int orderId = 0;
			try {
				System.out.println(orderDao.getByOrderId() +"orderdao");
				orderId = orderDao.getByOrderId();
			} catch (ClassNotFoundException e3) {

				e3.printStackTrace();
			} catch (SQLException e3) {

				e3.printStackTrace();
			}
			order.setOrderId(orderId);
			orderItems.setOderModel(order);
			orderItems.setProduct(currentproduct);
			orderItems.setOrderId(orderId);
			orderItems.getProduct().setProductId(currentproduct.getProductId());
			orderItems.setQuantity(qty);
			orderItems.setUnitPrice(currentproduct.getStrandardCost());
			orderItems.setTotalPrice(price);
			
			
			
				try {
					orderItemsDaoImpl.insertOrders(orderItems);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			

			res.getWriter().println("order placed!!");
			}

			
			
			res.sendRedirect("cart.jsp");

		}
			
			else {
				res.sendRedirect("userView.jsp");
				System.out.println("Current  product is out of stock");
			}
			
		


	
}
}	
	

