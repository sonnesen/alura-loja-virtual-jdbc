package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojavirtual.dao.ProdutoDao;
import br.com.alura.lojavirtual.model.Produto;
import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaListagemProduto {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			ProdutoDao dao = new ProdutoDao(connection);
			List<Produto> produtos = dao.listar();
			produtos.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
