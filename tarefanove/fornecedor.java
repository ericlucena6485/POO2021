package tarefanove;

public class fornecedor extends operacoes{
	private String cnpj;
	private String razaoSocial;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public void inserir() {
		System.out.println("dados do fornecedor inseridos com sucesso");
		
	}

	@Override
	public void excluir() {
		System.out.println("dados do fornecedor excluidos com sucesso");
		
	}

	@Override
	public void localizar() {
		System.out.println("dados do fornecedor localizados com sucesso");
		
	}
}
