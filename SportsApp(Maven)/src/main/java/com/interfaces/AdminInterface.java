package com.interfaces;

import java.sql.SQLException;

import com.SportsShopApp.Model.AdminModel;

public interface AdminInterface {

	public  AdminModel adlogin (String userName, String password ) throws ClassNotFoundException, SQLException;
}
