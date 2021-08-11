package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controler.FornecedorController;
import entities.Fornecedor;
import entities.enums.Status;
import view.components.CustomButton;

public class FornecedorView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8097884944791546962L;

	private String[] colunas = { "Razão social", "CNPJ", "Nome", "Telefone", "Email", "Endereço" };
	private List<JComponent> inputs = new ArrayList<JComponent>();
	private String lastName = "";
	private JComponent input;
	private DefaultTableModel model;
	private JTable table;

	public FornecedorView() {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		this.setLayout(layout);
		this.setBackground(Color.LIGHT_GRAY);
		model = new DefaultTableModel();
		table = new JTable(model);
		for (String col : colunas) {
			model.addColumn(col);
		}
		JScrollPane brl = new JScrollPane(table);
		brl.setPreferredSize(new Dimension(700, 426));
		this.add(brl);
		this.listarFornecedores(model);
		JPanel panel = new JPanel();
		this.addInputs(panel);
		GridLayout layout2 = new GridLayout(7, 1);
		panel.setLayout(layout2);
		panel.setBackground(Color.RED);
		this.add(panel);
		this.setVisible(false);
	}

	private void addInputs(JPanel panel) {
		for (String col : colunas) {
			input = new JTextField(col);
			input.addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					JTextField textField = ((JTextField) e.getComponent());
					if (textField.getName().equalsIgnoreCase("cnpj")) {
						if (textField.getText().length() == 14) {
							String ds = textField.getText();
							String d1, d2, d3, d4, d5;
							d1 = ds.substring(0, 2);
							d2 = ds.substring(2, 5);
							d3 = ds.substring(5, 8);
							d4 = ds.substring(9, 12);
							d5 = ds.substring(12, 14);
							String formatedCnpj = d1 + "." + d2 + "." + d3 + "/" + d4 + "-" + d5;
							textField.setText(formatedCnpj);
						} else if (textField.getText().length() < 14) {
							textField.setText("CNPJ");
						}
					}
					if (textField.getName().equalsIgnoreCase("telefone")) {
						if (textField.getText().length() < 11) {
							textField.setText("telefone");
						} else {
							if (textField.getText().length() == 11) {
								String ds = textField.getText();
								String ddd = ds.substring(0, 2);
								String n1 = ds.substring(2, 7);
								String n2 = ds.substring(7, 11);
								String formatedNumber = "(" + ddd + ") " + n1 + "-" + n2;
								textField.setText(formatedNumber);
							}
						}
					}
					if (textField.getText().equalsIgnoreCase("")) {
						textField.setText(lastName);
						return;
					}
				}

				@Override
				public void focusGained(FocusEvent e) {
					JTextField textField = ((JTextField) e.getComponent());
					lastName = textField.getText();
					textField.setText("");
					return;
				}
			});
			input.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
					JTextField textField = ((JTextField) e.getComponent());
					String name = textField.getName();
					String key = String.valueOf(e.getKeyChar());
					String number = "0123456789";
					if (name.equalsIgnoreCase("cnpj")) {
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 13) {
								e.consume();
								return;
							}

						}
					} else if (name.equalsIgnoreCase("telefone")) {
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 10) {
								e.consume();
								return;
							}

						}
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}

				@Override
				public void keyPressed(KeyEvent e) {
				}
			});

			if (!col.equalsIgnoreCase("Status") && !col.equalsIgnoreCase("limite")
					&& !col.equalsIgnoreCase("data cadastro")) {
				input.setName(col);
				input.setPreferredSize(new Dimension(300, 40));
				inputs.add(input);
				panel.add(input);
			}
		}
		CustomButton button = new CustomButton("CADASTRAR", Color.decode("#483D8B"), Color.decode("#836FFF"));
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				inputs.forEach(f -> {
					String value = "";
					try {
						JTextField textField = (JTextField) f;
						value = textField.getText();
					} catch (Exception e2) {
						@SuppressWarnings("unchecked")
						JComboBox<Status> statusField = (JComboBox<Status>) f;
						value = statusField.getSelectedItem().toString();
					}
					if (f.getName().equalsIgnoreCase("razão social")) {
						fornecedor.setRazaoSocial(value);
					} else if (f.getName().equalsIgnoreCase("cnpj")) {
						fornecedor.setCnpj(value);
					} else if (f.getName().equalsIgnoreCase("nome")) {
						fornecedor.setNome(value);
					} else if (f.getName().equalsIgnoreCase("telefone")) {
						fornecedor.setTelefone(value);
					} else if (f.getName().equalsIgnoreCase("email")) {
						fornecedor.setEmail(value);
					} else if (f.getName().equalsIgnoreCase("endereço")) {
						fornecedor.setEndereco(value);
					}
				});
				if (!fornecedor.getRazaoSocial().equalsIgnoreCase("razão social")
						&& !fornecedor.getCnpj().equalsIgnoreCase("cnpj")
						&& !fornecedor.getNome().equalsIgnoreCase("nome")
						&& !fornecedor.getEmail().equalsIgnoreCase("email")
						&& !fornecedor.getEndereco().equalsIgnoreCase("endereço")
						&& !fornecedor.getTelefone().equalsIgnoreCase("telefone")) {
					FornecedorController fornecedorController = new FornecedorController();
					boolean exist = fornecedorController.getFornecedores().stream()
							.filter(f -> f.getCnpj().equalsIgnoreCase(fornecedor.getCnpj())).findFirst().isPresent();
					if (!exist) {
						fornecedorController = new FornecedorController();
						fornecedorController.cadastrarFornecedor(fornecedor);
						listarFornecedores(model);
						fornecedorController.mostrarFornecedor(fornecedor);
					} else {
						JOptionPane.showMessageDialog(null, "Já existe um fornecedor cadastrado com esse CNPJ",
								"Redundância de dados", JOptionPane.ERROR_MESSAGE);
					}
				} else {

					JOptionPane.showMessageDialog(null, "Preencha os dados!", "Dados incompletos",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(button);

	}

	private void listarFornecedores(DefaultTableModel model) {
		model.setNumRows(0);
		Set<Fornecedor> funcionarios = new FornecedorController().getFornecedores();
		funcionarios.forEach(f -> {
			String razaoSocial = f.getRazaoSocial();
			String cnpj = f.getCnpj();
			String nome = f.getNome();
			String email = f.getEmail();
			String telefone = f.getTelefone();
			String endereco = f.getEndereco();
			model.addRow(new Object[] { razaoSocial, cnpj, nome, telefone, email, endereco });
		});
	}

}
