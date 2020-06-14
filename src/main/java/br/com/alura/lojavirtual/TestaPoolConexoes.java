package br.com.alura.lojavirtual;

import java.sql.SQLException;

import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		DBConnectionFactory connectionFactory = new DBConnectionFactory();

		for (int i = 0; i < 20; i++) {
			connectionFactory.getConnection();
		}

	}
}
