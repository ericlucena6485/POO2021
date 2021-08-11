package programa;

import colecoes.ListaList;
import entidade.Contato;

public class Programa {

	public static void main(String[] args) {
		
		Contato c1 = new Contato();
		c1.setNome("Eric");
		c1.setTelefone(64545);
		
		Contato c2 = new Contato();
		c2.setNome("Eric lenin");
		c2.setTelefone(78);
		
		Contato c3 = new Contato();
		c3.setNome("Eric lucena");
		c3.setTelefone(475);
		
		ListaList lista1 = new ListaList();
		lista1.addContato(c1);
		lista1.addContato(c2);
		lista1.addContato(c3);
	
		
		lista1.listaContatos();
		
		lista1.removeContato(c1);
		
		lista1.listaContatos();
		
		lista1.retornContato(c1);
		
		System.out.println(lista1.retornContato(c2));
		
		lista1.retornaTamanhoLista();
	}

}
