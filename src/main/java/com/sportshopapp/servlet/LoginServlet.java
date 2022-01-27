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
@WebServlet("/loginweb1")
public class LoginServlet extends HttpServlet {
	public void service ( HttpServletRequest req, HttpServletResponse res) throws IOException{
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		AdminDAOImpl adminDao = new AdminDAOImpl ();
		
		UserReg userModel=new UserReg(userName,password);
	//	System.out.println(userModel);
		UserDAOImpl userDao=new UserDAOImpl();
		UserReg customer = new UserReg();
		boolean b1 = false;
	
//		String loginPassword = null;
		PrintWriter write=res.getWriter();
		if (userName.contains("adminolympus")) {
		do {
		Admin admin = null;
		try {
			admin = adminDao.adlogin(userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println(admin);
		if (admin == null) {
			write.print("Please enter valid username");
		b1 = true;
		} else {
			res.sendRedirect("AdminView.jsp");
		b1 = false;
		}
		} while (b1);
		}
		else {
			
			boolean flag1= true;
			UserReg currentUser = null;
			try {
				 HttpSession session=req.getSession();  
				     customer=userDao.viewCurrentUsers(userName);
				 //    System.out.println(customer);
			        session.setAttribute("logincustomer", customer); 
				currentUser = userDao.login(userName, password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(currentUser==null){
				write.print("not a registered user");
				flag1 = false;
			}else {
				res.sendRedirect("UserView");
			}
		
	}

	}
}
//		try {
//			boolean b1 = false;
//			String logUserName = null ;
//			String loginPassword = null;
//			AdminDAOImpl adminDao = new AdminDAOImpl ();
//			if (logUserName.contains("adminolympus")) {
//			do {
//			AdminModel admin = null;
//			try {
//				admin = adminDao.adlogin(logUserName, loginPassword);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(admin);
//			   if (admin == null) {
//			   try {
//				res.sendRedirect("invalid username or password");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    	b1 = true;
//		    	} else {
//		    	try {
//					res.sendRedirect(" welcome " + admin.getUserName());
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		     	b1 = false;
//		    	}
//			} while (b1);
//			try {
//				userModel=userDao.login(userName, password);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			}
//			else if(userModel==null) {
//				try {
//					res.sendRedirect("invalid customer");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			else {
//				try {
//					res.sendRedirect("CustomerView.jsp");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
