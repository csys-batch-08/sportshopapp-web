package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.UserReg;

public interface OrderItemsDAO {
	public int insertOrders(OrderItems oi);
	public List<OrderItems> ViewMyOrder(UserReg currentUser);
	public void ViewMyOrders(UserReg currentUser);
	

	}
