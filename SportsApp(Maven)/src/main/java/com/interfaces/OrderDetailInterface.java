package com.interfaces;

import java.sql.SQLException;

public interface OrderDetailInterface {
	public void orders(int userId, double totalPrice) throws ClassNotFoundException, SQLException ;
	public int getByOrderId() throws ClassNotFoundException, SQLException ;

}
