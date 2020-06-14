package loja.virtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

public class TestaInclusaoComParametro {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			String nome = "Mouse";
			String descricao = "Mouse sem fio";
			String sql = "insert into produto (nome, descricao) values (?, ?)";

			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.execute();

			ResultSet rs = stm.getGeneratedKeys();

			while (rs.next()) {
				System.out.println(MessageFormat.format("Produto de ID {0} criado com sucesso!", rs.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
