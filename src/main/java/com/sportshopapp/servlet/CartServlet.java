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
import com.sportshopapp.daoimpl.OrderItemsDAOImpl;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;

@WebServlet("/cartserv")
public class CartServlet  extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
		HttpSession session = req.getSession();
	
		
		double totalprice=Double.parseDouble(req.getParameter("cartTotalPrice"));
		int quantity = Integer.parseInt(req.getParameter("cartQuanity"));
	//	double price=Double.parseDouble(req.getParameter("cartPrice"));
	
     	UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
		Product currentproduct = (Product) session.getAttribute("currentproduct");
		CartDAOImpl cartDao = new CartDAOImpl();
		Cart cart = new Cart();
		cart.setUser(currentUser);
		cart.setProduct(currentproduct);
		cart.setQuantity(quantity);
    //    cart.setStandardCost(price);
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
		OrderItemsDAOImpl myOrder= new OrderItemsDAOImpl();
		CartDAOImpl cartDao = new CartDAOImpl();
	
			List<Cart> cartItems = cartDao.viewCart(currentUser);
			
			System.out.println(cartItems.get(0).getProduct().getStrandardCost());
			session.setAttribute("cartItems", cartItems);
			res.sendRedirect("cart.jsp");
}
}
