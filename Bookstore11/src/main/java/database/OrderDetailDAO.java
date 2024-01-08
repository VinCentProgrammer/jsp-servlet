package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Order;
import model.OrderDetail;
import model.Product;

public class OrderDetailDAO implements DAOInterface<OrderDetail> {

	@Override
	public ArrayList<OrderDetail> selectAll() {
		ArrayList<OrderDetail> result = new ArrayList<OrderDetail>();
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM order_detail";

			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String orderDetailId = rs.getString("orderDetailId");
				String orderId = rs.getString("orderId");
				String productId = rs.getString("productId");
				int numOrderDetail = rs.getInt("numOrderDetail");
				double coverPrice = rs.getDouble("coverPrice");
				double discount = rs.getDouble("discount");
				double realPrice = rs.getDouble("realPrice");
				double vat = rs.getDouble("vat");
				double total = rs.getDouble("total");

				Order order = new Order();
				order.setOrderId(orderId);

				Product product = new Product();
				product.setProductId(productId);

				OrderDetail orderItem = new OrderDetail(orderDetailId, order, product, 
						numOrderDetail, coverPrice, discount, realPrice, vat, total);
				result.add(orderItem);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public OrderDetail selectById(OrderDetail t) {
		OrderDetail result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM order_detail WHERE orderDetailId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, t.getOrderDetailId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String orderDetailId = rs.getString("orderDetailId");
				String orderId = rs.getString("orderId");
				String productId = rs.getString("productId");
				int numOrderDetail = rs.getInt("numOrderDetail");
				double coverPrice = rs.getDouble("coverPrice");
				double discount = rs.getDouble("discount");
				double realPrice = rs.getDouble("realPrice");
				double vat = rs.getDouble("vat");
				double total = rs.getDouble("total");

				Order order = new Order();
				order.setOrderId(orderId);

				Product product = new Product();
				product.setProductId(productId);

				result = new OrderDetail(orderDetailId, order, product, numOrderDetail, coverPrice, 
						discount, realPrice, vat, total);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(OrderDetail orderItem) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "INSERT INTO order_detail "
					+ "(orderDetailId, orderId, productId, numOrderDetail, coverPrice, "
					+ "discount, realPrice, vat, total) " 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, orderItem.getOrderDetailId());
			st.setString(2, orderItem.getOrder().getOrderId());
			st.setString(3, orderItem.getProduct().getProductId());
			st.setInt(4, orderItem.getNumOrderDetail());
			st.setDouble(5, orderItem.getCoverPrice());
			st.setDouble(6, orderItem.getDiscount());
			st.setDouble(7, orderItem.getRealPrice());
			st.setDouble(8, orderItem.getVat());
			st.setDouble(9, orderItem.getTotal());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<OrderDetail> orderDetailList) {
		int count = 0;
		for (OrderDetail orderItem : orderDetailList) {
			count += insert(orderItem);
		}
		return count;
	}

	@Override
	public int delete(OrderDetail orderItem) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "DELETE FROM order_detail " + "WHERE orderDetailId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, orderItem.getOrderDetailId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<OrderDetail> orderDetailList) {
		int count = 0;
		for (OrderDetail orderItem : orderDetailList) {
			count += delete(orderItem);
		}
		return count;
	}

	@Override
	public int update(OrderDetail orderItem) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE order_detail "
					+ "SET "
					+ "orderId = ?, productId = ?, numOrderDetail = ?, coverPrice = ?, "
					+ "discount = ?, realPrice = ?, vat = ?, total = ? "
					+ "WHERE orderDetailId = ?;";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, orderItem.getOrder().getOrderId());
			st.setString(2, orderItem.getProduct().getProductId());
			st.setInt(3, orderItem.getNumOrderDetail());
			st.setDouble(4, orderItem.getCoverPrice());
			st.setDouble(5, orderItem.getDiscount());
			st.setDouble(6, orderItem.getRealPrice());
			st.setDouble(7, orderItem.getVat());
			st.setDouble(8, orderItem.getTotal());
			st.setString(9, orderItem.getOrderDetailId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int updateAll(ArrayList<OrderDetail> orderDetailList) {
		int count = 0;
		for (OrderDetail orderItem : orderDetailList) {
			count += update(orderItem);
		}
		return count;
	}

}
