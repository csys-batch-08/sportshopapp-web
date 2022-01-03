package com.sportshopapp.dao;

import java.sql.SQLException;

import com.sportshopapp.model.OrderItemsModel;
import com.sportshopapp.model.UserRegModel;

public interface OrderItemsDAO {

	public void insertOrders(OrderItemsModel oi) throws ClassNotFoundException, SQLException ;
	public void ViewMyOrders(UserRegModel currentUser) throws ClassNotFoundException, SQLException ;
}
