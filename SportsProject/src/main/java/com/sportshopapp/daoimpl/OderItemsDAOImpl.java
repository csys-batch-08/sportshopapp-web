package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sportshopapp.dao.OrderItemsDAO;
import com.sportshopapp.model.OrderItemsModel;
import com.sportshopapp.model.UserRegModel;
import com.sportshopapp.util.ConnectionUtil;

public class OderItemsDAOImpl implements OrderItemsDAO {
	public void insertOrders(OrderItemsModel oi) throws ClassNotFoundException, SQLException {
	String orderQuery="insert into orders_item (user_name, order_id, products_id, quantity, standard_cost, total_price )values (?,?,?,?,?,?)";
	Connection con = ConnectionUtil.getDbConnection();
	try {
		PreparedStatement pstm = con.prepareStatement(orderQuery);
		pstm.setString(1, oi.getUser().getUserName());
		pstm.setInt(2, oi.getOderModel().getOrderId());
		pstm.setInt(3, oi.getProduct().getProductId());
		pstm.setInt(4, oi.getQuantity());
		pstm.setDouble(5, oi.getUnitPrice());
		pstm.setDouble(6,oi.getTotalPrice());
		System.out.println(pstm.executeUpdate()+"rows updated");
		pstm.executeUpdate("commit");
	}catch(SQLException e){
		System.out.println(e.getMessage());
		
	}
	
	}
	public void ViewMyOrders(UserRegModel currentUser) throws ClassNotFoundException, SQLException {
		String query= " select p.products_id , oi.quantity, oi.standard_cost, oi.total_price, oi.order_id\r\n"
				 + "from orders_item oi \r\n"
				 + "inner join order_detail o on oi.order_id\r\n"
				 + "inner join product_items p on oi.products_id=p.product_id where oi.user_name = " + currentUser.getUserName();
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			System.out.format("%-15s%-10s%-15s%-15s%-10s\n\n","Product Name","Qty","Unit Price","Total Price","Order Id");
			while(rs.next())
			{
			System.out.format("%-15s%-10s%-15s%-15s%-10s\n",rs.getInt(1),rs.getInt(2),rs.getDouble(3),rs.getDouble(4),rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
