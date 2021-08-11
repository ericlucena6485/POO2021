package tarefaoitoexertres;

public class Produto {

	private String nome;
	private  Double preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double calculaFrete() {
		return 0.0;
	}

	public Double total(){
		return preco + calculaFrete();
	}
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", total()=" + total() + "]";
	}
	
}

