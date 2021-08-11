package aulasete;

public class pessoafisica extends pessoa {
	private static String rg;

	public pessoafisica(String nome, String rg) {
		super(nome);
	}

	public static void setrg(String rg) {
		pessoafisica.rg = rg;
	}

	public static String getrg() {
		return rg;
	}



}
