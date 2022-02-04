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



		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
						
						 resp.sendRedirect("login.jsp");
					
					}
					else {
						 out.print("Sorry, username or password error!");  
						
						 resp.sendRedirect("changePassword.jsp");
						
					}
					
				} catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}
				
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		}

	}


