package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.CartDAOImpl;
import com.sportshopapp.daoimpl.OderItemsDAOImpl;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;

@WebServlet("/cartserv")
public class CartServlet  extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
		HttpSession session = req.getSession();
		System.out.println(req.getParameter("cartTotalPrice"));
	
		
		double totalprice=Double.parseDouble(req.getParameter("cartTotalPrice"));
		int quantity = Integer.parseInt(req.getParameter("cartQuanity"));
     	UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
		Product currentproduct = (Product) session.getAttribute("currentproduct");
		CartDAOImpl cartDao = new CartDAOImpl();
		Cart cart = new Cart();
		System.out.println("currentUser"+currentUser);
		cart.setUser(currentUser);
		System.out.println("currentProduct"+currentproduct);
		cart.setProduct(currentproduct);
		cart.setQuantity(quantity);

		cart.setTotalPrice(totalprice);
		int prodquant ;
		
			prodquant = cartDao.productexist(cart);
		
		if(prodquant < 0) {
		
			
		
			cartDao.insertProduct(cart);
		
		}else {

		
		int	oldprice = cartDao.productexist1(cart);
		
		
		cart.setQuantity(quantity + prodquant);
		cart.setTotalPrice(oldprice + totalprice);
	
			cartDao.updatequantity(cart);
			
		}
		} catch (Exception e) {

			e.printStackTrace();
		}
		HttpSession session=req.getSession();
		UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
		OderItemsDAOImpl myOrder= new OderItemsDAOImpl();
		CartDAOImpl cartDao = new CartDAOImpl();
	
			try {
				List<Cart> cartItems = cartDao.viewCart(currentUser);
				session.setAttribute("cartItems", cartItems);
				res.sendRedirect("cart.jsp");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
	
		
	
}
}
