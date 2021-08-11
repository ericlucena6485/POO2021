package aulasete;

public class main {
	public static void main(String[] args) {
		
		pessoa pessoa1 = new pessoa("joao");
	
		pessoa1.setNome("eric");
		pessoafisica.setrg("54785");
		funcionario.setcartao("4785585958785488");
		
		System.out.println("Pessoa Fisica");
		System.out.println("Nome da pessoa1: " +pessoa1.getNome());
		System.out.println("RG: "+pessoafisica.getrg());
		System.out.println("Numero do Cartao de funcionario: "+ funcionario.getcartao());
		
		
		pessoa pessoa2 = new pessoa("ana");
		pessoa2.setNome("FRUTAS");
		pessoajuridica.setcnpj("45454500015656");
		
		System.out.println("Pessoa juridica");
		System.out.println("\nNome da pessoa2: " +pessoa2.getNome());
		System.out.println("CNPJ: "+pessoajuridica.getcnpj());
	}
}
