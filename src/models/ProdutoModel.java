package models;

import java.util.Set;

import entities.Produto;
import interfaces.CRUD;

public class ProdutoModel implements CRUD<Produto> {

	public void create(Produto produto) {
		DataBase.produtos.add(produto);
	}

	@Override
	public Produto read(Produto produto) {
		if(produto.getFornecedor() == null) {
			return null;
		}
		return DataBase.produtos.stream().filter(p -> p.getFornecedor().equals(produto.getFornecedor())).findFirst().get();
	}

	@Override
	public Set<Produto> readAll() {
		return DataBase.produtos;
	}

}
