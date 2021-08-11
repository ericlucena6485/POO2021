package entities;
import entities.abstracts.PessoaFisica;
import entities.enums.Status;
public class Cliente extends PessoaFisica {
	private String dataCadastro;
	private double valorEmAberto;
	private Status status;
	private double limite;
	
	public double getLimite() {
		return limite;
	}
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		if(status == Status.antigo) {
			this.limite = 1000d;
		}else {
			this.limite = 499d;
		}
		this.status = status;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void dever(double valor) {
		if(valorEmAberto + valor <= limite) {
			valorEmAberto = valorEmAberto + valor;
		}else {
			System.out.println("compra ultrapassa seu limite");
		}
	}
	public void pagar(double valor) {
		if(valorEmAberto - valor < 0) {
			System.out.println("o valor a ser pago é maior do que o necessario");
		}else {
			valorEmAberto = valorEmAberto - valor;
			System.out.println("seu novo valor devendo é : " + valorEmAberto);
		}
	}
	@Override
	public String toString() {
		return "Cliente [dataCadastro=" + dataCadastro + ", valorEmAberto=" + valorEmAberto + ", status=" + status
				+ ", limite=" + limite + "]";
	}
	
}
