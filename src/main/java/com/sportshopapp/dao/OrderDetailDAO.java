package com.sportshopapp.dao;

import java.sql.SQLException;

import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.UserReg;

public interface OrderDetailDAO {
	public void orders(OderDetails order ,UserReg currentUser);
	public void deleteProduct(int orderId);
	 public int getByOrderId();
	 public boolean checkStatus(int orderId) ;
	 
	
}
