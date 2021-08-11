package entities;
import java.util.Date;

import entities.abstracts.PessoaFisica;

public class Funcionario extends PessoaFisica {
	private String ctps; 
	private Date dataContratacao;
	private Double salario;
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [ctps=" + ctps + ", dataContratacao=" + dataContratacao + ", salario=" + salario + "]";
	}
	
}
