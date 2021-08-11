package aulasete;

public class funcionario extends pessoafisica {

	private static String cartao;
	public funcionario(String nome) {
		super( nome, nome);
	}
	
	public static void setcartao(String cartao) {
		funcionario.cartao = cartao;
	}

	public static String getcartao() {
		return cartao;
	}
}