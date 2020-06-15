package br.com.alura.lojavirtual.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Categoria {

	@NonNull
	private Integer id;

	@NonNull
	private String nome;

	private List<Produto> produtos = new ArrayList<>();

	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
}
