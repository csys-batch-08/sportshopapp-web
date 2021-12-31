package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.SportsShopApp.Model.ProductModel;

public interface ProductInterface {
	public void insert() throws ClassNotFoundException, SQLException;
	public void delete() throws ClassNotFoundException, SQLException;
	public List<ProductModel> viewAllProducts() throws ClassNotFoundException, SQLException ;
	public void updateProducts(int updateProductId, String updateProductName, double updateStandardPrize, String updateProductCategory, int updateProductQuantity) throws SQLException, ClassNotFoundException;
	public ProductModel findProductById (int id) throws ClassNotFoundException, SQLException;
	
}
