package tarefanove;


public class cliente extends operacoes{

	private int codigo;
	private String nome;
	
    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void inserir() {
		System.out.println("nome: "+ nome);
		System.out.println("codigo: "+ codigo);
		System.out.println("dados do cliente inseridos com sucesso");
		
	}
    
    @Override
   	public void excluir() {
    	System.out.println("dados do cliente excluidos com sucesso");
   		
   	}
    @Override
   	public void localizar () {
    	System.out.println("dados do cliente localizados com sucesso");
   		
   	}
    
}
