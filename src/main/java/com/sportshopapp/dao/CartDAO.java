package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.Cart;
import com.sportshopapp.model.UserReg;

public interface CartDAO {

	public void insertProduct (Cart cart) throws ClassNotFoundException, SQLException;
	public List<Cart> viewCart(UserReg currentUser) throws ClassNotFoundException, SQLException;
	
}
