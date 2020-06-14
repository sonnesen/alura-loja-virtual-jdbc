package loja.virtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;

public class TestaExclusao {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection();
				PreparedStatement stm = connection.prepareStatement("delete from produto where id > ?")) {
			stm.setInt(1, 2);
			stm.execute();

			int totalDeProdutosRemovidos = stm.getUpdateCount();

			String mensagem = "Total de produtos removidos: {0}";
			System.out.println(MessageFormat.format(mensagem, totalDeProdutosRemovidos));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
