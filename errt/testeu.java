package errt;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class testeu {
	public static void main(String[] args) {
		JFrame janela = new JFrame();
		JPanel painelAltura = new JPanel();
		JPanel painelPeso = new JPanel();
		JTextField txtAltura = new JTextField(15);
		JTextField txtPeso = new JTextField(15);
		JButton bt = new JButton("Calcular IMC");
		JButton btLimpar = new JButton("Limpar");
		JButton btSair = new JButton("Sair");
		
		FlowLayout flow = new FlowLayout();
		painelAltura.setLayout(flow);
		painelAltura.add(new JLabel("altura: "));
		painelAltura.add(txtAltura);
		painelPeso.setLayout(flow);
		painelPeso.add(new JLabel("peso "));
		painelPeso.add(txtPeso);
		janela.setLayout(flow);
		janela.setSize(250, 200);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		janela.setLocationRelativeTo(null);
		janela.add(painelAltura);
		janela.add(painelPeso);
		janela.add(bt);
		janela.add(btLimpar);
		janela.add(btSair);
		
		janela.setVisible(true);
	}
}