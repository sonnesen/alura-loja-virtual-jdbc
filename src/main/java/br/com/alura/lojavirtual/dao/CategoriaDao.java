package br.com.alura.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.lojavirtual.model.Categoria;
import br.com.alura.lojavirtual.model.Produto;

public class CategoriaDao {

	private Connection connection;

	public CategoriaDao(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select id, nome from categoria";
		try (PreparedStatement stm = connection.prepareStatement(sql)){
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					categorias.add(categoria);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

	public List<Categoria> listarComProduto() {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select c.id, c.nome, p.id, p.nome, p.descricao "
				+ "from categoria c inner join produto p on c.id = p.categoria_id";
		try (PreparedStatement stm = connection.prepareStatement(sql)){
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					Produto produto = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));
					categoria.addProduto(produto);
					categorias.add(categoria);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}

}
