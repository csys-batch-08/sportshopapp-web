package com.sportshopapp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sportshopapp.daoimpl.OrderItemsDAOImpl;
import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.UserReg;

@WebServlet("/Myorders")
public class MyorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyorderServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
			OrderItemsDAOImpl myOrder = new OrderItemsDAOImpl();
			List<OrderItems> myOrderList = myOrder.ViewMyOrder(currentUser);
			session.setAttribute("myOrderList", myOrderList);
			response.sendRedirect("myOrder.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
