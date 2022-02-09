package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.Product;

public interface ProductDAO {
	public Product insert(Product product);
	public void delete();
	public List<Product> viewAllProducts();
	
	public Product findProductById(int id);
	public Product cartProductById(int id);
	public void updateProductQuantity(Product currentProduct, int qty);
	
	
}
