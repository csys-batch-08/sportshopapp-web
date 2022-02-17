package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;

import com.sportshopapp.dao.ProductDAO;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;
import com.sportshopapp.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {
	Scanner sc = new Scanner(System.in);

	public Product insert(Product product) {
		char check;
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			String query = "insert into product_items values(?,?,?,?,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getProductId());
			stmt.setDouble(3, product.getStrandardCost());
			stmt.setString(4, product.getCategory());
			stmt.setInt(5, product.getQuantity());
			stmt.setString(6, product.getImg());
			result = stmt.executeUpdate();
			if (result > 0) {
				return product;
			}
		} catch (Exception e) {
		} finally {
			ConnectionUtil.close(con, stmt);
		}
		return product;
	}

	public void delete() {
		char check;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			check = sc.nextLine().charAt(0);
			int prodId = Integer.parseInt(sc.nextLine());
			con = ConnectionUtil.getDbConnection();
			Product str = new Product();
			str.setProductId(prodId);
			String query = "delete from  product_items where products_id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, str.getProductId());
			stmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			ConnectionUtil.close(con, stmt);
		}

	}

	public List<Product> viewAllProducts() {
		Connection con = null;
		// Statement stmt =null;
		PreparedStatement pstm = null;
		List<Product> productList = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			// stmt = con.createStatement();

			productList = new ArrayList<Product>();
			String view = " SELECT products_name, products_id, standard_cost, category, quantity, img FROM product_items";
			pstm = con.prepareStatement(view);
			rs = pstm.executeQuery(view);
			while (rs.next()) {

				Product product = new Product(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getString(4),
						rs.getInt(5), rs.getString(6));
				productList.add(product);
			}
		} catch (Exception e) {
			
		} finally {
			ConnectionUtil.close(con, pstm, rs);
		}
		return productList;
	}

	public boolean updateProducts(Product product)  {
		Connection con = null;
		PreparedStatement pstm = null;
		boolean b = false;
		try {
			String updateQuery = "update product_items set products_name=?,standard_cost=?, category=?, quantity=? where products_id=? ";

			con = ConnectionUtil.getDbConnection();
			pstm = con.prepareStatement(updateQuery);
			pstm.setString(1, product.getProductName());
			pstm.setInt(5, product.getProductId());
			pstm.setDouble(2, product.getStrandardCost());
			pstm.setString(3, product.getCategory());
			pstm.setInt(4, product.getQuantity());

			int result = pstm.executeUpdate();
			if (result > 0) {
				b = true;
				return b;
			}
		} catch (Exception e) {
		} finally {
			ConnectionUtil.close(con, pstm);
		}
		return b;
	}

	public Product findProductById(int id) {
		int productId = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product product = null;
		try {
			String query = "select products_name, products_id, standard_cost, category, quantity, img from product_items where products_id= '"
					+ id + "'";
			con = ConnectionUtil.getDbConnection();
			pstm = con.prepareStatement(query);
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getString(4), rs.getInt(5));
			}
			
		} catch (Exception e) {
		} finally {
			ConnectionUtil.close(con, pstm, rs);
		}
		return product;
	}

	public Product cartProductById(int id) {
		int productId = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product product = null;
		try {
			String query = "select products_name, products_id, standard_cost, category, quantity, img from product_items where products_id= '"
					+ id + "'";
			con = ConnectionUtil.getDbConnection();
			pstm = con.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getString(2), rs.getInt(3), rs.getDouble(6), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
		} finally {
			ConnectionUtil.close(con, pstm, rs);
		}
		return product;
	}
	public void updateProductQuantity(Product currentProduct, int qty) {
		Connection con = null;
		PreparedStatement pst = null;
        try {
		String updateQtyQuery = "update product_items set quantity =" + qty + " where products_id = "
				+ currentProduct.getProductId() + "";
		con = ConnectionUtil.getDbConnection();
		pst = con.prepareStatement(updateQtyQuery);
		int res = pst.executeUpdate();
		pst = con.prepareStatement("commit");
		int res2 = pst.executeUpdate();
        }catch(Exception e) {
        }finally {
			ConnectionUtil.close(con, pst);
		}
	}
}
