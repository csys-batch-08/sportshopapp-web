package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.CartDAOImpl;
import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;
@WebServlet("/removeCartItem")
public class RemovecartItem extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		
		UserDAOImpl user = new UserDAOImpl();
		ProductDAOImpl productDao = new ProductDAOImpl();
		Cart cart = new Cart();
		CartDAOImpl cartdao = new CartDAOImpl();
		Product product = new Product();
		UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
		int removeStatus = 0;
		int CartproductId = Integer.parseInt(req.getParameter("CartproductId"));
		Product currentProduct = null;
		try {
			currentProduct = productDao.findProductById(CartproductId);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		cart.setProduct(currentProduct);
		cart.setUser(currentUser);
		try {
			 try {
				removeStatus=cartdao.removecartItems(cart);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			if(removeStatus>0)
			{
				System.out.println("cartItems deleted");
				res.sendRedirect("userView");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}


}
