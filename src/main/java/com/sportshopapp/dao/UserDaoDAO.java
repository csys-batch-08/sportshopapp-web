package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.UserReg;



public interface UserDaoDAO {
	public  void registration(UserReg reg) throws ClassNotFoundException, SQLException;
	public UserReg login( String userName, String password) throws ClassNotFoundException, SQLException;
	public List<UserReg> viewAllUsers() throws ClassNotFoundException, SQLException ;
	public void addMoneyWallet (double walletAmount, UserReg currentUser) throws ClassNotFoundException, SQLException;
	
}