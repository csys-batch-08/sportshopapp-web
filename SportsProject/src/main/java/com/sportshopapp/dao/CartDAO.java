package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.CartModel;
import com.sportshopapp.model.UserRegModel;

public interface CartDAO {

	public void insertProduct (CartModel cart) throws ClassNotFoundException, SQLException;
	public List<CartModel> viewCart(UserRegModel currentUser) throws ClassNotFoundException, SQLException;
	
}
