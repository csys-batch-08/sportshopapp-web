package com.sportshopapp.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.model.UserReg;

@WebServlet("/UserProfile")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserProfileServlet() {
        super();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session=request.getSession();
			UserReg customers = (UserReg) session.getAttribute("logincustomer");
			session.setAttribute("customer", customers);
			response.sendRedirect("userProfile.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

		doGet(request, response);
	}

}
