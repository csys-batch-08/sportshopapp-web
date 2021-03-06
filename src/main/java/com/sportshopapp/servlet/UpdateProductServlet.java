package com.sportshopapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.model.Product;
@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)  {
		
		try {
			int Pid= Integer.parseInt(req.getParameter("pID"));
			String product= req.getParameter("pName");	
			double updateUnitPrice = Double.parseDouble(req.getParameter("price"));
			String category= req.getParameter("pcat");	
			int qty = Integer.parseInt(req.getParameter("pqty"));
			
			Product prod = new Product();
			prod.setProductName(product);
			prod.setProductId(Pid);
			prod.setStrandardCost(updateUnitPrice);
			prod.setCategory(category);
			prod.setQuantity(qty);
			ProductDAOImpl obj =new ProductDAOImpl();
		
			
			boolean flag = false;
			flag = obj.updateProducts(prod);
				 res.sendRedirect("adminView.jsp");
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
