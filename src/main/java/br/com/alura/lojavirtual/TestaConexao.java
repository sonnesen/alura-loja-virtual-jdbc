package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			System.out.println("Teste conexão");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
