package com.SportsShopApp.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.SportsShopApp.Dao.ProductDao;
import com.SportsShopApp.Dao.UserDao;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("to enter products press 'Y'");
		
		ProductDao prod = new  ProductDao();
		prod.insert();

	
		System.out.println("welcome\n 1)Registration\n 2)Login");
		n = Integer.parseInt(sc.nextLine());

		switch (n) {
		case 1:
		UserDao obj = new UserDao();
		obj.registration();
		UserDao obj1 = new UserDao();
		obj1.login();
		break;
		case 2:
		UserDao obj2 = new UserDao();
		obj2.login();
		break;
		default:
		System.out.println("enter the valid option");
		break;
		

		}
	}

}
