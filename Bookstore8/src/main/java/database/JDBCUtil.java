package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// Dang ky MYSQL Driver voi Driver Manager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// Cac thong so
			String url = "jdbc:mySQL://localhost:3306/bookstore";
			String username = "root";
			String password = "";

			// Thuc hien ket noi
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData dmd = (DatabaseMetaData) c.getMetaData();
				System.out.println(dmd.getDatabaseProductName());
				System.out.println(dmd.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}