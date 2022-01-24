package com.sportshopapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sportshopapp.daoimpl.*;
import com.sportshopapp.model.UserReg;
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {


//		private static final long serialVersionUID = 1L;
//	       
//	    /**
//	     * @see HttpServlet#HttpServlet()
//	     */
//	    public ChangePassword() {
//	        super();
//	        // TODO Auto-generated constructor stub
//	    }
//
//		/**
//		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//		 */
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		    	  String uName=req.getParameter("uname");
				 String Password=req.getParameter("pword");
				 UserReg customer =new UserReg();
				 customer.setUserName(uName);
				 customer.setPassword(Password);
				 UserDAOImpl obj=new  UserDAOImpl();
				 PrintWriter out=resp.getWriter();  
				 try {
					 
					boolean flag= obj.changepassword(customer);
				
					if(flag)
					{
						out.print("Password Change sucessfully");  
						
						 resp.sendRedirect("Login.jsp");
					
					}
					else {
						 out.print("Sorry, username or password error!");  
						
						 resp.sendRedirect("ChangePassword.jsp");
						
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}

	}


