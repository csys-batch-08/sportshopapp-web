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

import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.model.Product;

/**
 * Servlet implementation class ShowAllProducts
 */
@WebServlet("/ShowAllProduct")
public class ShowAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl obj = new ProductDAOImpl();
		System.out.println("Current  product is out of stock 1");
		  try {
			List<Product> viewProducts =obj.viewAllProducts();
		
			HttpSession session=request.getSession();
			session.setAttribute("viewProduct",viewProducts );
		
			response.sendRedirect("ShowAllProducts.jsp");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
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