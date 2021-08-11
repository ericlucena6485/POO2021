package grafica1;

import javax.swing.JOptionPane;

public class ExemplosJOptionPane {

	public static void main(String[] args) {

		String valor = JOptionPane.showInputDialog(null, "Qual seu nome? " , " Cadastra nome",3);

		JOptionPane.showMessageDialog(null, "Seu nome eh: " + valor, "Resultado", JOptionPane.INFORMATION_MESSAGE);


		int opcao = JOptionPane.showConfirmDialog(null, "Seu nome  está correto?");

		if(opcao == 0) {
			JOptionPane.showMessageDialog(null, "Parabens seu nome "+ valor + " está correto!");
		}else if(opcao == 1) {
			JOptionPane.showMessageDialog(null, "Infelizmente o seu nome "+ valor + " está INCORRETO!");
		}else {
			JOptionPane.showMessageDialog(null, "Cancelar");
		}
		
		Object[] options = {"Sim", "Não", "Cancelar"};
		
		JOptionPane.showOptionDialog(null, "Seu nome está correto?", "Pergunta",  JOptionPane.OK_OPTION, 3, null, options, options[0]);
		
		
		
	}
}