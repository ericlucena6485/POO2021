package entities.abstracts;

public abstract class Pessoa {
	private String endereço;
	private String email;
	private String telefone;
	
	public String getEndereco() {
		return endereço;
	}
	public void setEndereco(String endereço) {
		this.endereço = endereço;
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
