//package com.sportshopapp.servlet;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.sportshopapp.daoimpl.UserDAOImpl;
//import com.sportshopapp.model.OderDetails;
//import com.sportshopapp.model.UserReg;
//
//@WebServlet("/addMoney")
//public class WalletServlet extends HttpServlet {
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		double walletMOney= Double.parseDouble(req.getParameter("wallet"));
//		HttpSession session = req.getSession();
//		UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
//
//	    OderDetails order =  new OderDetails();
//	    order.getUser().setMyWallet(currentUser.getMyWallet()+walletMOney);
//		System.out.println(order);
//		UserDAOImpl UserDaoImpl = new UserDAOImpl();
//		try {
//			UserDaoImpl.addMoneyWallet(order);
//			resp.sendRedirect("UserView.jsp");
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.UserReg;
@WebServlet("/addMoney")
public class WalletServlet extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
		double wallet = Long.parseLong(req.getParameter("wallet"));
		wallet=wallet+currentUser.getMyWallet();
		UserDAOImpl userDao = new UserDAOImpl();
		int result = 0;
		try {
			result = userDao.addMoneyInWallet(wallet, currentUser);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(result>0)
		{
			res.sendRedirect("userProfile.jsp");
		}
		
	}
}
