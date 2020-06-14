package loja.virtual.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			System.out.println("Teste conexão");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
