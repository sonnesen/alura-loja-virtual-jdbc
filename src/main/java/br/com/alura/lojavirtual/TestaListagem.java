package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.lojavirtual.model.Produto;
import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection();
				PreparedStatement stm = connection.prepareStatement("select id, nome, descricao from produto");
				ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
