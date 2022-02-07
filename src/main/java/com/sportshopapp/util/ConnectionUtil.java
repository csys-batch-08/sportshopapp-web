package com.sportshopapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
public static Connection getDbConnection() throws ClassNotFoundException, SQLException	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		    
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		  
		return con; 
		
		}
public static void close(Connection connection, PreparedStatement pst, ResultSet rs) {
	try {
		if (rs != null) {
			rs.close();
		}
		if (pst != null) {
			pst.close();
		}
		if (connection != null) {
			connection.close();
		}
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
}
public static void close(Connection connection, PreparedStatement pst) {
	try {
		if (pst != null) {
			pst.close();
		}
		if (connection != null) {
			connection.close();
		}
	} catch (Exception e) 
	{
		e.printStackTrace();
	}
}

}