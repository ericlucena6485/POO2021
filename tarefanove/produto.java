package tarefanove;

public class produto extends operacoes {
	private int numero;
	private String descricao;
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public void inserir() {
		System.out.println("dados do produto inseridos com sucesso");
		
	}

	@Override
	public void excluir() {
		System.out.println("dados do produto excluidos com sucesso");
		
	}

	@Override
	public void localizar() {
		System.out.println("dados do produto localizados com sucesso");
		
	}

}
