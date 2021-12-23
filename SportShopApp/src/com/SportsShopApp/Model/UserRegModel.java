package com.SportsShopApp.Model;

public class UserRegModel {
	private String userName;
	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String password;
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
	public UserRegModel() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public UserRegModel(String userName, String address, String firstName, String lastName, String email, long phone,
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
	@Override
	public String toString() {
		return "UserReg [user_name=" + userName + ", address=" + address + ", first_name=" + firstName
				+ ", last_name=" + lastName + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	
}
