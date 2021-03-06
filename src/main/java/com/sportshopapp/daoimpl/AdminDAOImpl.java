package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sportshopapp.dao.AdminDAO;
import com.sportshopapp.model.Admin;
import com.sportshopapp.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO {
	public Admin adlogin(String userName, String password) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			String query = "select user_name,password,email,mobile from admin where user_name= ? and password= ?";

			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Admin adminLogin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4));
				return adminLogin;

			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt, rs);
		}
		return null;
	}

}
