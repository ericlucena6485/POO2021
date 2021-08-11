package aulasete;

public class pessoajuridica extends pessoa {

	private static String cnpj;
	public pessoajuridica(String nome) {
		super(nome);
	}


	public static void setcnpj(String cnpj) {
		pessoajuridica.cnpj = cnpj;
	}

	public static String getcnpj() {
		return cnpj;
	}
}
