package com.sportshopapp.daoimpl;

import java.sql.Connection;

import com.sportshopapp.dao.UserDaoDAO;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.UserReg;
import com.sportshopapp.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAOImpl implements UserDaoDAO {

	public void registration(UserReg reg){
		Connection con = null;
		PreparedStatement stmt = null;
     try {
		con = ConnectionUtil.getDbConnection();
		String query = "insert into customers_detail(user_name,address, first_name, last_name, email, phone, password)values (?,?,?,?,?,?,?)";
		String commit = "commit";
		stmt = con.prepareStatement(query);
		stmt.setString(1, reg.getUserName());
		stmt.setString(2, reg.getAddress());
		stmt.setString(3, reg.getFirstName());
		stmt.setString(4, reg.getLastName());
		stmt.setString(5, reg.getEmail());
		stmt.setLong  (6, reg.getPhone());
		stmt.setString(7, reg.getPassword());
		stmt.executeUpdate();
		stmt = con.prepareStatement(commit);
		stmt.execute();
     }catch(Exception e) {
     }finally {
		ConnectionUtil.close(con, stmt);
	}
	}

	public UserReg login(String userName, String password) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
	try {
		String query = "select user_name, address, first_name, last_name, phone, password,email, my_wallet from  customers_detail where user_name = '"
				+ userName + "' and password='" + password + "'";

		con = ConnectionUtil.getDbConnection();
		ConnectionUtil conn = new ConnectionUtil();
		pstm = con.prepareStatement(query);
		rs = pstm.executeQuery(query);
		UserReg user = null;
		if (rs.next()) {
			user = new UserReg();
			return user;
		} else {

		}
	}catch(Exception e) {
	}finally {
		ConnectionUtil.close(con, pstm, rs);
	}
		return null;
	}

	public List<UserReg> viewAllUsers(){
		Connection con = null;
	//	Statement stmt = null;
		PreparedStatement pstm=null;
		List<UserReg> userList = null;
		ResultSet rs = null;
		
	try {
		con = ConnectionUtil.getDbConnection();
//		stmt = con.createStatement();
		userList = new ArrayList<UserReg>();
		String view = " SELECT user_name, address, first_name, last_name, phone, password,email, my_wallet FROM customers_detail";
		pstm=con.prepareStatement(view);
		rs = pstm.executeQuery(view);
		while (rs.next()) {
			UserReg users = new UserReg(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(6), rs.getLong(5), rs.getString(7), rs.getDouble(8));
			userList.add(users);
		}
	}catch(Exception e) {
	}finally {
		ConnectionUtil.close(con, pstm, rs);
	}
		return userList;
	}

	public UserReg viewCurrentUsers(String username) {
		Connection con = null;
	//	Statement stmt = null;
		PreparedStatement pstm =null;
		ResultSet rs =null;
		UserReg users = new UserReg();
		try {
		con = ConnectionUtil.getDbConnection();
//		stmt = con.createStatement();
		
		
		String view = " SELECT user_name, address, first_name, last_name, phone, password,email, my_wallet FROM customers_detail where user_name='"
				+ username + "'";
		pstm = con.prepareStatement(view);
		rs = pstm.executeQuery(view);
		while (rs.next()) {

			users = new UserReg(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6),
					rs.getLong(5), rs.getString(7), rs.getDouble(8));

		}
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, pstm, rs);
		}return users;
		
	}

	public boolean changepassword(UserReg customer) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
		con = ConnectionUtil.getDbConnection();
		String query = "update  customers_detail set password = ? where user_name=?";
		stmt = con.prepareStatement(query);
		stmt.setString(1, customer.getPassword());
		stmt.setString(2, customer.getUserName());
		stmt.executeUpdate();
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, stmt);
		}
		return true;
	}

	public void updateWalletMoney(OderDetails order){
		Connection con =null;
		PreparedStatement ps = null;
          try {
		   String query = "update customers_detail set my_wallet='" + order.getUser().getMyWallet()
				+ "' where user_name = '" + order.getUser().getUserName() + "'";
		    con = ConnectionUtil.getDbConnection();
		
			ps = con.prepareStatement(query);
			int result = ps.executeUpdate();
			ps.executeUpdate("commit");
          }catch(Exception e) {
          }finally {
        	  ConnectionUtil.close(con, ps);
		}

	}

	public int addMoneyInWallet(double walletAmount, UserReg currentUser){
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {

		String walletQuery = "update customers_detail set my_wallet =" + walletAmount + " where user_name ='"
				+ currentUser.getUserName() + "'";
		
		UserReg user = new UserReg();
		con = ConnectionUtil.getDbConnection();
		
			ps = con.prepareStatement(walletQuery);
			result = ps.executeUpdate();
			ps.executeUpdate("commit");
			if (result > 0) {
				UserDAOImpl userDao = new UserDAOImpl();
				currentUser.setMyWallet(walletAmount);
				user.setMyWallet(walletAmount);
			}
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, ps);
		}
		return result;
	}

	public void addMoneyWallet(OderDetails order){
		Connection con = null;
		PreparedStatement pstm = null;
		try {
		String walletQuery = "update customers_detail set my_wallet =" + order.getUser().getMyWallet()
				+ "where user_name ='" + order.getUser().getUserName() + "'";
		con = ConnectionUtil.getDbConnection();

		pstm = con.prepareStatement(walletQuery);
		pstm.executeUpdate();
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, pstm);
		}

	}

	

}
