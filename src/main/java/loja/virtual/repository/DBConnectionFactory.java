package loja.virtual.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

	private Connection connection;
	private final String DB_URL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC";
	private final String DB_USER = "root";
	private final String DB_USER_PWD = "root";

	public DBConnectionFactory() throws SQLException {
		connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PWD);
	}

	public Connection getConnection() {
		return connection;
	}
}
