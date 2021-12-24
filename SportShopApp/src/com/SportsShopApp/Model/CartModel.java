package com.SportsShopApp.Model;

public class CartModel {
	private String userName;
	private String category;
	private int productId;
	private double standardCost;
	private int quantity;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getStandardCost() {
		return standardCost;
	}
	public void setStandardCost(int standardCost) {
		this.standardCost = standardCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartModel(String userName, String category, int productId, double standardCost, int quantity) {
		super();
		this.userName = userName;
		this.category = category;
		this.productId = productId;
		this.standardCost = standardCost;
		this.quantity = quantity;
	}
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartModel [userName=" + userName + ", category=" + category + ", productId=" + productId
				+ ", standardCost=" + standardCost + ", quantity=" + quantity + "]";
	}
	
	

}
