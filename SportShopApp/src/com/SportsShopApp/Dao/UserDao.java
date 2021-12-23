package com.SportsShopApp.Dao;

import java.sql.Connection;
import com.SportsShopApp.Model.UserRegModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.SportsShopApp.Connection.Connect;
import com.SportsShopApp.Model.UserRegModel;

public class UserDao {
	Scanner sc = new Scanner(System.in);

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
	String username ;
	public String login(UserRegModel log) throws ClassNotFoundException, SQLException {
		
		Connection con = Connect.getDbConnection();
		String query = "select user_name from customers_detail where user_name= ? and password= ? ";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, log.getUserName());
		stmt.setString(2, log.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			
			String userName = rs.getString("user_name");
			System.out.println("welcome " + rs.getString("first_name"));
		} 
		else {
			System.out.println("Incorrect user credential");
			
		}
		return username;

	}

}

