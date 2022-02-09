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
	public void insertProduct(Cart cart) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnectionUtil.getDbConnection();
			String insertProduct = " insert into cart (user_name, products_id, product_name,standard_cost, quantity, total_prize ) values (?,?,?,?,?,?)";
			pstm = con.prepareStatement(insertProduct);
			pstm.setString(1, cart.getUser().getUserName());
			pstm.setInt(2, cart.getProduct().getProductId());
			pstm.setString(3, cart.getProduct().getProductName());
			pstm.setDouble(4, cart.getStandardCost());
			pstm.setInt(5, cart.getQuantity());
			pstm.setDouble(6, cart.getTotalPrice());
			int result = pstm.executeUpdate();
		} catch(Exception e){
		}
			finally {
		}
			ConnectionUtil.close(con, pstm);
		

	}

	public int productexist(Cart cart)  {
		Connection con = null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		try {
		 con = ConnectionUtil.getDbConnection();
		String query = "select quantity from cart where products_id in ? and user_name in ?";
		statement = con.prepareStatement(query);
		statement.setInt(1, cart.getProduct().getProductId());
		statement.setString(2, cart.getUser().getUserName());
		rs = statement.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		}catch(Exception e) {
			
		}finally {
			ConnectionUtil.close(con, statement, rs);
		}
		return -1;
	}

	public int productexist1(Cart cart)  {
		Connection con=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		try {
		con = ConnectionUtil.getDbConnection();
		String query = "select total_prize from cart where products_id in ? and user_name in ?";
		statement = con.prepareStatement(query);
		statement.setInt(1, cart.getProduct().getProductId());
		statement.setString(2, cart.getUser().getUserName());
		rs = statement.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, statement, rs);
		}
		return -1;
	}

	// update quantity:

	public int updatequantity(Cart cart) {
		Connection con=null;
		PreparedStatement statement=null;
		int res=0;
		try {
		 con = ConnectionUtil.getDbConnection();
		String query = "update cart set quantity = ?,total_prize = ? where products_id in ? and user_name in ?";
		statement = con.prepareStatement(query);
		statement.setInt(1, cart.getQuantity());
		statement.setDouble(2, cart.getTotalPrice());
		statement.setInt(3, cart.getProduct().getProductId());
		statement.setString(4, cart.getUser().getUserName());
		res = statement.executeUpdate();
		statement.executeUpdate("commit");
		
		}catch(Exception e) {
		}finally {
			ConnectionUtil.close(con, statement);
		}
		return res;
	}

	public int removecartItems(Cart cart){
		Connection con=null;
		PreparedStatement statement=null;
		int res=0;
		try {
		con = ConnectionUtil.getDbConnection();
		String query = "delete from cart where user_name=? and products_id=?";
		statement = con.prepareStatement(query);
		statement.setString(1, cart.getUser().getUserName());
		statement.setInt(2, cart.getProduct().getProductId());
		res = statement.executeUpdate();
		statement.executeUpdate("commit");
		}catch(Exception e ) {
		}finally {
			ConnectionUtil.close(con, statement);
		}
		return res;
	}

	public List<Cart> viewCart(UserReg currentUser) {
		Connection con = null;
//	Statement smts = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cart> allCartItems = null;
		try {
			String query = "select * from cart where user_name='" + currentUser.getUserName() + "'";

			con = ConnectionUtil.getDbConnection();
			allCartItems = new ArrayList<Cart>();
			stmt = con.prepareStatement(query);
//		smts = con.createStatement();
			rs = stmt.executeQuery(query);
			ProductDAOImpl proDao = new ProductDAOImpl();
			int i = 0;
			while (rs.next()) {

				Product product = proDao.findProductById(rs.getInt(3));
				Cart cart = new Cart(currentUser, product, rs.getInt(6), rs.getDouble(7));
				allCartItems.add(cart);
			}
		} catch (Exception e) {

		} finally {
			ConnectionUtil.close(con, stmt, rs);
		}

		return allCartItems;
	}
}
