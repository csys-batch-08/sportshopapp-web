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
import com.sportshopapp.model.UserReg;


@WebServlet("/UserView")
public class UserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserViewServlet() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProductDAOImpl product= new ProductDAOImpl();
			HttpSession session=request.getSession();
			
	//		UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
			List<Product> productList = product.viewAllProducts();
			session.setAttribute("productList",productList );
			 response.sendRedirect("userView.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
