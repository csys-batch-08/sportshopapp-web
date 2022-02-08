package com.sportshopapp.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.model.Product;

@WebServlet("/Add")
public class AddProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String product = req.getParameter("pname");
		int id = Integer.parseInt(req.getParameter("prodid"));
		double price = Double.parseDouble(req.getParameter("price"));
		String category = req.getParameter("pcat");
		int qty = Integer.parseInt(req.getParameter("pqty"));
		String img = req.getParameter("pimg");

		Product products = new Product(product, id, price, category, qty, img);
		products.setProductName(product);
		products.setProductId(id);
		products.setStrandardCost(price);
		products.setCategory(category);
		products.setQuantity(qty);
		products.setImg(img);
		ProductDAOImpl obj = new ProductDAOImpl();

		Product currentProduct = null;
		try {
			currentProduct = obj.insert(products);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PrintWriter out = res.getWriter();
		boolean flag = true;
		if (currentProduct != null) {
			out.print("Product added");
			res.sendRedirect("adminView.jsp");
		} else {
			out.print("Failed to add product");
			res.sendRedirect("adminView.jsp");
		}
	}
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			doGet(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
