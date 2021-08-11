package controler;

import java.util.Set;

import javax.swing.JOptionPane;

import entities.Fornecedor;
import models.FornecedorModel;

public class FornecedorController {
	public Set<Fornecedor> getFornecedores() {
		return new FornecedorModel().readAll();
	}

	public void cadastrarFornecedor(Fornecedor fornecedor) {
		FornecedorModel model = new FornecedorModel();
		model.create(fornecedor);
	}

	public void mostrarFornecedor(Fornecedor fornecedor) {
		FornecedorModel model = new FornecedorModel();
		Fornecedor f = model.read(fornecedor);
		JOptionPane.showMessageDialog(null,
				f.getRazaoSocial() + "\nCNPJ: " + f.getCnpj() + "\nFoi cadastrado no sistema!", "Usuário cadastrado",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public Fornecedor getFornecedorByCnpj(String cnpj) {
		FornecedorModel model = new FornecedorModel();
		Fornecedor f = model.read(cnpj);
		return f;
	}

}
