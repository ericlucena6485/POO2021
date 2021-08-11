package models;

import java.util.Set;

import entities.Cliente;
import interfaces.CRUD;

// operações lógicas e comunicação com banco de dados
public class ClienteModel implements CRUD<Cliente> {

	@Override
	public void create(Cliente cliente) {
		DataBase.clientes.add(cliente);

	}

	@Override
	public Cliente read(Cliente cliente) {
		return DataBase.clientes.stream().filter(c -> c.getCpf().equals(cliente.getCpf())).findFirst().get();
	}

	@Override
	public Set<Cliente> readAll() {
		return DataBase.clientes;
	}
}
