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
		System.out.println("order name"+order.getUser().getUserName());
		System.out.println("order pId"+order.getProducts().getProductId());
		System.out.println ("order price"+order.getPrice());
		try {
			PreparedStatement pstm = con.prepareStatement(orderQuery);
			//System.out.println(totalPrice);
			pstm.setString(1, order.getUser().getUserName());
			pstm.setInt(2, order.getProducts().getProductId());
			pstm.setDouble(3, order.getPrice());
			System.out.println("insert");
			int i=pstm.executeUpdate();
			System.out.println(i+"row insertrd");
			//pstm.executeUpdate("commit");
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	

	public boolean checkStatus(int orderId)
	{
	try {
	String status;
	String qwery="select status from order_detail where order_id='"+orderId+"'";
	Connection con = ConnectionUtil.getDbConnection();
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(qwery);
	if(rs.next())
	{

	status=rs.getString(1).toLowerCase();
	System.out.println(status);
	if(!status.equals("canceled"))
	{
	return true;

	}

	}
	}
	catch(Exception e)
	{
	System.out.println(e.getStackTrace());
	}
	return false;
	}
	public void deleteProduct(int orderId) throws SQLException, ClassNotFoundException
	{
		String qwery="update order_detail set status='canceled' where order_id =?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst=con.prepareStatement(qwery);
		pst.setInt(1, orderId);
		
		int res=pst.executeUpdate();
		if(res>0)
		{
			System.out.println(res+"Product deleted");
			
		}
		else {
			System.out.println("product not deleted");
		}
		con.close();
		pst.close();
		
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

