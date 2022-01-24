package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.Product;

public interface ProductDAO {
	public boolean insert() throws ClassNotFoundException, SQLException;
	public void delete() throws ClassNotFoundException, SQLException;
	public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException ;
	public void updateProducts(int updateProductId, String updateProductName, double updateStandardPrize, String updateProductCategory, int updateProductQuantity) throws SQLException, ClassNotFoundException;
	public Product findProductById (int id) throws ClassNotFoundException, SQLException;
	
}
