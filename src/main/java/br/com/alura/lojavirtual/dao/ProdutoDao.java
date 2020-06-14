package br.com.alura.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.lojavirtual.model.Produto;

public class ProdutoDao {

	private Connection connection;

	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}

	public Produto salvar(Produto produto) throws SQLException {
		String sql = "insert into produto (nome, descricao) values (?, ?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.execute();

			atualizarProduto(produto, stm);

			return produto;
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select id, nome, descricao from produto";

		try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
				produtos.add(produto);
			}
			return produtos;
		}
	}

	public void remover(int id) throws SQLException {
		String sql = "delete from produto where id = ?";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setInt(1, 2);
			stm.execute();

			int totalDeProdutosRemovidos = stm.getUpdateCount();

			String mensagem = "Total de produtos removidos: {0}";
			System.out.println(MessageFormat.format(mensagem, totalDeProdutosRemovidos));
		}
	}

	private void atualizarProduto(Produto produto, PreparedStatement stm) {
		try (ResultSet rs = stm.getGeneratedKeys()) {
			while (rs.next()) {
				produto.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
