package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sportshopapp.dao.AdminDAO;
import com.sportshopapp.model.Admin;
import com.sportshopapp.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO{
	public  Admin adlogin (String userName, String password ) throws ClassNotFoundException, SQLException
	{	
		
		Connection con = ConnectionUtil.getDbConnection();
		String query = "select * from admin where user_name='"+userName+"' and password='"+password+"'";
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			Admin adminLogin = new Admin(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4));
			System.out.println(rs.getString(1));
			
   		return adminLogin;
		}
		return null;
	}
}
