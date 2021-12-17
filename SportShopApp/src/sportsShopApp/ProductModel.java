package sportsShopApp;

public class ProductModel {
	private String productName;
	private int productId;
	private double strandardCost;
	private String category;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getStrandardCost() {
		return strandardCost;
	}
	public void setStrandardCost(int strandardCost) {
		this.strandardCost = strandardCost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ProductModel(String productName, int productId, double strandardCost, String category) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.strandardCost = strandardCost;
		this.category = category;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {	
		return "ProductModel [productName=" + productName + ", productId=" + productId + ", strandardCost="
				+ strandardCost + ", category=" + category + "]";
	}

}
