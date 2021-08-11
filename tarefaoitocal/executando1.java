package tarefaoitocal;

public class executando1 {

	public static void main(String[] args) {
		Soma soma2 = new Soma();
		Soma soma = new Soma();
		System.out.println(soma.calcula(10, 5));
		
		Subtracao subtracao = new Subtracao();
		System.out.println(subtracao.calcula(10, 5));

		multiplicacao Multiplicacao = new multiplicacao();
		System.out.println(Multiplicacao.calcula(10,5));
		
		Divisao divisao = new Divisao();
		System.out.println(divisao.calcula(10, 5));
	}
}
