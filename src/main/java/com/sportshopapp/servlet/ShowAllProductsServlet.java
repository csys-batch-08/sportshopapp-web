package com.sportshopapp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.model.Product;


@WebServlet("/ShowAllProduct")
public class ShowAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllProductsServlet() {
        super();
 
    }

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		try {
			ProductDAOImpl obj = new ProductDAOImpl();
			
			  List<Product> viewProducts =obj.viewAllProducts();

			HttpSession session=request.getSession();
			session.setAttribute("viewProduct",viewProducts );

			response.sendRedirect("showAllProducts.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		doGet(request, response);
	}

}
