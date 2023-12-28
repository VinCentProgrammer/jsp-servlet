package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;

public class AuthorDAO implements DAOInterface<Author> {

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> result = new ArrayList<Author>();
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM author";

			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String authorId = rs.getString("authorId");
				String fullname = rs.getString("fullname");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String bio = rs.getString("bio");

				Author author = new Author(authorId, fullname, dateOfBirth, bio);
				result.add(author);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Author selectById(Author t) {
		Author result = null;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "SELECT * FROM author WHERE authorId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, t.getAuthorId());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String authorId = rs.getString("authorId");
				String fullname = rs.getString("fullname");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String bio = rs.getString("bio");

				result = new Author(authorId, fullname, dateOfBirth, bio);
			}

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Author author) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "INSERT INTO author (authorId, fullname, dateOfBirth, bio) "
					+ "VALUES (?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, author.getAuthorId());
			st.setString(2, author.getFullname());
			st.setDate(3, author.getDateOfBirth());
			st.setString(4, author.getBio());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<Author> authors) {
		int count = 0;
		for (Author author : authors) {
			count += insert(author);
		}
		return count;
	}

	@Override
	public int delete(Author author) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String query = "DELETE FROM author " + "WHERE authorId = ?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, author.getAuthorId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<Author> authors) {
		int count = 0;
		for (Author author : authors) {
			count += delete(author);
		}
		return count;
	}

	@Override
	public int update(Author author) {
		int check = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE author SET fullname = ?, dateOfBirth = ?, bio = ? WHERE authorId = ?;";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, author.getFullname());
			st.setDate(2, author.getDateOfBirth());
			st.setString(3, author.getBio());
			st.setString(4, author.getAuthorId());
			check = st.executeUpdate();

			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int updateAll(ArrayList<Author> authors) {
		int count = 0;
		for (Author author : authors) {
			count += update(author);
		}
		return count;
	}

}
