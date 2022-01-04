package com.sportshopapp.model;

public class OrderItems extends OderDetails {
	private int itemId;
	private UserReg user;
	private Product product;
	private OderDetails oderModel;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

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

	public OderDetails getOderModel() {
		return oderModel;
	}

	public void setOderModel(OderDetails oderModel) {
		this.oderModel = oderModel;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(int itemId, UserReg user, Product product, OderDetails oderModel,
			int quantity, double unitPrice, double totalPrice) {
		super();
		this.itemId = itemId;
		this.user = user;
		this.product = product;
		this.oderModel = oderModel;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "order id " + getOrderId() + "\nuser " + user + "\nproduct " + product + "\nquantity " + quantity + "\nunitPrice " + unitPrice + "\ntotalPrice " + totalPrice+"\n";
	}
	

}
