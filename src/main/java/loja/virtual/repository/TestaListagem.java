package loja.virtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			PreparedStatement stm = connection.prepareStatement("select id, nome, descricao from produto");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto(rs);
				System.out.println(produto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
