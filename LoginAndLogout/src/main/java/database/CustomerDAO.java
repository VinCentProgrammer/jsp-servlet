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
        Customer ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM customer WHERE username=? and password=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setString(2, c.getPassword());

            System.out.println(c.getUsername());
            System.out.println(c.getPassword());
            System.out.println(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
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

                ketQua = new Customer(customerId, username, password, fullname, gender, address, deliveryAddress,
                        purchaseAddress, dateOfBirth, phoneNumber, email, subscription);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
