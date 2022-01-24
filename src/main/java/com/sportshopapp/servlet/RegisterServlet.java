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
		System.out.println(userName);
		String address=req.getParameter("address");
		System.out.println(address);
		String mail=req.getParameter("UserEmail");
		System.out.println(mail);
		String firstName=req.getParameter("FirstName");
		System.out.println(firstName);
		String lastName=req.getParameter("LastName");
		System.out.println(lastName);
		long mobile=Long.parseLong(req.getParameter("MobileNumber"));
		System.out.println(mobile);
		String password=req.getParameter("UserPassword");
		System.out.println(password);
		
		UserReg userModel=new UserReg(userName,address,firstName, lastName,mail,mobile,password);
		System.out.println(userModel);
		UserDAOImpl userDao=new UserDAOImpl();
		try {
			userDao.registration(userModel);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			res.sendRedirect("Login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
}

