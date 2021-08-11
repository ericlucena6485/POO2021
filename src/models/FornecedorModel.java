package models;

import java.util.Optional;
import java.util.Set;

import entities.Fornecedor;
import interfaces.CRUD;

public class FornecedorModel implements CRUD<Fornecedor> {

	@Override
	public void create(Fornecedor fornecedor) {
		DataBase.fornecedores.add(fornecedor);
	}

	@Override
	public Fornecedor read(Fornecedor fornecedor) {
		return DataBase.fornecedores.stream().filter(f -> f.getNome().equals(fornecedor.getNome())).findFirst().get();
	}

	public Fornecedor read(String cnpj) {
		Optional<Fornecedor> fornecedor = DataBase.fornecedores.stream().filter(f -> f.getCnpj().equalsIgnoreCase(cnpj)).findFirst();
		return fornecedor.isPresent() ? fornecedor.get() : null;
	}

	@Override
	public Set<Fornecedor> readAll() {
		return DataBase.fornecedores;
	}

}
