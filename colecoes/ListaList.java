package colecoes;

import java.util.ArrayList;
import java.util.List;
import entidade.Contato;

public class ListaList{
	
	/*
	 * CRUD - create - read - update - delete
	 */
	
	List<Contato> contatos = new ArrayList<>();
	
	public void addContato(Contato contato) {
		contatos.add(contato);
	}
	
	public void removeContato(Contato contato) {
		if(verificaContato(contato)) {
			contatos.remove(contato);
	}else {
		System.out.println("Contato n cadastrado!");
	}
}
	
	public boolean verificaContato(Contato contato) {
		if(contatos.contains(contato)) {
			return true;
		}else {
			return false;
		}
	}
	
	public String retornContato(Contato contato) {
		if(contatos.contains(contato)) {
			return "Contato" + contato.getNome()+ "Encontrado!";
		}else {
			return "Contato: " + contato.getNome()+"Não encontrado";
		}
	}
	
	public void retornaTamanhoLista() {
		System.out.println("Tamanho da lista de contatos: " + contatos.size());
	}
	
	public void listaContatos() {
		if(contatos.isEmpty()) {
			System.out.println("Lista Vazia!");
		}else {
			for(Contato c: contatos) {
				System.out.println("Contato posição: " + contatos.indexOf(c));
				System.out.println(c.toString());
				System.out.println();
			  }
			}
		}
}
