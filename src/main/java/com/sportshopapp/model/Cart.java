package com.sportshopapp.model;

public class Cart {
	private UserReg user;
	private Product product;
	private double standardCost;
	private double totalPrice;
	private int quantity;
	public UserReg getUser() {
		return user;
	}
	public void setUser(UserReg user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
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
	public Cart(UserReg user, Product product, double standardCost, double totalPrice, int quantity) {
		super();
		this.user = user;
		this.product = product;
		this.standardCost = standardCost;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	public Cart() {
		super();

	}
	public Cart(UserReg user, Product product,int quantity, double totalPrice ) {
		super();
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	
	}
	@Override
	public String toString() {
		return "product= " + product + "standardCost= " + standardCost + "totalPrice= "
				+ totalPrice + "quantity= " + quantity ;
	}

}
