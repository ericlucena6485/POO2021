package tarefaoitoexertres;

public class executando2 {

	public static void main(String[] args) {
		ProdutoImportado prodImp = new ProdutoImportado();
		prodImp.setNome("Iphone");
		prodImp.setPreco(5000.00);
		prodImp.calculaFrete();
		System.out.println(prodImp.toString());
		
		ProdutoNacional prodNac = new ProdutoNacional();
		prodNac.setNome("Iphone");
		prodNac.setPreco(5000.00);
		prodNac.calculaFrete();
		System.out.println(prodNac.toString());
	}
}