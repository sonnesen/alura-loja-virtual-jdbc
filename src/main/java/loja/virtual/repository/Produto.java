package loja.virtual.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Produto {

	private int id;
	private String nome;
	private String descricao;

	public Produto(ResultSet rs) {
		try {
			this.id = rs.getInt("id");
			this.nome = rs.getString("nome");
			this.descricao = rs.getString("descricao");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
