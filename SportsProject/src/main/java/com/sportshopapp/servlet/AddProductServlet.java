package com.sportshopapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.model.Product;
@WebServlet("/Add")
public class AddProductServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String product= req.getParameter("pname");
		int id = Integer.parseInt("pid");
		double price= Double.parseDouble(req.getParameter("price"));
		String category= req.getParameter("pcat");
		int qty = Integer.parseInt("pqty");
		
		Product products = new Product();
		products.setProductName(product);
		products.setProductId(id);
		products.setStrandardCost(price);
		products.setCategory(category);
		products.setQuantity(qty);
		ProductDAOImpl obj =new ProductDAOImpl();
		 PrintWriter out=res.getWriter();  
		 
		 boolean flag =false;
		try {
			flag = obj.insert();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(flag)
			{
				 out.print("Add product"); 
				 req.getRequestDispatcher("AdminView.jsp").include(req, res);
					
			}
			else
			{
				 out.print("Fail"); 	
				 req.getRequestDispatcher("AdminView.jsp").include(req, res);
	}
}		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}


}
	
