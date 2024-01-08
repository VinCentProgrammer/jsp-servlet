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
				String gender = rs.getString("gender");
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
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String purchaseAddress = rs.getString("purchaseAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean subscription = rs.getBoolean("subscription");
				String verifyCode = rs.getString("verifyCode");
				Date verifyExpire = rs.getDate("verifyExpire");
				boolean verifyStatus = rs.getBoolean("verifyStatus");
				String imgPath = rs.getString("imgPath");

				result = new Customer(customerId, username, password, fullname, gender, address, deliveryAddress,
						purchaseAddress, dateOfBirth, phoneNumber, email, subscription, verifyCode, verifyExpire,
						verifyStatus, imgPath);
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
			st.setString(5, customer.getGender());
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
			String query = "UPDATE customer SET " + "username = ?, password = ?, fullname = ?, gender = ?, "
					+ "address = ?, deliveryAddress = ?, purchaseAddress = ?, "
					+ "dateOfBirth = ?, phoneNumber = ?, email = ?, subscription = ? " + "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getUsername());
			st.setString(2, customer.getPassword());
			st.setString(3, customer.getFullname());
			st.setString(4, customer.getGender());
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

	public boolean checkExist(Customer c) {
		boolean ketQua = false;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM customer WHERE username=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getUsername());

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ketQua = true;
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public Customer selectUsernameAndPassCustomer(Customer c) {
		Customer result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM customer WHERE username = ? AND password = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, c.getUsername());
			st.setString(2, c.getPassword());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String purchaseAddress = rs.getString("purchaseAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean subscription = rs.getBoolean("subscription");
				String verifyCode = rs.getString("verifyCode");
				Date verifyExpire = rs.getDate("verifyExpire");
				boolean verifyStatus = rs.getBoolean("verifyStatus");

				result = new Customer(customerId, username, password, fullname, gender, address, deliveryAddress,
						purchaseAddress, dateOfBirth, phoneNumber, email, subscription, verifyCode, verifyExpire,
						verifyStatus);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Customer selectCustomerByPassword(Customer c) {
		Customer result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM customer WHERE password = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, c.getPassword());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String customerId = rs.getString("customerId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String gender = rs.getString("gender");
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

	public int updatePass(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE customer SET " + "password = ?" + "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getPassword());
			st.setString(2, customer.getCustomerId());

			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int updateInfo(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE customer SET " + "fullname = ?, gender = ?, "
					+ "address = ?, deliveryAddress = ?, purchaseAddress = ?, "
					+ "dateOfBirth = ?, phoneNumber = ?, email = ?, subscription = ? " + "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getFullname());
			st.setString(2, customer.getGender());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getDeliveryAddress());
			st.setString(5, customer.getPurchaseAddress());
			st.setDate(6, customer.getDateOfBirth());
			st.setString(7, customer.getPhoneNumber());
			st.setString(8, customer.getEmail());
			st.setBoolean(9, customer.isSubscription());
			st.setString(10, customer.getCustomerId());

			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int insertInformationVerify(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE customer SET " + "verifyCode = ?, verifyExpire = ?, verifyStatus = ? "
					+ "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getVerifyCode());
			st.setDate(2, customer.getVerifyExpire());
			st.setBoolean(3, customer.isVerifyStatus());
			st.setString(4, customer.getCustomerId());

			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int updateVerifyStatus(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE customer SET " + "verifyStatus = ? " + "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setBoolean(1, customer.isVerifyStatus());
			st.setString(2, customer.getCustomerId());

			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int updateImage(Customer customer) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE customer SET " + "imgPath = ? " + "WHERE customerId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, customer.getImgPath());
			st.setString(2, customer.getCustomerId());

			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

}
