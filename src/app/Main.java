package app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import view.ClienteView;
import view.FornecedorView;
import view.FuncionarioView;
import view.ProdutoView;
import view.TelaMenu;
import view.TelaEquipe;

public class Main {

	public static JFrame window;
	public static TelaMenu telaMenu = new TelaMenu();
	public static TelaEquipe telaEquipe = new TelaEquipe();
	public static ClienteView clienteView = new ClienteView();
	public static FuncionarioView funcionarioView = new FuncionarioView();
	public static FornecedorView fornecedoresView = new FornecedorView();
	public static ProdutoView produtoView = new ProdutoView();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				BorderLayout layout = new BorderLayout(5, 5);
				Dimension defaultSize = new Dimension(1024, 580);
				window = new JFrame("SG-Trabalho - TELA PRINCIPAL");
				window.setLayout(layout);
				window.add(telaMenu, BorderLayout.PAGE_START);
				window.add(telaEquipe, BorderLayout.PAGE_END);
				window.setSize(defaultSize);
				window.setLocationRelativeTo(null);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setMinimumSize(defaultSize);
				window.setPreferredSize(defaultSize);
				window.setVisible(true);
			}
		});
	}

}
