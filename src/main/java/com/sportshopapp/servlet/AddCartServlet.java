package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.CartDAOImpl;
import com.sportshopapp.daoimpl.OrderItemsDAOImpl;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.UserReg;


@WebServlet("/AddCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public AddCartServlet() {
		super();

	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 {
		HttpSession session = request.getSession();
		UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
		CartDAOImpl cartDao = new CartDAOImpl();
		List<Cart> cartItems = cartDao.viewCart(currentUser);
		session.setAttribute("cart", cartItems);
		try {
			response.sendRedirect("CartJst");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
