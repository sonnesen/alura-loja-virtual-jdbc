package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.lojavirtual.dao.ProdutoDao;
import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaExclusaoProduto {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			ProdutoDao dao = new ProdutoDao(connection);
			dao.remover(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
