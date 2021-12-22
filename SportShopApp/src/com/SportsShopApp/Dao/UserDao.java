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

	public void registration()throws ClassNotFoundException, SQLException
	{
		String userName= null;
		String firstName= null;
		String lastName=null;
		String address =null;
		String mail = null;
		String password =null;
		long phone=0;
		boolean flag ; 
		
		
		
		do {
		System.out.println("Enter User name");
		userName=sc.nextLine();
		if (userName.matches("[A-Za-z]{5,30}+") && userName!="")
		{
			flag = false;
		}
		else {
			System.out.println("Enter valid User name");
			flag=true;
		}
		
		
		}while (flag);
		
		do {
		System.out.println("Enter your city");
		address = sc.nextLine();
		if (address.matches("[A-Za-z]+") && address!="")
		{
			flag = false;
		}
		else {
			System.out.println("Please enter your city");
			flag =true;
		}
		
		}while (flag);
		
		do {
		System.out.println("Enter your first name");
		firstName=sc.nextLine();
		if (firstName.matches("[A-Za-z]+") && firstName!="")
		{
			flag = false;
		}
		else {
			System.out.println("Invalid entry");
			flag=true;
		}
		}while(flag);
		
		do {
		System.out.println("Enter your last name");
		lastName=sc.nextLine();
		if (lastName.matches("[A-Za-z]+") && lastName!="")
		{
			flag = false;
		}
		else {
			System.out.println("Invalid entry");
			flag = true;
		}
		}while(flag);
		
		do {
		System.out.println("Enter your mail ");
		mail = sc.nextLine();
		if (mail.matches("[a-z0-9]+[@][a-z]+[.][a-z]+") && mail!="")
		{
			flag = false;
		}
		else {
			System.out.println("Enter proper mail ID");
			flag=true;
		}
		}while(flag);
		
		
		System.out.println("Enter your phone number");
		String check=sc.next();
		do {
		if (check.matches("[0-9]{10}+") && check!="")
		{
			flag = false;
			phone=Long.parseLong(check);
		}
		else
		{
			System.out.println("Please enter 10 digit mobile number");
			flag = true;
		}
		}while(flag);
		
		do {
		System.out.println("Enter your password");
	    password=sc.nextLine();
	    if(password.matches("[A-Za-z0-9@#!]{8,15}+") && password!="")
	    {
	    	flag=false;
	    }
	    else {
	    	System.out.println("Enter valid password");
	    	flag=true;
	    }
		}while(flag);
		
	    
		UserRegModel str= new UserRegModel(userName,address,firstName,lastName,mail,phone,password);
		Connection con= Connect.getDbConnection();
		String query = "insert into customers_detail(user_name,address, first_name, last_name, email, phone, password)values (?,?,?,?,?,?,?)";
		PreparedStatement stmt= con.prepareStatement(query);
		stmt.setString(1, str.getUserName());
		stmt.setString(2, str.getAddress());
		stmt.setString(3, str.getFirstName());
		stmt.setString(4, str.getLastName());
		stmt.setString(5, str.getEmail());
		stmt.setLong(6, str.getPhone());
		stmt.setString(7, str.getPassword());
		stmt.executeUpdate();
		System.out.println("Register successfull");
	}

	public void login() throws ClassNotFoundException, SQLException {
		System.out.println("enter the username ");
		String username = sc.nextLine();
		System.out.println("enter the password");
		String passname = sc.nextLine();
		UserRegModel str = new UserRegModel();
		str.setUserName(username);
		str.setPassword(passname);
		Connection con = Connect.getDbConnection();
		String query = "select first_name from customers_detail where user_name= ? and password= ? ";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, str.getUserName());
		stmt.setString(2, str.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			System.out.println("welcome " + rs.getString("first_name"));
		} 
		else {
			System.out.println("Incorrect user credential");
			
		}

	}

}
