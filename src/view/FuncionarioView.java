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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import controler.FuncionarioController;
import entities.Funcionario;
import entities.enums.Status;
import view.components.CustomButton;

public class FuncionarioView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colunas = { "Nome", "Cpf", "Sexo", "Data nascimento", "Email", "Telefone", "Endereço",
			"Data contratacao", "CTPS", "Salário" };
	private List<JComponent> inputs = new ArrayList<JComponent>();
	private String lastName = "";
	private JComponent input;
	private DefaultTableModel model;
	private JTable table;

	public FuncionarioView() {
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
		this.listarFuncionarios(model);
		JPanel panel = new JPanel();
		this.addInputs(panel);
		GridLayout layout2 = new GridLayout(11, 1);
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
					if (textField.getName().equalsIgnoreCase("cpf")) {
						if (textField.getText().length() == 11) {
							String ds = textField.getText();
							String d1, d2, d3, d4;
							d1 = ds.substring(0, 3);
							d2 = ds.substring(3, 6);
							d3 = ds.substring(6, 9);
							d4 = ds.substring(9, 11);
							String formatedCpf = d1 + "." + d2 + "." + d3 + "-" + d4;
							textField.setText(formatedCpf);
						} else if (textField.getText().length() < 11) {
							textField.setText("Cpf");
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
					String number = "0123456789/";
					if (name.equalsIgnoreCase("data nascimento")) {
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 7) {
								e.consume();
								return;
							}
							if (text.replace("/", "").length() != 0 && text.replace("/", "").length() % 2 == 0) {
								text += "/";
								textField.setText(text);
							}
						}
					} else if (name.equalsIgnoreCase("data contratacao")) {
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 7) {
								e.consume();
								return;
							}
							if (text.replace("/", "").length() != 0 && text.replace("/", "").length() % 2 == 0) {
								text += "/";
								textField.setText(text);
							}
						}
					} else if (name.equalsIgnoreCase("cpf")) {
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 10) {
								e.consume();
								return;
							}

						}
					} else if (name.equalsIgnoreCase("telefone")) {
						number = "0123456789";
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 10) {
								e.consume();
								return;
							}

						}
					} else if (name.equalsIgnoreCase("salário")) {
						number = "0123456789.,";
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 11) {
								e.consume();
								return;
							}

						}
					} else if (name.equalsIgnoreCase("ctps")) {
						number = "0123456789";
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 11) {
								e.consume();
								return;
							}

						}
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub

				}
			});
			input.setName(col);
			input.setPreferredSize(new Dimension(300, 40));
			inputs.add(input);
			panel.add(input);
		}

		CustomButton button = new CustomButton("CADASTRAR", Color.decode("#483D8B"), Color.decode("#836FFF"));
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Funcionario funcionario = new Funcionario();
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
					if (f.getName().equalsIgnoreCase("nome")) {
						funcionario.setNome(value);
					} else if (f.getName().equalsIgnoreCase("cpf")) {
						funcionario.setCpf(value);
					} else if (f.getName().equalsIgnoreCase("sexo")) {
						funcionario.setSexo(value);
					} else if (f.getName().equalsIgnoreCase("Data nascimento")) {
						try {
							funcionario.setDataNascimento(new SimpleDateFormat("dd/MM/yy").parse(value));
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null, "por favor digite a no formato dd/MM/yy",
									"Data inválida", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} else if (f.getName().equalsIgnoreCase("email")) {
						funcionario.setEmail(value);
					} else if (f.getName().equalsIgnoreCase("telefone")) {
						funcionario.setTelefone(value);
					} else if (f.getName().equalsIgnoreCase("endereço")) {
						funcionario.setEndereco(value);
					} else if (f.getName().equalsIgnoreCase("ctps")) {
						funcionario.setCtps(value);
					} else if (f.getName().equalsIgnoreCase("data contratacao")) {
						try {

							funcionario.setDataContratacao(new SimpleDateFormat("dd/MM/yy").parse(value));
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null,
									"Erro no campo Data de Contratação\npor favor digite a no formato dd/MM/yy",
									"Data inválida", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} else if (f.getName().equalsIgnoreCase("salário")) {
						try {

							funcionario.setSalario(Double.parseDouble(value));
						} catch (NumberFormatException e2) {

							JOptionPane.showMessageDialog(null,
									"Valor do salário inválido\ncoloque numeros reais válidos.", "Data inválida",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				if (!funcionario.getNome().equalsIgnoreCase("nome") && !funcionario.getCpf().equalsIgnoreCase("cpf")
						&& !funcionario.getSexo().equalsIgnoreCase("sexo")
						&& !funcionario.getEmail().equalsIgnoreCase("email")
						&& !funcionario.getEndereco().equalsIgnoreCase("endereço")
						&& !funcionario.getCtps().equalsIgnoreCase("ctps")
						&& !funcionario.getTelefone().equalsIgnoreCase("telefone")) {
					FuncionarioController funcionarioController = new FuncionarioController();
					boolean exist = funcionarioController.getFuncionarios().stream()
							.filter(f -> f.getCpf().equalsIgnoreCase(funcionario.getCpf())).findFirst().isPresent();
					if (!exist) {
						funcionarioController = new FuncionarioController();
						funcionarioController.cadastrarFuncionario(funcionario);
						listarFuncionarios(model);
						funcionarioController.mostrarFuncionario(funcionario);
					} else {
						JOptionPane.showMessageDialog(null, "Já existe um cliente cadastrado com esse CPF",
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

	@SuppressWarnings("deprecation")
	private void listarFuncionarios(DefaultTableModel model) {
		model.setNumRows(0);
		Set<Funcionario> funcionarios = new FuncionarioController().getFuncionarios();
		funcionarios.forEach(f -> {
			String nome = f.getNome();
			String cpf = f.getCpf();
			String sexo = f.getSexo();
			String nascimento;
			try {
				nascimento = f.getDataNascimento().toLocaleString();
			} catch (Exception e) {
				nascimento = "Não cadastrado";
			}
			String email = f.getEmail();
			String telefone = f.getTelefone();
			String endereco = f.getEndereco();
			String dataContratacao = f.getDataContratacao().toLocaleString();
			String ctps = f.getCtps();
			double salario = f.getSalario();
			model.addRow(new Object[] { nome, cpf, sexo, nascimento, email, telefone, endereco, dataContratacao, ctps,
					salario });
		});
	}

}
