package com.SportsShopApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.SportsShopApp.Connection.Connect;
import com.SportsShopApp.Model.AdminModel;

public class AdminDao {
	public static AdminModel adlogin (String userName, String password ) throws ClassNotFoundException, SQLException
	{	
		
		Connection con = Connect.getDbConnection();
		String query = "select * from admin where user_name='"+userName+"' and password='"+password+"'";
		PreparedStatement stmt = con.prepareStatement(query);
//		stmt.setString(1, adminLog.getUserName() );
//		stmt.setString(2, adminLog.getPassword());
//		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			AdminModel adminLogin = new AdminModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4));
			System.out.println(rs.getString(1));
			
   		return adminLogin;
		}
		return null;
	}
}
