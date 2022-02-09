package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.UserReg;
@WebServlet("/registerweb")
public class RegisterServlet extends HttpServlet   {
	
	public void service ( HttpServletRequest req, HttpServletResponse res ){
		String userName=req.getParameter("UserName");
		
		String address=req.getParameter("address");
		
		String mail=req.getParameter("UserEmail");
	
		String firstName=req.getParameter("FirstName");
		
		String lastName=req.getParameter("LastName");
		
		long mobile=Long.parseLong(req.getParameter("MobileNumber"));
		
		String password=req.getParameter("UserPassword");
		
		UserReg userModel=new UserReg(userName,address,firstName, lastName,mail,mobile,password);

		UserDAOImpl userDao=new UserDAOImpl();
		userDao.registration(userModel);
	
		try {
			res.sendRedirect("login.jsp");
		} catch (IOException e) {

			e.printStackTrace();
		}
	

	}
}

