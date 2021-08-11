package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import app.Main;
import view.components.CustomButton;

@SuppressWarnings("serial")
public class TelaMenu extends JPanel {

	public void update(JPanel e) {
		Main.window.add(e, BorderLayout.CENTER);
		Main.funcionarioView.setVisible(false);
		Main.fornecedoresView.setVisible(false);
		Main.produtoView.setVisible(false);
		Main.clienteView.setVisible(false);
		if (e == Main.clienteView) {
			Main.clienteView.setVisible(true);
		} else if (e == Main.funcionarioView) {
			Main.funcionarioView.setVisible(true);

		} else if (e == Main.fornecedoresView) {
			Main.fornecedoresView.setVisible(true);

		} else if (e == Main.produtoView) {
			Main.produtoView.setVisible(true);

		}

		Main.window.pack();
	}

	public TelaMenu() {
		FlowLayout layout = new FlowLayout();
		layout.setHgap(5);
		layout.setAlignment(FlowLayout.CENTER);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(layout);
		JButton clientes = new CustomButton("Clientes".toUpperCase(), Color.DARK_GRAY, Color.LIGHT_GRAY);
		clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update(Main.clienteView);
			}
		});
		JButton funcionarios = new CustomButton("Funcionários".toUpperCase(), Color.DARK_GRAY, Color.LIGHT_GRAY);
		funcionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update(Main.funcionarioView);
			}
		});
		JButton fornecedors = new CustomButton("Fornecedores".toUpperCase(), Color.DARK_GRAY, Color.LIGHT_GRAY);
		fornecedors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update(Main.fornecedoresView);
			}
		});
		JButton produtos = new CustomButton("Produtos".toUpperCase(), Color.DARK_GRAY, Color.LIGHT_GRAY);
		produtos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update(Main.produtoView);
			}
		});
		this.add(clientes);
		this.add(funcionarios);
		this.add(fornecedors);
		this.add(produtos);
	}

}
