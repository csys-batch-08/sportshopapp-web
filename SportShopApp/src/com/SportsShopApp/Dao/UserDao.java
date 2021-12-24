package com.SportsShopApp.Dao;

import java.sql.Connection;
import com.SportsShopApp.Model.UserRegModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.SportsShopApp.Connection.Connect;
import com.SportsShopApp.Model.UserRegModel;

public class UserDao {
	

	public static void registration(UserRegModel reg)throws ClassNotFoundException, SQLException
	{
		
		Connection con= Connect.getDbConnection();
		String query = "insert into customers_detail(user_name,address, first_name, last_name, email, phone, password)values (?,?,?,?,?,?,?)";
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setString(1, reg.getUserName());
		stmt.setString(2, reg.getAddress());
		stmt.setString(3, reg.getFirstName());
		stmt.setString(4, reg.getLastName());
		stmt.setString(5, reg.getEmail());
		stmt.setLong(6, reg.getPhone());
		stmt.setString(7, reg.getPassword());
		stmt.executeUpdate();
		System.out.println("Register successfull");
	}
	//String username ;
	public static int login(UserRegModel log) throws ClassNotFoundException, SQLException {
		
		Connection con = Connect.getDbConnection();
		String query = "select user_name from customers_detail where user_name= ? and password= ? ";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, log.getUserName());
		stmt.setString(2, log.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		int i = -1;
		if (rs.next()) {
			i = 1;
			String userName = rs.getString("user_name");
			System.out.println("welcome " + rs.getString(1));
		} 
		else {
			System.out.println("Incorrect user credential");
			
		}
	return i;

	}
	public List<UserRegModel> viewAllUsers() throws ClassNotFoundException, SQLException {
		Connection con = Connect.getDbConnection();
		Statement stmt = con.createStatement();
		
		List<UserRegModel> userList = new ArrayList<UserRegModel>();
		String view = " SELECT * FROM customers_detail";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			
			UserRegModel users = new UserRegModel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getLong(5),rs.getString(7));
			userList.add(users);
	}
		return userList;
	}
}

