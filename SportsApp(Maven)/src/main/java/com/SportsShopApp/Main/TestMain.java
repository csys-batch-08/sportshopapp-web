package com.SportsShopApp.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.SportsShopApp.Dao.AdminDao;
import com.SportsShopApp.Dao.CartDao;
import com.SportsShopApp.Dao.ProductDao;
import com.SportsShopApp.Dao.UserDao;
import com.SportsShopApp.Model.AdminModel;
import com.SportsShopApp.Model.CartModel;
import com.SportsShopApp.Model.OderDetailsModel;
import com.SportsShopApp.Dao.OrderDetailDao;
import com.SportsShopApp.Model.OrderItemsModel;
import com.SportsShopApp.Model.ProductModel;
import com.SportsShopApp.Model.UserRegModel;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserDao userDao1 = new UserDao();
		AdminDao adminDao = new AdminDao();
		int n;
		
//		System.out.println("to enter products press 'Y'");
//		
//		ProductDao prod = new  ProductDao();
//		prod.insert();

	
		System.out.println("welcome\n 1)Registration\n 2)Login");
		n = Integer.parseInt(sc.nextLine());

		switch (n) {
		
		case 1:
			
			String userName = null;
			String firstName= null;
			String lastName=null;
			String address =null;
			String mail = null;
			String password =null;
			long phone=0;
			double myWallet=0;
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
			String check=sc.nextLine();
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
			
		    System.out.println(userName);
			UserRegModel reg= new UserRegModel(userName,address,firstName,lastName,mail,phone,password,myWallet);
			UserDao register = new UserDao();
			register.registration(reg);
	
		break;
	
		case 2:
			System.out.println("login page");
			String logUserName = null;
			String loginPassword = null;
			boolean logFlag = false ;
			
			do {
			System.out.println("enter userName and password to login");
			System.out.println("enter userName");
			logUserName = sc.nextLine();
			if (logUserName.matches("[a-zA-Z]+") && logUserName != "") {
				
				flag = false;
				} else {
				flag = true;
				}
				
			} while (logFlag);

			
			boolean loginFlagPswd = false;
			do {
			System.out.println("Enter password");
			loginPassword = sc.nextLine();
			if (loginPassword.matches("[a-zA-Z0-9@#!]+") && loginPassword != "") {
                //System.out.println("valid");
				flag = false;
				} else {
				 System.out.println("enter a valid password");
				flag = true;
				}
			} while (loginFlagPswd);
			boolean b1 = false;
			
			if (logUserName.contains("adminolympus")) {
			do {
			AdminModel admin = adminDao.adlogin(logUserName, loginPassword);
			System.out.println(admin);
			if (admin == null) {
			System.out.println("invalid username or password");
			b1 = true;
			} else {
			System.out.println(" welcome " + admin.getUserName());
			b1 = false;
			}
			} while (b1);
			
			System.out.println("1. Show all products   2. Show all users   3. Add product   4.update Product Details   5.Delete Product ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch (num) {
			case 1 :
				
				ProductDao viewProducts = new  ProductDao();
				List<ProductModel> viewProducts1 = viewProducts.viewAllProducts();
				for(ProductModel ur : viewProducts1) {
					System.out.println(ur.toString());
				}
				break;
				
				
			case 2 :
				
				UserDao allUsers = new  UserDao();
				List<UserRegModel> alluser = allUsers.viewAllUsers();
				for(UserRegModel ur : alluser) {
					System.out.println(ur.toString());
				}
				break;
				
			case 3 :
				System.out.println("to enter products type 'Y'");
				ProductDao prod = new  ProductDao();
				prod.insert();
				break;
				
			case 4 :
				System.out.println("update Products");
				
				System.out.println("Enter Product Id");
				int updateProductId = Integer.parseInt(sc.nextLine());
				System.out.println("Enter product name to be update");
				String updateProductName = sc.nextLine();
				
				System.out.println("enter unitprice to be udpate");
				double updateUnitPrice = Double.parseDouble(sc.nextLine());
				System.out.println("Enter product category to be update");
				String updateProductCategory = sc.nextLine();
				System.out.println("Enter quantity to be update");
				int updateQuantity = Integer.parseInt(sc.nextLine());
				ProductDao update = new ProductDao();
				update.updateProducts(updateProductId, updateProductName, n, updateProductCategory, updateProductId);
				break;
			case 5 :
				System.out.println("to delete products type 'Y'");
				ProductDao prodDelete = new  ProductDao();
				prodDelete.insert();
				break;
			
			}

			}
			else {
				
				boolean flag1= true;
				UserRegModel currentUser = userDao1.login(logUserName, loginPassword);
				if(currentUser==null){
					System.out.println("not a registered uder");
					flag1 = false;
				}else {
					System.out.println("welcome"+ currentUser.getFirstName());
				}
			
				do {
					ProductDao allProduct = new ProductDao();
					
				System.out.println("1. Show All Products    2.Update Account    3.Delete Account");
				int m = Integer.parseInt(sc.nextLine());
				switch (m) {
				case 1:
					
					ProductDao viewProducts = new  ProductDao();
					List<ProductModel> viewProducts1 = viewProducts.viewAllProducts();
					for(ProductModel ur : viewProducts1) {
						System.out.println(ur.toString());
					}
					boolean product = true;
					
					do {
						System.out.println("1.Add products to cart   2.Buy Products  3.View cart   4.My Orders");
						int productChoices = Integer.parseInt(sc.nextLine());

						if (productChoices == 1 || productChoices == 2 || productChoices == 3
								|| productChoices == 4) {
							switch (productChoices) {
							case 1 :
								System.out.println("enter product id");
								int productId = Integer.parseInt(sc.nextLine());
								ProductDao prodId = new ProductDao();
								ProductModel products = prodId.findProductById(productId);
								System.out.println(products.getProductId());
								System.out.println(products.getQuantity());
								int quantity = Integer.parseInt(sc.nextLine());
								double totalPrice = products.getStrandardCost() * quantity;
								
								if (products.getQuantity() >quantity) {
									CartModel cart = new CartModel(currentUser, products, products.getStrandardCost(),totalPrice, quantity);
									CartDao cartDao = new CartDao();
									cartDao.insertProduct(cart);
								}
								break;
							case 2:
								
								List<OrderItemsModel> orderLitemsList = new ArrayList<OrderItemsModel>();
								double sum = 0;
								OderDetailsModel order = new OderDetailsModel();
								ProductModel buyProducts = new ProductModel();
								int buyProductQuantity;
								do {
									System.out.println("enter product id");
								int findProductId = Integer.parseInt(sc.nextLine());
								ProductDao prodDao = new ProductDao();
								buyProducts = prodDao.findProductById(findProductId);
								System.out.println("Enter Quantity");
								buyProductQuantity = Integer.parseInt(sc.nextLine());
								System.out.println(buyProducts.getQuantity() );
								if (buyProducts.getQuantity() >= buyProductQuantity) {
									System.out.println(buyProducts.getQuantity() >= buyProductQuantity);
									if (currentUser.getMyWallet() >= sum) {
										order = new OderDetailsModel(currentUser, sum);
										OrderDetailDao orderDao = new OrderDetailDao();
										System.out.println(currentUser.getUserName() + " " + sum);
										orderDao.orders(currentUser.getUserName(), totalPrice);
									
								break;
							case 3:
								
								break;
							case 4 :
								
								break;
							}
						}
					}while(product);
					
					
				
				
				}
				}while(flag1);
				}
			}
		
			}
		
	
		
//			do {
//				System.out.println("1. Show all products   2. Show all users   3. Add product   4.update Product Details   5.Delete Product ");
		
			
			
//		default:
//		
//		System.out.println("enter the valid option");
//		break;

		
		
//		public static String log() throws ClassNotFoundException, SQLException{
//			
//		}
//	
//	



