package com.sportshopapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.AdminDAOImpl;
import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.Admin;
import com.sportshopapp.model.UserReg;

@WebServlet("/loginweb2")
public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			String userName = req.getParameter("userName");
			String password = req.getParameter("password");
			AdminDAOImpl adminDao = new AdminDAOImpl();

			UserReg userModel = new UserReg(userName, password);

			UserDAOImpl userDao = new UserDAOImpl();
			UserReg customer = new UserReg();
			boolean b1 = false;

			PrintWriter write = res.getWriter();
			if (userName.contains("adminolympus")) {
				do {
					Admin admin;
					admin = adminDao.adlogin(userName, password);
					if (admin == null) {
						write.print("Please enter valid username");
						b1 = true;
					} else {
						res.sendRedirect("adminView.jsp");
						b1 = false;
					}
				} while (b1);
			} else {
				boolean flag1 = true;
				UserReg currentUser = null;
				HttpSession session = req.getSession();
				customer = userDao.viewCurrentUsers(userName);
				session.setAttribute("logincustomer", customer);
				currentUser = userDao.login(userName, password);
				if (currentUser == null) {
					write.print("not a registered user");
					flag1 = false;
				} else {
					res.sendRedirect("UserView");
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
