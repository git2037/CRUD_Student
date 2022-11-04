package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	public static Connection getJDBCConnection() {

		final String url = "jdbc:mysql://localhost:3306/jdbc";
		final String user = "root";
		final String password = "At170234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		Connection connection = getJDBCConnection();

		if (connection != null) {
			System.out.println("Access");
		} else {
			System.out.println("Fail");
		}
	}
}
