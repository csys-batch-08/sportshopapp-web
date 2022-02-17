package com.sportshopapp.servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductUpdateServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {

		doGet(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	{
		try {
			int Pid= Integer.parseInt(req.getParameter("pID"));
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
}
}