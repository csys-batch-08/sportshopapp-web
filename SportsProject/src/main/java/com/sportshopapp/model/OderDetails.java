package com.sportshopapp.model;

import java.sql.Date;

public class OderDetails {
	private int orderId;
	private UserReg user;
	private Product products;
	private Date orderDate ;
	private double price;
	private String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserReg getUser() {
		return user;
	}
	public void setUser(UserReg user) {
		this.user = user;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public OderDetails(Date orderDate, double price, String orderStatus) {
		super();
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	public OderDetails(UserReg currentUser, Product buyProducts, double price) {
		super();
		this.user = currentUser;
		this.products = buyProducts;
		this.price = price;
	}
	public OderDetails(UserReg currentUser, double price) {
		super();
		this.user = currentUser;
		this.price = price;
	}
	@Override
	public String toString() {
		return  ", orderDate=" + orderDate + ", price=" + price + ", orderStatus=" + orderStatus + "]";
	}
	public OderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
