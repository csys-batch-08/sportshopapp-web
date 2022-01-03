package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.UserRegModel;



public interface UserDaoDAO {
	public  void registration(UserRegModel reg) throws ClassNotFoundException, SQLException;
	public UserRegModel login( String userName, String password) throws ClassNotFoundException, SQLException;
	public List<UserRegModel> viewAllUsers() throws ClassNotFoundException, SQLException ;
	public void addMoneyWallet (double walletAmount, UserRegModel currentUser) throws ClassNotFoundException, SQLException;
	
}