package entities;

import controler.FornecedorController;

public class Produto {
	private Fornecedor fornecedor;
	private int quantEstoque;
	private double valor;
	private String nomeProduto;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Override
	public String toString() {
		return "Produto [fornecedor=" + fornecedor + ", quantEstoque=" + quantEstoque + ", valor=" + valor
				+ ", nomeProduto=" + nomeProduto + "]";
	}

}
