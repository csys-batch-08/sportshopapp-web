package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.OderItemsDAOImpl;
import com.sportshopapp.daoimpl.OrderDetailDAOImpl;
import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.UserReg;

/**
 * Servlet implementation class MyorderServlet
 */
@WebServlet("/Myorders")
public class MyorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyorderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserReg currentUser = (UserReg)session.getAttribute("logincustomer");
		OrderDetailDAOImpl currentCancelOrder = new OrderDetailDAOImpl();
		OderItemsDAOImpl myOrder= new OderItemsDAOImpl();
		
		try {
			List<OrderItems> myOrderList = myOrder.ViewMyOrder(currentUser);
			session.setAttribute("myOrderList", myOrderList);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		OderItemsDAOImpl cancelOrder= new OderItemsDAOImpl();
		/* int orderId=Integer.parseInt(request.getParameter("orderId")); */
		OrderDetailDAOImpl orderDao=new OrderDetailDAOImpl();
		
		response.sendRedirect("MyOrder.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
