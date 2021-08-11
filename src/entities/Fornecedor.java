package entities;

import entities.abstracts.PessoaJuridica;

public class Fornecedor extends PessoaJuridica {
	private String nome;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Fornecedor [nome=" + nome + ", telefone=" + telefone + "]";
	}
	
}
