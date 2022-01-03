package com.sportshopapp.model;

public class OrderItemsModel extends OderDetailsModel {
	private int itemId;
	private UserRegModel user;
	private ProductModel product;
	private OderDetailsModel oderModel;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

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

	public OderDetailsModel getOderModel() {
		return oderModel;
	}

	public void setOderModel(OderDetailsModel oderModel) {
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

	public OrderItemsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemsModel(int itemId, UserRegModel user, ProductModel product, OderDetailsModel oderModel,
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
