package com.sportshopapp.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductUpdate  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		doGet(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	{
		int Pid= Integer.parseInt(req.getParameter("pID"));
}
}