package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sportshopapp.dao.CartDAO;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;
import com.sportshopapp.util.ConnectionUtil;

public class CartDAOImpl implements CartDAO {
	public void insertProduct (Cart cart) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getDbConnection();
		System.out.println("cart qty"+cart.getQuantity());
		System.out.println(cart.getProduct().getProductName());
		System.out.println(cart.getStandardCost());
		System.out.println(cart.getUser().getUserName());
		System.out.println(cart.getProduct().getProductId());
		System.out.println(cart.getTotalPrice());
		try {
			String insertProduct = " insert into cart (user_name, products_id, product_name,standard_cost, quantity, total_prize ) values (?,?,?,?,?,?)";
			PreparedStatement pstm;
			try {
				pstm = con.prepareStatement(insertProduct);
				pstm.setString(1, cart.getUser().getUserName());
				pstm.setInt(2, cart.getProduct().getProductId());
				pstm.setString(3, cart.getProduct().getProductName());
				pstm.setDouble(4, cart.getStandardCost());
				pstm.setInt(5, cart.getQuantity());
				pstm.setDouble(6, cart.getTotalPrice());
				
				int result = pstm.executeUpdate();
				System.out.println(result + "product added to cart");	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		    }
             catch (Exception e)
		{
            	 e.getMessage();
            	 System.out.println("Something went wrong");
		}
	}
	public int productexist(Cart cart) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtil.getDbConnection();
		String query = "select quantity from cart where products_id in ? and user_name in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getProduct().getProductId());
		statement.setString(2, cart.getUser().getUserName());
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}
	public int productexist1(Cart cart) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtil.getDbConnection();
		String query = "select total_prize from cart where products_id in ? and user_name in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getProduct().getProductId());
		statement.setString(2, cart.getUser().getUserName());
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}
	
	//update quantity:
	
	public int updatequantity(Cart cart) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtil.getDbConnection();
		String query = "update cart set quantity = ?,total_prize = ? where products_id in ? and user_name in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, cart.getQuantity());
		statement.setDouble(2, cart.getTotalPrice());
		statement.setInt(3, cart.getProduct().getProductId());
		statement.setString(4, cart.getUser().getUserName());
		int res = statement.executeUpdate();
		statement.executeUpdate("commit");
		return res;
	}

	public int removecartItems(Cart cart) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtil.getDbConnection();
		String query = "delete from cart where user_name=? and products_id=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, cart.getUser().getUserName());
		statement.setInt(2, cart.getProduct().getProductId());
		int res = statement.executeUpdate();
		statement.executeUpdate("commit");
		return res;
		}
	public List<Cart> viewCart(UserReg currentUser) throws ClassNotFoundException, SQLException {
		System.out.println("first");

		System.out.println("cart"+currentUser.getUserName());
		System.out.println("first");

		String query= "select * from cart where user_name='"+currentUser.getUserName()+"'";
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("1");
		List<Cart> allCartItems=new ArrayList<Cart>();
		System.out.println("2");

		Statement smts = null;
		System.out.println("3");

		ResultSet rs= null;
		System.out.println("4");

		try {
			System.out.println("5");

			smts = con.createStatement();
			rs=smts.executeQuery(query);
			System.out.println("6");

			ProductDAOImpl proDao=new ProductDAOImpl();
			System.out.println("7");
			int i=0;
			while(rs.next()) {
				System.out.println("8");
				System.out.println(rs.getInt(3));
				Product product=proDao.findProductById(rs.getInt(3));
				Cart cart=new Cart(currentUser,product, rs.getInt(6),rs.getDouble(7));
				System.out.println(rs.getDouble(6));
				allCartItems.add(cart);
				System.out.println("8");
				System.out.println(allCartItems.get(i));
				System.out.println("9");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return allCartItems;
	}
}

