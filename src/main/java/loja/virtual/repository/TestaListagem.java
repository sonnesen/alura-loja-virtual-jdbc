package loja.virtual.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select id, nome, descricao from produto");

			while (rs.next()) {
				Produto produto = new Produto(rs);
				System.out.println(produto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
