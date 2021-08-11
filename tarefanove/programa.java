package tarefanove;

public class programa {

	public static void main(String[] args) {
		cliente cliente = new cliente();
		cliente.setNome("eric");
		cliente.setCodigo(123);
		cliente.inserir();
		//cliente.excluir();
		//cliente.localizar();
		
		System.out.println();
		
		fornecedor  fornecedor = new fornecedor();
		fornecedor.inserir();
		fornecedor.excluir();
		fornecedor.localizar();
		
		System.out.println();
		
		produto produto = new produto();
		produto.inserir();
		produto.excluir();
		produto.localizar();
		
	}

}
