package entidade;

public class Contato {
	
	private String nome;
	private int telefone;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + "]";
	}
	
	
	
}
