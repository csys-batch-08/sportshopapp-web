package com.sportshopapp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sportshopapp.daoimpl.CartDAOImpl;
import com.sportshopapp.daoimpl.OrderItemsDAOImpl;
import com.sportshopapp.daoimpl.OrderDetailDAOImpl;
import com.sportshopapp.daoimpl.ProductDAOImpl;
import com.sportshopapp.daoimpl.UserDAOImpl;
import com.sportshopapp.model.Cart;
import com.sportshopapp.model.OderDetails;
import com.sportshopapp.model.OrderItems;
import com.sportshopapp.model.Product;
import com.sportshopapp.model.UserReg;

@WebServlet("/cartorder")
public class CartUpdateServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();

		UserDAOImpl user = new UserDAOImpl();

		ProductDAOImpl productDao = new ProductDAOImpl();
		Product product = new Product();
		OrderItems orderItems = new OrderItems();
		Cart cart = new Cart();
		CartDAOImpl cartdao = new CartDAOImpl();

		OderDetails order = new OderDetails();
		OrderDetailDAOImpl orderDao = new OrderDetailDAOImpl();
		OrderItemsDAOImpl orderItemsDaoImpl = new OrderItemsDAOImpl();

		UserReg currentUser = (UserReg) session.getAttribute("logincustomer");
		int CartproductId = Integer.parseInt(req.getParameter("CartproductId"));
		int cartQuantity = Integer.parseInt(req.getParameter("cartQuantity"));
		double unitPrice = Double.parseDouble(req.getParameter("unitPrice"));
		double totalPrice = Double.parseDouble(req.getParameter("totalPrice"));

		int CartprodId = Integer.parseInt(req.getParameter("CartproductId"));
		int removeStatus;

		Product currentProduct = null;
		currentProduct = productDao.findProductById(CartprodId);
		cart.setProduct(currentProduct);
		cart.setUser(currentUser);

		if (currentProduct.getQuantity() != 0 && (currentProduct.getQuantity() - cartQuantity) > 0) {

			if ((currentUser.getMyWallet() - totalPrice) >= 0) {
				order.setProducts(currentProduct);
				int updateQty = currentProduct.getQuantity() - cartQuantity;

				productDao.updateProductQuantity(currentProduct, updateQty);
				order.setPrice(totalPrice);
				order.setUser(currentUser);
				order.getUser().setMyWallet(currentUser.getMyWallet() - totalPrice);

				orderDao.orders(order, currentUser);
				user.updateWalletMoney(order);
				int orderId = 0;
				orderId = orderDao.getByOrderId();

				orderItems.setProduct(currentProduct);
				orderItems.setUser(currentUser);
				orderItems.setOrderId(orderId);
				orderItems.setQuantity(cartQuantity);
				orderItems.setUnitPrice(unitPrice);
				orderItems.setTotalPrice(totalPrice);
				int result = orderItemsDaoImpl.insertOrders(orderItems);
				removeStatus = cartdao.removecartItems(cart);
				res.sendRedirect("cart.jsp");

			} else {
				
			}
		} else {
			res.sendRedirect("userProfile.jsp");

		}

	}

}