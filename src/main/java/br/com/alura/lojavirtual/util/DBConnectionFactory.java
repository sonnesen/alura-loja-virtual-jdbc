package br.com.alura.lojavirtual.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnectionFactory {

	private DataSource dataSource;

	private final String DB_URL = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC";
	private final String DB_USER = "root";
	private final String DB_USER_PWD = "root";

	public DBConnectionFactory() throws SQLException {
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl(DB_URL);
		pooledDataSource.setUser(DB_USER);
		pooledDataSource.setPassword(DB_USER_PWD);
		pooledDataSource.setMaxPoolSize(15);

		this.dataSource = pooledDataSource;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
