package controler;

import java.util.Set;

import javax.swing.JOptionPane;

import entities.Funcionario;
import models.FuncionarioModel;

public class FuncionarioController {
	public Set<Funcionario> getFuncionarios() {
		return new FuncionarioModel().readAll();
	}
	public void cadastrarFuncionario(Funcionario funcionario) {
		FuncionarioModel model = new FuncionarioModel();
		model.create(funcionario);
	}

	public void mostrarFuncionario(Funcionario funcionario) {
		FuncionarioModel model = new FuncionarioModel();		
		Funcionario f = model.read(funcionario);
		JOptionPane.showMessageDialog(null, f.getNome()  + "\nCTPS: " + f.getCtps() + "\nFoi cadastrado no sistema!",
				"Usuário cadastrado", JOptionPane.INFORMATION_MESSAGE);
	}

}
