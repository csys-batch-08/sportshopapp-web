package com.sportshopapp.model;

import java.sql.Date;

public class OderDetailsModel {
	private int orderId;
	private UserRegModel user;
	private ProductModel products;
	private Date orderDate ;
	private double price;
	private String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserRegModel getUser() {
		return user;
	}
	public void setUser(UserRegModel user) {
		this.user = user;
	}
	public ProductModel getProducts() {
		return products;
	}
	public void setProducts(ProductModel products) {
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
	
	public OderDetailsModel(Date orderDate, double price, String orderStatus) {
		super();
		this.orderDate = orderDate;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	public OderDetailsModel(UserRegModel currentUser, ProductModel buyProducts, double price) {
		super();
		this.user = currentUser;
		this.products = buyProducts;
		this.price = price;
	}
	public OderDetailsModel(UserRegModel currentUser, double price) {
		super();
		this.user = currentUser;
		this.price = price;
	}
	@Override
	public String toString() {
		return  ", orderDate=" + orderDate + ", price=" + price + ", orderStatus=" + orderStatus + "]";
	}
	public OderDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
