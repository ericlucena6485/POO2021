package entities.abstracts;

public abstract class Pessoa {
	private String endere�o;
	private String email;
	private String telefone;
	
	public String getEndereco() {
		return endere�o;
	}
	public void setEndereco(String endere�o) {
		this.endere�o = endere�o;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
