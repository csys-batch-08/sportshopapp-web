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
import com.sportshopapp.daoimpl.OderItemsDAOImpl;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.UserReg;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
		OderItemsDAOImpl myOrder= new OderItemsDAOImpl();
		CartDAOImpl cartDao = new CartDAOImpl();
		try {
			List<Cart> cartItems = cartDao.viewCart(currentUser);
			session.setAttribute("cart", cartItems);
			response.sendRedirect("CartJst");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}