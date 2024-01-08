package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;

public class CategoryDAO implements DAOInterface<Category> {

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> result = new ArrayList<Category>();
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM category";

			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String catId = rs.getString("catId");
				String catName = rs.getString("catName");

				Category cat = new Category(catId, catName);
				result.add(cat);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Category selectById(Category t) {
		Category result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM category WHERE catId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, t.getCatId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String catId = rs.getString("catId");
				String catName = rs.getString("catName");

				result = new Category(catId, catName);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Category cat) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "INSERT INTO category (catId, catName) "
					+ "VALUES (?, ?)";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, cat.getCatId());
			st.setString(2, cat.getCatName());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<Category> cats) {
		int count = 0;
		for (Category cat : cats) {
			count += insert(cat);
		}
		return count;
	}

	@Override
	public int delete(Category cat) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "DELETE FROM cat " + "WHERE catId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, cat.getCatId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<Category> cats) {
		int count = 0;
		for (Category cat : cats) {
			count += delete(cat);
		}
		return count;
	}

	@Override
	public int update(Category cat) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE category SET catName = ? WHERE catId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, cat.getCatId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int updateAll(ArrayList<Category> cats) {
		int count = 0;
		for (Category cat : cats) {
			count += update(cat);
		}
		return count;
	}

}
