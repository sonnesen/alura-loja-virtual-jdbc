package loja.virtual.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "root";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Teste conexão");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
