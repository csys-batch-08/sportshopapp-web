package com.sportshopapp.model;

import java.io.Serializable;

public class UserReg implements Serializable{
	private String userName;
	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String password;
	private double myWallet;
	public double getMyWallet() {
		return myWallet;
	}
	public void setMyWallet(double myWallet) {
		this.myWallet = myWallet;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserReg() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public UserReg(String userName, String address, String firstName, String lastName, String email, long phone,
			String password) {
		super();
		
		this.userName = userName;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public UserReg(String userName, String address, String firstName, String lastName, String email, long phone,
			double myWallet) {
		super();
		this.userName = userName;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.myWallet = myWallet;
	}
	public UserReg(String userName, String password) {
		super();
		
		this.userName = userName;
		this.password = password;
	}
	public UserReg(String userName, String address, String firstName, String lastName, String email, long phone,
			String password, double myWallet) {
		super();
		this.userName = userName;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.myWallet = myWallet;
	}
	
	@Override
	public String toString() {
		return "UserRegModel [userName=" + userName + ", address=" + address + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", myWallet=" + myWallet + "]";
	}
}
