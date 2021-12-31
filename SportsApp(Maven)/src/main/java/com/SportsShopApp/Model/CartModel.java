package com.SportsShopApp.Model;

public class CartModel {
	private UserRegModel user;
	private ProductModel product;
	private double standardCost;
	private double totalPrice;
	private int quantity;
	public UserRegModel getUser() {
		return user;
	}
	public void setUser(UserRegModel user) {
		this.user = user;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public double getStandardCost() {
		return standardCost;
	}
	public void setStandardCost(double standardCost) {
		this.standardCost = standardCost;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartModel(UserRegModel user, ProductModel product, double standardCost, double totalPrice, int quantity) {
		super();
		this.user = user;
		this.product = product;
		this.standardCost = standardCost;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "product= " + product + "standardCost= " + standardCost + "totalPrice= "
				+ totalPrice + "quantity= " + quantity ;
	}
	
	

}
