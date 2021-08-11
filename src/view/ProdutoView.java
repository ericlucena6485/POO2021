package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import controler.ClienteController;
import controler.FornecedorController;
import controler.ProdutoController;
import entities.Cliente;
import entities.Fornecedor;
import entities.Produto;
import entities.enums.Status;
import view.components.CustomButton;

public class ProdutoView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4285943477569243716L;
	private String[] colunas = { "Nome", "Fornecedor", "Estoque", "Valor" };
	private List<JComponent> inputs = new ArrayList<JComponent>();
	private String lastName = "";
	private JComponent input;
	private DefaultTableModel model;
	private JTable table;

	public ProdutoView() {
		this.setBackground(Color.LIGHT_GRAY);
		model = new DefaultTableModel();
		table = new JTable(model);
		for (String col : colunas) {
			model.addColumn(col);
		}
		JScrollPane brl = new JScrollPane(table);
		brl.setPreferredSize(new Dimension(700, 426));
		this.add(brl);
		this.listarProdutos(model);
		JPanel panel = new JPanel();
		this.addInputs(panel);
		GridLayout layout2 = new GridLayout(5, 1);
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
					if (textField.getName().equalsIgnoreCase("fornecedor")) {
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
							textField.setText(lastName);
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
			input.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					JTextField textField = ((JTextField) e.getComponent());
					String name = textField.getName();
					String key = String.valueOf(e.getKeyChar());
					String number = "0123456789/";
					if (name.equalsIgnoreCase("fornecedor")) {
						if (!number.contains(key)) {
							e.consume();
						} else {
							String text = textField.getText();
							if (text.length() > 13) {
								e.consume();
								return;
							}

						}
					} else if (name.equalsIgnoreCase("estoque") || name.equalsIgnoreCase("valor")) {
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
			});
			input.setName(col);
			input.setPreferredSize(new Dimension(300, 40));
			inputs.add(input);
			panel.add(input);
		}
		CustomButton button = new CustomButton("CADASTRAR", Color.decode("#483D8B"), Color.decode("#836FFF"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Produto produtos = new Produto();
				inputs.forEach(f -> {
					String value = ((JTextField) f).getText();
					if (f.getName().equalsIgnoreCase("nome")) {
						produtos.setNomeProduto(value);
					} else if (f.getName().equalsIgnoreCase("fornecedor")) {
						Fornecedor f2 = new FornecedorController().getFornecedorByCnpj(value);
						if (f2 != null) {
							produtos.setFornecedor(f2);
						} else {
							JOptionPane.showMessageDialog(null, "Não encontramos um fornecedor com CNPJ: " + value,
									"Fornecedor não encontrado", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} else if (f.getName().equalsIgnoreCase("estoque")) {
						try {
							produtos.setQuantEstoque(Integer.parseInt(value));
						} catch (Exception e2) {
							// TODO: handle exception
						}
					} else if (f.getName().equalsIgnoreCase("valor")) {
						try {
							produtos.setValor(Double.parseDouble(value));
						} catch (Exception e2) {
							// TODO: handle exception
						}

					}
				});

				ProdutoController produtoController = new ProdutoController();
				produtoController.cadastrarProduto(produtos);
				listarProdutos(model);
				produtoController.mostrarProdutos(produtos);
			}

		});
		panel.add(button);
	}

	private void listarProdutos(DefaultTableModel model) {
		model.setNumRows(0);
		Set<Produto> produtos = new ProdutoController().getProdutos();
		produtos.forEach(f -> {
			String nome = f.getNomeProduto();
			Fornecedor fornecedor = f.getFornecedor();
			int estoque = f.getQuantEstoque();
			double valor = f.getValor();
			if (fornecedor != null) {
				model.addRow(new Object[] { nome, fornecedor.getNome(), estoque, valor });
			}
		});
	}
}
