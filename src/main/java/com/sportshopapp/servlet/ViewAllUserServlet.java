package com.sportshopapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.UserReg;


@WebServlet("/ViewAllUsers")
public class ViewAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllUserServlet() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserDAOImpl obj=new UserDAOImpl();
			
			List<UserReg> userList= obj.viewAllUsers();
			HttpSession session=request.getSession();
			session.setAttribute("userList",userList );
			response.sendRedirect("viewAllUsers.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
