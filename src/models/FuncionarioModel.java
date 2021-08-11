package models;

import java.util.Set;

import entities.Funcionario;
import interfaces.CRUD;

public class FuncionarioModel implements CRUD<Funcionario> {

	@Override
	public void create(Funcionario funcionario) {
		DataBase.funcionarios.add(funcionario);
	}

	@Override
	public Funcionario read(Funcionario funcionario) {
		return DataBase.funcionarios.stream().filter(r -> r.getCpf().equals(funcionario.getCpf())).findFirst().get();
	}

	@Override
	public Set<Funcionario> readAll() {
		return DataBase.funcionarios;
	}

}
