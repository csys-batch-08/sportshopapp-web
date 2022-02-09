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
	public void orders(OderDetails order ,UserReg currentUser) {
		Connection con =null;
		PreparedStatement pstm =null;
		int i=0;
		try {
		String orderQuery = "insert into order_detail (user_name,products_id, price) values(?,?,?)";
	    	con =ConnectionUtil.getDbConnection();
			pstm = con.prepareStatement(orderQuery);
			pstm.setString(1, order.getUser().getUserName());
			pstm.setInt(2, order.getProducts().getProductId());
			pstm.setDouble(3, order.getPrice());
			i=pstm.executeUpdate();
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, pstm);
		}
	}
	
	public void deleteProduct(int orderId){
		Connection con =null;
		PreparedStatement pst=null;
		int res=0;
		try {
		String qwery="update order_detail set status='canceled' where order_id =?";
		con = ConnectionUtil.getDbConnection();
		pst=con.prepareStatement(qwery);
		pst.setInt(1, orderId);
		res=pst.executeUpdate();
		if(res>0)
		{	
		}
		else {
		}
		con.close();
		pst.close();
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, pst);
		}
	}
    public int getByOrderId(){
    //	Statement stms=null;
    	PreparedStatement pstm=null;
    	Connection con =null;
    	ResultSet rs =null;
    	int orderId =0;   
    	try {
    	String query = "select max(order_id) from order_detail";
    	    con =ConnectionUtil.getDbConnection();
    //	    stms = con.createStatement();
    	    pstm=con.prepareStatement(query);
    		rs = pstm.executeQuery(query);
    		if(rs.next()) {
    			return orderId = rs.getInt(1);
    		}
    	}catch(Exception e) {
    	}finally {
			ConnectionUtil.close(con, pstm, rs);
			
		}
    		return orderId;
    	}
    public boolean checkStatus(int orderId) 
	{	
		String status;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		try {
		String qwery="select status from order_detail where order_id= ?";
		con = ConnectionUtil.getDbConnection();
		pstmt=con.prepareStatement(qwery);
		pstmt.setInt(1, orderId);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			status=rs.getString("status").toLowerCase();
			if(!status.equals("canceled"))
			{
				return true;
			}
		}
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, pstmt, rs);
		}
		return false;
	}
    
    	
    }

