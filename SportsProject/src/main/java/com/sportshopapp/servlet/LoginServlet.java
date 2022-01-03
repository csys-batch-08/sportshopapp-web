package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sportshopapp.daoimpl.AdminDAOImpl;
import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.AdminModel;
import com.sportshopapp.model.UserRegModel;
@WebServlet("/loginweb1")
public class LoginServlet extends HttpServlet {
	public void service ( HttpServletRequest req, HttpServletResponse res){
		String userName=req.getParameter("UserName");
		String password=req.getParameter("UserPassword");
		AdminDAOImpl adminDao = new AdminDAOImpl ();
		
		UserRegModel userModel=new UserRegModel(userName,password);
	//	System.out.println(userModel);
		UserDAOImpl userDao=new UserDAOImpl();
		boolean b1 = false;
		String logUserName = null;
		String loginPassword = null;
		if (logUserName.contains("adminolympus")) {
		do {
		AdminModel admin = null;
		try {
			admin = adminDao.adlogin(logUserName, loginPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println(admin);
		if (admin == null) {
			try {
				res.sendRedirect("invalid username or password");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		b1 = true;
		} else {
			try {
				res.sendRedirect(" welcome " + admin.getUserName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		b1 = false;
		}
		} while (b1);
		}
		else {
			
			boolean flag1= true;
			UserRegModel currentUser = null;
			try {
				currentUser = userDao.login(logUserName, loginPassword);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(currentUser==null){
				try {
					res.sendRedirect("not a registered uder");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag1 = false;
			}else {
				try {
					res.sendRedirect("welcome"+ currentUser.getFirstName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
