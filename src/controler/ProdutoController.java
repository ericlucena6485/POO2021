package controler;

import java.util.Set;

import javax.swing.JOptionPane;

import entities.Funcionario;
import entities.Produto;
import models.ProdutoModel;

public class ProdutoController {

	public Set<Produto> getProdutos() {
		return new ProdutoModel().readAll();
	}

	public void cadastrarProduto(Produto produto) {
		ProdutoModel model = new ProdutoModel();
		model.create(produto);
	}

	public void mostrarProdutos(Produto produto) {
		if (produto.getFornecedor() == null) {
			return;
		}
		ProdutoModel model = new ProdutoModel();
		Produto f = model.read(produto);
		JOptionPane.showMessageDialog(null,
				f.getNomeProduto() + "\nFoi cadastrado no sistema!\nFornecedor: " + f.getFornecedor().getNome(),
				"Usuário cadastrado", JOptionPane.INFORMATION_MESSAGE);
	}
}
