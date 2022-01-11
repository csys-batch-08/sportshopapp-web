package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.OderDetails;

public class WalletServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
	    OderDetails order =  new OderDetails();
		System.out.println(order);
		UserDAOImpl UserDaoImpl = new UserDAOImpl();
		try {
			UserDaoImpl.addMoneyWallet(order);
			resp.sendRedirect("UserView.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
