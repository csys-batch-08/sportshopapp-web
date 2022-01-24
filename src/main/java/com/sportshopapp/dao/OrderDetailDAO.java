package com.sportshopapp.dao;

import java.sql.SQLException;

public interface OrderDetailDAO {
	public void orders(int userId, double totalPrice) throws ClassNotFoundException, SQLException ;
	public int getByOrderId() throws ClassNotFoundException, SQLException ;

}
