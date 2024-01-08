package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Order;

public class OrderDAO implements DAOInterface<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> result = new ArrayList<Order>();
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM order";

			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String orderId = rs.getString("orderId");
				String customerId = rs.getString("customerId");
				String deliveryAddress = rs.getString("deliveryAddress");
				String address = rs.getString("address");
				String statusOrder = rs.getString("statusOrder");
				String payment = rs.getString("payment");
				boolean statusPayment = rs.getBoolean("statusPayment");
				double totalPayment = rs.getDouble("totalPayment");
				double remainPayment = rs.getDouble("remainPayment");
				Date orderDate = rs.getDate("orderDate");
				Date shipDate = rs.getDate("shipDate");

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				Order order = new Order(orderId, customer, deliveryAddress, address, statusOrder, payment,
						statusPayment, totalPayment, remainPayment, orderDate, shipDate);
				result.add(order);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order selectById(Order t) {
		Order result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM order WHERE orderId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, t.getOrderId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String orderId = rs.getString("orderId");
				String customerId = rs.getString("customerId");
				String deliveryAddress = rs.getString("deliveryAddress");
				String address = rs.getString("address");
				String statusOrder = rs.getString("statusOrder");
				String payment = rs.getString("payment");
				boolean statusPayment = rs.getBoolean("statusPayment");
				double totalPayment = rs.getDouble("totalPayment");
				double remainPayment = rs.getDouble("remainPayment");
				Date orderDate = rs.getDate("orderDate");
				Date shipDate = rs.getDate("shipDate");

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				result = new Order(orderId, customer, deliveryAddress, address, statusOrder, 
						payment, statusPayment, totalPayment, remainPayment, orderDate, shipDate);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Order order) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "INSERT INTO order " 
					+ "(orderId, customerId, deliveryAddress, address, statusOrder, "
					+ "payment, statusPayment, totalPayment, remainPayment, orderDate, shipDate) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, order.getOrderId());
			st.setString(2, order.getCustomer().getCustomerId());
			st.setString(3, order.getDeliveryAaddress());
			st.setString(4, order.getAddress());
			st.setString(5, order.getStatusOrder());
			st.setString(6, order.getPayment());
			st.setString(7, order.getStatusOrder());
			st.setDouble(8, order.getTotalPayment());
			st.setDouble(9, order.getRemainPayment());
			st.setDate(10, order.getOrderDate());
			st.setDate(11, order.getShipDate());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<Order> orders) {
		int count = 0;
		for (Order order : orders) {
			count += insert(order);
		}
		return count;
	}

	@Override
	public int delete(Order order) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "DELETE FROM order " + "WHERE orderId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, order.getOrderId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<Order> orders) {
		int count = 0;
		for (Order order : orders) {
			count += delete(order);
		}
		return count;
	}

	@Override
	public int update(Order order) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE order "
					+ "SET "
					+ "customerId = ?, deliveryAddress = ?, address = ?, statusOrder = ?, "
					+ "payment = ?, statusPayment = ?, totalPayment = ?, remainPayment = ?, "
					+ "orderDate = ?, shipDate = ? "
					+ "WHERE orderId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, order.getCustomer().getCustomerId());
			st.setString(2, order.getDeliveryAaddress());
			st.setString(3, order.getAddress());
			st.setString(4, order.getStatusOrder());
			st.setString(5, order.getPayment());
			st.setString(6, order.getStatusOrder());
			st.setDouble(7, order.getTotalPayment());
			st.setDouble(8, order.getRemainPayment());
			st.setDate(9, order.getOrderDate());
			st.setDate(10, order.getShipDate());
			st.setString(11, order.getOrderId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int updateAll(ArrayList<Order> orders) {
		int count = 0;
		for (Order order : orders) {
			count += update(order);
		}
		return count;
	}

}
