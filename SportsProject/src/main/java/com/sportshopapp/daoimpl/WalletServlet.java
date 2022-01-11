package com.sportshopapp.daoimpl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.model.UserReg;
@WebServlet("/walletUpdate")
public class WalletServlet extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		UserReg currentUser = (UserReg) session.getAttribute("user");
		double wallet = Long.parseLong(req.getParameter("UpdateWallet"));
		wallet=wallet+currentUser.getMyWallet();
		UserDAOImpl userDao = new UserDAOImpl();
		int result = 0;
		try {
			result = userDao.addMoneyInWallet(wallet, currentUser);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0)
		{
			res.sendRedirect("UserProfile.jsp");
		}
		
	}
}
