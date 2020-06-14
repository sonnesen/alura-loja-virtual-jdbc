package loja.virtual.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

public class TestaInclusao {

	public static void main(String[] args) {
		try (Connection connection = new DBConnectionFactory().getConnection();
				Statement stm = connection.createStatement()) {

			stm.execute("insert into produto (nome, descricao) values ('Mouse', 'Mouse sem fio')",
					Statement.RETURN_GENERATED_KEYS);

			try (ResultSet rs = stm.getGeneratedKeys()) {
				while (rs.next()) {
					System.out.println(MessageFormat.format("Produto de ID {0} criado com sucesso!", rs.getInt(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
