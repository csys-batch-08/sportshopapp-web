package com.sportshopapp.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sportshopapp.dao.OrderDetailDAO;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.UserReg;
import com.sportshopapp.util.ConnectionUtil;

public class OrderDetailDAOImpl implements OrderDetailDAO{
	public void orders(OderDetails order ,UserReg currentUser) throws ClassNotFoundException, SQLException {
		String orderQuery = "insert into order_detail (user_name,products_id, price) values(?,?,?)";
		Connection con =ConnectionUtil.getDbConnection();
		System.out.println(order.getUser().getUserName());
		System.out.println(order.getProducts().getProductId());
		System.out.println (order.getPrice());
		try {
			PreparedStatement pstm = con.prepareStatement(orderQuery);
			//System.out.println(totalPrice);
			pstm.setString(1, order.getUser().getUserName());
			pstm.setInt(2, order.getProducts().getProductId());
			pstm.setDouble(3, order.getPrice());
			System.out.println("insert");
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			e.getMessage();
		}
	}
    public int getByOrderId() throws ClassNotFoundException, SQLException
    {
    	String query = "select max(order_id) from order_detail";
    	Connection con =ConnectionUtil.getDbConnection();
    	OderDetails order = null;
    	int orderId =0;
    	try {
    		Statement stms = con.createStatement();
    		ResultSet rs = stms.executeQuery(query);
    		if(rs.next()) {
    			return orderId = rs.getInt(1);
    		}
    	}
    		catch (SQLException e) {
    			e.getMessage();
    		}return orderId;
    	}
	@Override
	public void orders(int userId, double totalPrice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
    	
    }

