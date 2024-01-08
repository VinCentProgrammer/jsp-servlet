package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;
import model.Category;
import model.Product;

public class ProductDAO implements DAOInterface<Product> {

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM product";

			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String productId = rs.getString("productId");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				int publicYear = rs.getInt("publicYear");
				double importPrice = rs.getDouble("importPrice");
				double rootPrice = rs.getDouble("rootPrice");
				double salePrice = rs.getDouble("salePrice");
				int number = rs.getInt("number");
				String catId = rs.getString("catId");
				String lang = rs.getString("lang");
				String description = rs.getString("description");

				Author author = new Author();
				author.setAuthorId(authorId);

				Category cat = new Category();
				cat.setCatId(catId);

				Product product = new Product(productId, title, author, publicYear, 
						importPrice, rootPrice, salePrice, number, cat, lang, description);
				result.add(product);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product selectById(Product t) {
		Product result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM product WHERE productId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, t.getProductId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String productId = rs.getString("productId");
				String title = rs.getString("title");
				String authorId = rs.getString("authorId");
				int publicYear = rs.getInt("publicYear");
				double importPrice = rs.getDouble("importPrice");
				double rootPrice = rs.getDouble("rootPrice");
				double salePrice = rs.getDouble("salePrice");
				int number = rs.getInt("number");
				String catId = rs.getString("catId");
				String lang = rs.getString("lang");
				String description = rs.getString("description");

				Author author = new Author();
				author.setAuthorId(authorId);

				Category cat = new Category();
				cat.setCatId(catId);

				result = new Product(productId, title, author, publicYear, importPrice, 
						rootPrice, salePrice, number, cat, lang, description);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Product product) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "INSERT INTO product " + "(productId, title, authorId, publicYear, importPrice, "
					+ "rootPrice, salePrice, number, catId, lang, description) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, product.getProductId());
			st.setString(2, product.getTitle());
			st.setString(3, product.getAuthor().getAuthorId());
			st.setInt(4, product.getPublicYear());
			st.setDouble(5, product.getImportPrice());
			st.setDouble(6, product.getRootPrice());
			st.setDouble(7, product.getSalePrice());
			st.setInt(8, product.getNumber());
			st.setString(9, product.getCategory().getCatId());
			st.setString(10, product.getLang());
			st.setString(11, product.getDescription());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<Product> products) {
		int count = 0;
		for (Product product : products) {
			count += insert(product);
		}
		return count;
	}

	@Override
	public int delete(Product product) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "DELETE FROM product " + "WHERE productId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, product.getProductId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<Product> products) {
		int count = 0;
		for (Product product : products) {
			count += delete(product);
		}
		return count;
	}

	@Override
	public int update(Product product) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE product SET "
					+ "title = ?, authorId = ?, publicYear = ?, importPrice = ?, rootPrice = ?, "
					+ "salePrice = ?, number = ?, catId = ?, lang = ?, description = ? "
					+ "WHERE productId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, product.getTitle());
			st.setString(2, product.getAuthor().getAuthorId());
			st.setInt(3, product.getPublicYear());
			st.setDouble(4, product.getImportPrice());
			st.setDouble(5, product.getRootPrice());
			st.setDouble(6, product.getSalePrice());
			st.setInt(7, product.getNumber());
			st.setString(8, product.getCategory().getCatId());
			st.setString(9, product.getLang());
			st.setString(10, product.getDescription());
			st.setString(11, product.getProductId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int updateAll(ArrayList<Product> products) {
		int count = 0;
		for (Product product : products) {
			count += update(product);
		}
		return count;
	}

}
