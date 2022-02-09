package com.sportshopapp.dao;

import java.sql.SQLException;

import com.sportshopapp.model.Admin;

public interface AdminDAO {

	public Admin adlogin(String userName, String password);
	}
