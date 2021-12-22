package com.SportsShopApp.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.SportsShopApp.Connection.Connect;
import com.SportsShopApp.Model.ProductModel;

public class ProductDao {
	Scanner sc = new Scanner(System.in);

	public void insert() throws ClassNotFoundException, SQLException {
	char check;
	System.out.println("Do You Want Enter Product \n Y /N");
	check = sc.nextLine().charAt(0);
	if (check == 'y' || check == 'Y') {
	System.out.println("Enter the Product Name");
	String pName = sc.nextLine();
	System.out.println("Enter the Product ID");
	int prodId = Integer.parseInt(sc.nextLine());
	System.out.println("Enter the price");
	Double price = Double.parseDouble(sc.nextLine());
	System.out.println("Enter the product category");
	String prodCategory = sc.nextLine();
	
	
	ProductModel str = new ProductModel( pName, prodId, price,prodCategory);
	Connection con= Connect.getDbConnection();
	String query = "insert into product_items values(?,?,?,?)";
	PreparedStatement stmt = con.prepareStatement(query);
	
	stmt.setString(1, str.getProductName());
	stmt.setInt(2, str.getProductId());
	stmt.setDouble(3, str.getStrandardCost());
	stmt.setString(4, str.getCategory());
	stmt.executeUpdate();
	System.out.println("Product Added");
	}

	}

	public void delete() throws ClassNotFoundException, SQLException {
	char check;
	System.out.println("Do You Want delete Product \n Y /N");
	check = sc.nextLine().charAt(0);
	if (check == 'y' || check == 'Y') {
	System.out.println("Enter the Product id");
	int prodId = Integer.parseInt(sc.nextLine());

	Connection con= Connect.getDbConnection();
	ProductModel str = new ProductModel();
	str.setProductId(prodId);
	String query = "delete from  product_items where products_id=?";
	PreparedStatement stmt = con.prepareStatement(query);

	stmt.setInt(1, str.getProductId());
	stmt.executeUpdate();
	System.out.println("Product deleted");
	}
     
	}
	
		public List<ProductModel> viewAllProducts() throws ClassNotFoundException, SQLException {
			
			Connection con = Connect.getDbConnection();
			Statement stmt = con.createStatement();
			
			List<ProductModel> productList = new ArrayList<ProductModel>();
			String view = " SELECT * FROM product_items";
			ResultSet rs = stmt.executeQuery(view);
			while (rs.next()) {
				// System.out.println(rs.getInt(2) + " " + rs.getString(1)+" "+ rs.getInt(3));
				ProductModel product = new ProductModel(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getString(4));
				productList.add(product);
			}
			return productList;
		}
	}
	
	

