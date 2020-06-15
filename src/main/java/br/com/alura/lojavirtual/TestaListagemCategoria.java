package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojavirtual.dao.CategoriaDao;
import br.com.alura.lojavirtual.model.Categoria;
import br.com.alura.lojavirtual.util.DBConnectionFactory;

public class TestaListagemCategoria {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			CategoriaDao dao = new CategoriaDao(connection);
			List<Categoria> categorias = dao.listar();
			categorias.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
