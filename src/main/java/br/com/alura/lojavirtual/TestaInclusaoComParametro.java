package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import br.com.alura.lojavirtual.model.Produto;
import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaInclusaoComParametro {

	public static void main(String[] args) {
		List<Produto> produtos = criarListaDeProdutos();

		try (Connection connection = new DBConnectionFactory().getConnection();
				PreparedStatement stm = criarPreparedStatement(connection)) {
			connection.setAutoCommit(false);
			try {
				adicionarProduto(produtos, stm);
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mostrarResultados(PreparedStatement stm) throws SQLException {
		try (ResultSet rs = stm.getGeneratedKeys()) {
			while (rs.next()) {
				System.out.println(MessageFormat.format("Produto de ID {0} criado com sucesso!", rs.getInt(1)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static PreparedStatement criarPreparedStatement(Connection connection) throws SQLException {
		String sql = "insert into produto (nome, descricao) values (?, ?)";

		PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		return stm;
	}

	private static List<Produto> criarListaDeProdutos() {
		Produto smartTV = new Produto("SmartTV", "Smart TV 45 polegadas");
		Produto calculadora = new Produto("Calculadora", "Calculadora HP 12C");
		Produto mouse = new Produto("Mouse", "Mouse sem fio");

		List<Produto> produtos = Arrays.asList(smartTV, calculadora, mouse);
		return produtos;
	}

	private static void adicionarProduto(List<Produto> produtos, PreparedStatement stm) throws SQLException {
		produtos.forEach(produto -> {
			try {
				stm.setString(1, produto.getNome());
				stm.setString(2, produto.getDescricao());

//				if ("Mouse".equals(produto.getNome())) {
//					throw new RuntimeException(
//							MessageFormat.format("Erro ao adicionar produto: {0}", produto.getNome()));
//				}

				stm.execute();
				mostrarResultados(stm);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
