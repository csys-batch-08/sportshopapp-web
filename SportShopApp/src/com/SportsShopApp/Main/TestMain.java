package com.SportsShopApp.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.SportsShopApp.Dao.ProductDao;
import com.SportsShopApp.Dao.UserDao;
import com.SportsShopApp.Model.UserRegModel;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		
//		System.out.println("to enter products press 'Y'");
//		
//		ProductDao prod = new  ProductDao();
//		prod.insert();

	
		System.out.println("welcome\n 1)Registration\n 2)Login");
		n = Integer.parseInt(sc.nextLine());

		switch (n) {
		
		case 1:
			
			String userName;
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
			UserRegModel reg= new UserRegModel(userName,address,firstName,lastName,mail,phone,password);
			UserDao register = new UserDao();
			register.registration(reg);
	
		break;
	
		case 2:
			System.out.println("login page");
			String logUserName = null;
			boolean logFlag = true;
			System.out.println("enter userName and password to login");
			do {

			System.out.println("enter userName");
			logUserName = sc.nextLine();
			if (logUserName.matches("[a-z][a-z0-9]*[@][a-z]+[.][A-Za-z]{2,3}")) {
			logFlag = false;
			logUserName = logUserName.toLowerCase();
			} else
			System.out.println("email format should be in xyz@abc.com");
			} while (logFlag);

			String loginPassword = null;
			boolean loginFlagPswd = true;
			do {
			System.out.println("Enter password");
			loginPassword = sc.nextLine();
			if (loginPassword
			.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
			loginFlagPswd = false;
			// System.out.println(password);
			} else {
			System.out.println("password must have 8 to 15 characters only \n"
			+ " contains one upper case, one lower case, one number , one special character");
			}

			} while (loginFlagPswd);
			boolean b1 = true;

			if (logUserName.endsWith("medhub.com")) {
			do {
			AdminModel admin = adminDao.login(loginEmail, loginPassword);

			if (admin == null) {
			System.out.println("invalid username or password");
			b1 = true;
			} else {
			System.out.println(" welcome " + admin.getAdminName());
			b1 = false;
			}
			} while (b1);
			   boolean adminChoice = true;
			
//			boolean logFlag = false;
//			
//			String logUserName;
//			String passname;
//			do {
//			System.out.println("Enter the userName");
//			userName = sc.nextLine();
//			if (userName.matches("[a-zA-Z]+") && userName != "") {
//			
//			flag = false;
//			} else {
//			
//			flag = true;
//			}
//			} while (flag);
//			do {
//			System.out.println("Enter the password");
//			passname = sc.nextLine();
//			if (passname.matches("[a-zA-Z0-9@#!]+") && passname != "") {
//			/// System.out.println("valid");
//			flag = false;
//			} else {
//			// System.out.println("invalid");
//			flag = true;
//			}
//			} while (flag);
//			UserRegModel log = new UserRegModel();
//			log.setUserName(userName);
//			log.setPassword(passname);
//			UserDao obj = new UserDao();// name
//			String username = obj.login(log);
//			//System.out.println("hi" + userid);
//
//			return username;
		
		
		
		break;
		default:
		
		System.out.println("enter the valid option");
		break;
		
		
		
}
		
		
		public static String log() throws ClassNotFoundException, SQLException{
			
		}
	
	

}
