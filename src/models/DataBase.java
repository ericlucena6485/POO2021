package models;

import java.util.HashSet;
import java.util.Set;

import entities.Cliente;
import entities.Fornecedor;
import entities.Funcionario;
import entities.Produto;

//Simulando um banco de dados
//rodando na memória
class DataBase {
	static Set<Funcionario> funcionarios = new HashSet<Funcionario>();
	static Set<Cliente> clientes = new HashSet<Cliente>();
	static Set<Produto> produtos = new HashSet<Produto>();
	static Set<Fornecedor> fornecedores = new HashSet<Fornecedor>();
}
