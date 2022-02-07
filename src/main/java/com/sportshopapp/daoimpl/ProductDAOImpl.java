package com.sportshopapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sportshopapp.dao.ProductDAO;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;
import com.sportshopapp.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {
	Scanner sc = new Scanner(System.in);

	public Product insert(Product product) throws ClassNotFoundException, SQLException {
	char check;

	Connection con= ConnectionUtil.getDbConnection();
	String query = "insert into product_items values(?,?,?,?,?,?)";
	PreparedStatement stmt = con.prepareStatement(query);
	
	stmt.setString(1, product.getProductName());
	stmt.setInt(2, product.getProductId());
	stmt.setDouble(3, product.getStrandardCost());
	stmt.setString(4, product.getCategory());
	stmt.setInt(5, product.getQuantity());
	stmt.setString(6, product.getImg());
	int result =stmt.executeUpdate();
	if(result>0)
	{
		return product;
	}
	
	return product;
	}

	public void delete() throws ClassNotFoundException, SQLException {
	char check;
	
	check = sc.nextLine().charAt(0);
	if (check == 'y' || check == 'Y') {
	
	int prodId = Integer.parseInt(sc.nextLine());

	Connection con= ConnectionUtil.getDbConnection();
	Product str = new Product();
	str.setProductId(prodId);
	String query = "delete from  product_items where products_id=?";
	PreparedStatement stmt = con.prepareStatement(query);

	stmt.setInt(1, str.getProductId());
	stmt.executeUpdate();
	
	}
     
	}
	
		public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException {
			
			Connection con = ConnectionUtil.getDbConnection();
			Statement stmt = con.createStatement();
			
			List<Product> productList = new ArrayList<Product>();
			String view = " SELECT products_name, products_id, standard_cost, category, quantity, img FROM product_items";
			ResultSet rs = stmt.executeQuery(view);
			while (rs.next()) {
				
				Product product = new Product(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getString(4),rs.getInt(5),rs.getString(6));
				productList.add(product);
			
			}
			return productList;
			
		}
		
	
		public boolean updateProducts(Product product) throws SQLException, ClassNotFoundException {
			String updateQuery="update product_items set products_name=?,standard_cost=?, category=?, quantity=? where products_id=? " ;
			boolean b=false;
			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pstm=null;
			pstm = con.prepareStatement(updateQuery);
			pstm.setString(1, product.getProductName());
			pstm.setInt(5, product.getProductId());
			pstm.setDouble(2, product.getStrandardCost());
			pstm.setString(3, product.getCategory());
			pstm.setInt(4, product.getQuantity());
			
			int result =  pstm.executeUpdate();
			if(result >0) {
				b=true;
				return b;
			}
			else {
				
			}
			return b;
		}
		public Product findProductById (int id) throws ClassNotFoundException, SQLException {
			int productId = 0;
		//	String query="select * from product_items where products_id= '" + id+ "'";
			String query="select products_name, products_id, standard_cost, category, quantity, img from product_items where products_id= '" + id+ "'";
			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pstm = con.prepareStatement(query);
			Product product = null;
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				product = new Product(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getString(4),rs.getInt(5));
			}
			return product;
			}
		public Product cartProductById (int id) throws ClassNotFoundException, SQLException {
			int productId = 0;
			
	//		String query="select * from product_items where products_id= '" + id+ "'";
			String query="select products_name, products_id, standard_cost, category, quantity, img from product_items where products_id= '" + id+ "'";
			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pstm = con.prepareStatement(query);
			Product product = null;

			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				product = new Product(rs.getString(2),rs.getInt(3),rs.getDouble(6),rs.getString(4),rs.getInt(5));
				
			}
			return product;
			}

		@Override
		public void updateProducts(int updateProductId, String updateProductName, double updateStandardPrize,
				String updateProductCategory, int updateProductQuantity) throws SQLException, ClassNotFoundException {
		
			
		}

		@Override
		public boolean insert() throws ClassNotFoundException, SQLException {

			return false;
		}
		public void updateProductQuantity(Product currentProduct, int qty) throws SQLException, ClassNotFoundException
		{
			
			String updateQtyQuery = "update product_items set quantity ="+qty+" where products_id = "+currentProduct.getProductId()+"";
			
			
			Connection con = ConnectionUtil.getDbConnection();
			
				PreparedStatement pst=con.prepareStatement(updateQtyQuery);
				int res=pst.executeUpdate();
				pst=con.prepareStatement("commit");
				int res2=pst.executeUpdate();
				if(res>0)
				{
				
				}

		

		}
		}
	
	


