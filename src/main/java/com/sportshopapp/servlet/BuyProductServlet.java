package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.OrderItemsDAOImpl;
import com.sportshopapp.daoimpl.OrderDetailDAOImpl;
import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;

@WebServlet("/prod1")
public class BuyProductServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)  {
		try {
			HttpSession session = req.getSession();
			UserDAOImpl user = new UserDAOImpl();
			ProductDAOImpl productDao = new ProductDAOImpl();
			OderDetails order = new OderDetails();
			OrderDetailDAOImpl orderDao = new OrderDetailDAOImpl();
			OrderItems orderItems = new OrderItems();
			OrderItemsDAOImpl orderItemsDaoImpl = new OrderItemsDAOImpl();
			UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
			Product currentproduct = (Product) session.getAttribute("currentproduct");
			int qty = Integer.parseInt(req.getParameter("quantity"));
			double price = Double.parseDouble(req.getParameter("totalPrice"));
			if (currentUser.getMyWallet() >= price) {
				if (currentproduct.getQuantity() >= qty) {
					int updateQty = currentproduct.getQuantity() - qty;
					productDao.updateProductQuantity(currentproduct, updateQty);
					order.setUser(currentUser);
					orderItems.setUser(currentUser);
					order.setPrice(price);
					order.setProducts(currentproduct);
					order.getUser().setMyWallet(order.getUser().getMyWallet() - price);
					orderDao.orders(order, currentUser);

					user.updateWalletMoney(order);

					int orderId = 0;
					orderId = orderDao.getByOrderId();
					order.setOrderId(orderId);
					orderItems.setOderModel(order);
					orderItems.setProduct(currentproduct);
					orderItems.setOrderId(orderId);
					orderItems.getProduct().setProductId(currentproduct.getProductId());
					orderItems.setQuantity(qty);
					orderItems.setUnitPrice(currentproduct.getStrandardCost());
					orderItems.setTotalPrice(price);

					orderItemsDaoImpl.insertOrders(orderItems);

					res.getWriter().println("order placed!!");
				}
				res.sendRedirect("userView.jsp");
			}

			else {
				res.sendRedirect("userView.jsp");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
}
