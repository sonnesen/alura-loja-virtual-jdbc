package loja.virtual.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

}
