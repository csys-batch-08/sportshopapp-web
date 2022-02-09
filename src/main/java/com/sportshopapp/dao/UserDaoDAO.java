package com.sportshopapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.UserReg;



public interface UserDaoDAO {
	public void registration(UserReg reg);
	public UserReg login(String userName, String password);
	public List<UserReg> viewAllUsers();
	public UserReg viewCurrentUsers(String username);
	public boolean changepassword(UserReg customer);
	public void updateWalletMoney(OderDetails order);
	public void addMoneyWallet(OderDetails order);
	public int addMoneyInWallet(double walletAmount, UserReg currentUser);

	
}