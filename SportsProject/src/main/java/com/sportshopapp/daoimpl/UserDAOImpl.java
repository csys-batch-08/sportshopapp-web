package com.sportshopapp.daoimpl;

import java.sql.Connection;

import com.sportshopapp.dao.UserDaoDAO;
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
		
		System.out.println("Register successfull");
	}
	//String username ;
	public UserReg login( String userName, String password) throws ClassNotFoundException, SQLException {
		
		String query = "select * from  customers_detail where user_name = '"+userName+"' and password='"+password +"'" ;
//		String query = "select user_name from customers_detail where user_name= ? and password= ? ";
		Connection con = ConnectionUtil.getDbConnection();
		ConnectionUtil conn = new ConnectionUtil();
		PreparedStatement pstm = con.prepareStatement(query);
		ResultSet rs = pstm.executeQuery(query);
		UserReg user = null;
	
		
//		int i = -1;
		if (rs.next()) {
			user =new  UserReg ();
        return user;
		} 
		else {
			System.out.println("Incorrect user credential");
			
		}
	return null;

	}
	public List<UserReg> viewAllUsers() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt = con.createStatement();
		
		List<UserReg> userList = new ArrayList<UserReg>();
		String view = " SELECT * FROM customers_detail";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			
			UserReg users = new UserReg(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getLong(5),rs.getString(7),rs.getDouble(8));
			userList.add(users);
	}
		return userList;
	}
	public void addMoneyWallet (double walletAmount, UserReg currentUser) throws ClassNotFoundException, SQLException {
		System.out.println("add money in wallet");
		double addMoney = currentUser.getMyWallet()+walletAmount;
		String walletQuery= "update customer_detail set my_wallet ="+ addMoney + "where user_name ='" + currentUser.getUserName()+"'";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstm = con.prepareStatement(walletQuery);
		pstm.execute();
		System.out.println("Money added to the wallet");
	}
}

