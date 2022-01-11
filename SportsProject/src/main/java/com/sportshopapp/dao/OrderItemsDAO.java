package com.sportshopapp.dao;

import java.sql.SQLException;

import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.UserReg;

public interface OrderItemsDAO {

	public int insertOrders(OrderItems oi) throws ClassNotFoundException, SQLException ;
	public void ViewMyOrders(UserReg currentUser) throws ClassNotFoundException, SQLException ;
}
