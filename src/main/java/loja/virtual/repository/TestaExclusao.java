package loja.virtual.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

public class TestaExclusao {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection()) {
			Statement stm = connection.createStatement();
			stm.execute("delete from produto where id > 2");

			int totalDeProdutosRemovidos = stm.getUpdateCount();
			String mensagem = "Total de produtos removidos: {0}";
			System.out.println(MessageFormat.format(mensagem, totalDeProdutosRemovidos));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
