package com.sportshopapp.dao;

import java.sql.SQLException;

import com.sportshopapp.model.AdminModel;

public interface AdminDAO {

	public  AdminModel adlogin (String userName, String password ) throws ClassNotFoundException, SQLException;
}
