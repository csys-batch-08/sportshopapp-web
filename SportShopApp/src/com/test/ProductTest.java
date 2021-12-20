package com.test;

import java.sql.SQLException;

import sportsShopApp.ProductDao;

public class ProductTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
//		System.out.println("to enter the product press'Y'");
//		ProductDao prod = new ProductDao();
//		prod.insert();
		
		System.out.println("to delete the product yes 'Y'");
		ProductDao del = new ProductDao();
		del.delete();
		
		
		

	}

}
