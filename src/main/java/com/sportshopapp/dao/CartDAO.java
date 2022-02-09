package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.Cart;
import com.sportshopapp.model.UserReg;

public interface CartDAO {

	public void insertProduct(Cart cart);
	public int productexist(Cart cart) ;
	public int productexist1(Cart cart);
	public int updatequantity(Cart cart);
	public int removecartItems(Cart cart);
	public List<Cart> viewCart(UserReg currentUser);
	
	
	
}
