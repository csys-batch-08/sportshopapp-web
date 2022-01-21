package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sportshopapp.dao.OrderItemsDAO;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;
import com.sportshopapp.util.ConnectionUtil;

public class OderItemsDAOImpl implements OrderItemsDAO {
	public int insertOrders(OrderItems oi) throws ClassNotFoundException, SQLException {
	String orderQuery="insert into orders_item (user_name, order_id, products_id, quantity, standard_cost, total_price )values (?,?,?,?,?,?)";
	Connection con = ConnectionUtil.getDbConnection();
	int res=0;
	try {
		PreparedStatement pstm = con.prepareStatement(orderQuery);
		pstm.setString(1, oi.getUser().getUserName());
		pstm.setInt(2, oi.getOrderId());
		pstm.setInt(3, oi.getProduct().getProductId());
		pstm.setInt(4, oi.getQuantity());
		pstm.setDouble(5, oi.getUnitPrice());
		pstm.setDouble(6,oi.getTotalPrice());
		//System.out.println(pstm.executeUpdate()+"rows updated order Batman");
		res =pstm.executeUpdate();
		System.out.println("Batman");
		pstm.executeUpdate("commit");
	}catch(SQLException e){
		System.out.println(e.getMessage());
		
	}
	return res;
	}
	public List<OrderItems> ViewMyOrder(UserReg currentUser) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<OrderItems> myOrderList = new ArrayList<OrderItems>();
		OderDetails order = new OderDetails();
		Product product= new Product();
		OrderItems orderItems;
		System.out.println(currentUser.getUserName());
		String qwery="select p.products_name,oi.quantity,oi.standard_cost,oi.total_price,oi.order_id,p.products_id,oi.order_id \r\n"
				+ "				 from orders_item oi \r\n"
				+ "				 inner join order_detail o on oi.order_id=o.order_id\r\n"
				+ "				 inner join product_items p on oi.products_id=p.products_id where oi.user_name='"+currentUser.getUserName() +"' order by oi.total_price desc";
						Connection con = ConnectionUtil.getDbConnection();
						
						System.out.println(qwery);
		try {
			PreparedStatement ps = con.prepareStatement(qwery);
			ResultSet rs = ps.executeQuery();
			System.out.println("resultset");
			int num=0;
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getDouble(5));
				System.out.println(rs.getDouble(6));
				
				orderItems = new OrderItems(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getDouble(4),rs.getInt(5),rs.getInt(6));
				myOrderList.add(orderItems);
				System.out.println(orderItems);
			}
			System.out.println(num);
			return myOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myOrderList;
		
		
	}

	
	public void ViewMyOrders(UserReg currentUser) throws ClassNotFoundException, SQLException {
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
