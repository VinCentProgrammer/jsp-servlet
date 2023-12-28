package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM customer";

			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				boolean gender = rs.getBoolean("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String purchaseAddress = rs.getString("purchaseAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean subscription = rs.getBoolean("subscription");

				Customer customer = new Customer(customerId, username, password, fullname, gender, address,
						deliveryAddress, purchaseAddress, dateOfBirth, phoneNumber, email, subscription);
				result.add(customer);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer selectById(Customer t) {
		Customer result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM customer WHERE customerId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, t.getCustomerId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				boolean gender = rs.getBoolean("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String purchaseAddress = rs.getString("purchaseAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean subscription = rs.getBoolean("subscription");

				result = new Customer(customerId, username, password, fullname, gender, address, deliveryAddress,
						purchaseAddress, dateOfBirth, phoneNumber, email, subscription);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "INSERT INTO customer "
					+ "(customerId, username, password, fullname, gender, address, deliveryAddress, "
					+ "purchaseAddress, dateOfBirth, phoneNumber, email, subscription) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getCustomerId());
			st.setString(2, customer.getUsername());
			st.setString(3, customer.getPassword());
			st.setString(4, customer.getFullname());
			st.setBoolean(5, customer.isGender());
			st.setString(6, customer.getAddress());
			st.setString(7, customer.getDeliveryAddress());
			st.setString(8, customer.getPurchaseAddress());
			st.setDate(9, customer.getDateOfBirth());
			st.setString(10, customer.getPhoneNumber());
			st.setString(11, customer.getEmail());
			st.setBoolean(12, customer.isSubscription());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<Customer> customers) {
		int count = 0;
		for (Customer customer : customers) {
			count += insert(customer);
		}
		return count;
	}

	@Override
	public int delete(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "DELETE FROM customer " + "WHERE customerId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getCustomerId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<Customer> customers) {
		int count = 0;
		for (Customer customer : customers) {
			count += delete(customer);
		}
		return count;
	}

	@Override
	public int update(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE customer SET "
					+ "username = ?, password = ?, fullname = ?, gender = ?, "
					+ "address = ?, deliveryAddress = ?, purchaseAddress = ?, "
					+ "dateOfBirth = ?, phoneNumber = ?, email = ?, subscription = ? "
					+ "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getUsername());
			st.setString(2, customer.getPassword());
			st.setString(3, customer.getFullname());
			st.setBoolean(4, customer.isGender());
			st.setString(5, customer.getAddress());
			st.setString(6, customer.getDeliveryAddress());
			st.setString(7, customer.getPurchaseAddress());
			st.setDate(8, customer.getDateOfBirth());
			st.setString(9, customer.getPhoneNumber());
			st.setString(10, customer.getEmail());
			st.setBoolean(11, customer.isSubscription());
			st.setString(12, customer.getCustomerId());

			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int updateAll(ArrayList<Customer> customers) {
		int count = 0;
		for (Customer customer : customers) {
			count += update(customer);
		}
		return count;
	}

}
