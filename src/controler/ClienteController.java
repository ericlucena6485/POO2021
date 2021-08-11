package controler;

import java.util.Set;

import javax.swing.JOptionPane;

import entities.Cliente;
import models.ClienteModel;

public class ClienteController {

	public Set<Cliente> getClientes() {
		return new ClienteModel().readAll();
	}

	public void cadastrarCliente(Cliente cliente) {
		ClienteModel model = new ClienteModel();
		model.create(cliente);
	}

	public void mostrarCliente(Cliente cliente) {
		ClienteModel model = new ClienteModel();
		Cliente cli = model.read(cliente);

		JOptionPane.showMessageDialog(null, cli.getNome() + "\nFoi cadastrado no sistema!\nCPF: " + cli.getCpf(),
				"Usuário cadastrado", JOptionPane.INFORMATION_MESSAGE);
	}
}
