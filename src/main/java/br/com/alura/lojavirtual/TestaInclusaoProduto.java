package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import br.com.alura.lojavirtual.dao.ProdutoDao;
import br.com.alura.lojavirtual.model.Produto;
import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaInclusaoProduto {

	public static void main(String[] args) {
		List<Produto> produtos = criarListaDeProdutos();

		try (Connection connection = new DBConnectionFactory().getConnection()) {
			ProdutoDao produtoDao = new ProdutoDao(connection);
			for (Produto produto : produtos) {
				Produto novo = produtoDao.salvar(produto);
				System.out.println(MessageFormat.format("Novo produto salvo: {0}", novo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static List<Produto> criarListaDeProdutos() {
		Produto smartTV = new Produto("SmartTV", "Smart TV 45 polegadas");
		Produto calculadora = new Produto("Calculadora", "Calculadora HP 12C");
		Produto mouse = new Produto("Mouse", "Mouse sem fio");

		List<Produto> produtos = Arrays.asList(smartTV, calculadora, mouse);

		return produtos;
	}

}
