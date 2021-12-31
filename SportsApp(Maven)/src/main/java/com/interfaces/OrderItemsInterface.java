package com.interfaces;

import java.sql.SQLException;

import com.SportsShopApp.Model.OrderItemsModel;
import com.SportsShopApp.Model.UserRegModel;

public interface OrderItemsInterface {

	public void insertOrders(OrderItemsModel oi) throws ClassNotFoundException, SQLException ;
	public void ViewMyOrders(UserRegModel currentUser) throws ClassNotFoundException, SQLException ;
}
