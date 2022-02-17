package com.sportshopapp.model;

import java.io.Serializable;

public class Admin implements Serializable {
	private String userName;
	private String password;
    private String email;
    private long mobile;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String userName, String password, String email, long mobile) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "AdminModel [userName=" + userName + ", password=" + password + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}

}
