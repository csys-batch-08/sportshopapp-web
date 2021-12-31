package com.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.SportsShopApp.Model.CartModel;
import com.SportsShopApp.Model.UserRegModel;

public interface CartInterface {

	public void insertProduct (CartModel cart) throws ClassNotFoundException, SQLException;
	public List<CartModel> viewCart(UserRegModel currentUser) throws ClassNotFoundException, SQLException;
	
}
