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

public class UserDAOImpl implements UserDaoDAO{
	

	public  void registration(UserReg reg)throws ClassNotFoundException, SQLException
	{
		
		Connection con= ConnectionUtil.getDbConnection();
		String query = "insert into customers_detail(user_name,address, first_name, last_name, email, phone, password)values (?,?,?,?,?,?,?)";
		String commit= "commit";
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setString(1, reg.getUserName());
		stmt.setString(2, reg.getAddress());
		stmt.setString(3, reg.getFirstName());
		stmt.setString(4, reg.getLastName());
		stmt.setString(5, reg.getEmail());
		stmt.setLong(6, reg.getPhone());
		stmt.setString(7, reg.getPassword());
		stmt.executeUpdate();		
		PreparedStatement com= con.prepareStatement(commit);
		com.execute();
	}
	
	public UserReg login( String userName, String password) throws ClassNotFoundException, SQLException {
		
		String query = "select user_name, address, first_name, last_name, phone, password,email, my_wallet from  customers_detail where user_name = '"+userName+"' and password='"+password +"'" ;

		Connection con = ConnectionUtil.getDbConnection();
		ConnectionUtil conn = new ConnectionUtil();
		PreparedStatement pstm = con.prepareStatement(query);
		ResultSet rs = pstm.executeQuery(query);
		UserReg user = null;
		if (rs.next()) {
			user =new  UserReg ();
        return user;
		} 
		else {
			
			
		}
	return null;

	}
	public List<UserReg> viewAllUsers() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt = con.createStatement();
		
		List<UserReg> userList = new ArrayList<UserReg>();
		String view = " SELECT user_name, address, first_name, last_name, phone, password,email, my_wallet FROM customers_detail";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			
			UserReg users = new UserReg(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getLong(5),rs.getString(7),rs.getDouble(8));
			userList.add(users);
	}
		return userList;
	}
	
	public UserReg viewCurrentUsers(String username) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt = con.createStatement();
		UserReg users =new UserReg();
		String view = " SELECT user_name, address, first_name, last_name, phone, password,email, my_wallet FROM customers_detail where user_name='"+username+"'";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			
			 users = new UserReg(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getLong(5),rs.getString(7),rs.getDouble(8));
			
	}
		return users;
	}
	public boolean changepassword(UserReg customer) throws ClassNotFoundException, SQLException {

		Connection con = ConnectionUtil.getDbConnection();
		String query = "update  customers_detail set password = ? where user_name=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, customer.getPassword());
		stmt.setString(2, customer.getUserName());
		stmt.executeUpdate();

		return true;
	}
	
	public void updateWalletMoney(OderDetails order) throws ClassNotFoundException, SQLException
	{
		
		String query="update customers_detail set my_wallet='"+order.getUser().getMyWallet()+"' where user_name = '"+order.getUser().getUserName()+"'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement ps  = con.prepareStatement(query);
			int result = ps.executeUpdate();
			ps.executeUpdate("commit");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

public int addMoneyInWallet(double walletAmount,UserReg currentUser) throws ClassNotFoundException, SQLException {
		
		String walletQuery="update customers_detail set my_wallet ="+walletAmount+" where user_name ='"+currentUser.getUserName()+"'";
		int result=0;
		UserReg user = new UserReg();
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement ps = con.prepareStatement(walletQuery);
			 result=ps.executeUpdate();
			ps.executeUpdate("commit");
			if(result>0)
			{
				UserDAOImpl userDao = new UserDAOImpl();
				currentUser.setMyWallet(walletAmount);
				user.setMyWallet(walletAmount);
			}
			
		} catch (SQLException e) {
		}
		
	return result;
		}

		
	public void addMoneyWallet (OderDetails order) throws ClassNotFoundException, SQLException   {
		String walletQuery= "update customers_detail set my_wallet ="+ order.getUser().getMyWallet() + "where user_name ='" + order.getUser().getUserName()+"'";
		Connection con = ConnectionUtil.getDbConnection();
	
		PreparedStatement pstm = con.prepareStatement(walletQuery);
		pstm.executeUpdate();

	}
	@Override
	public void addMoneyWallet(double walletAmount, UserReg currentUser) throws ClassNotFoundException, SQLException {

	}
	
}

