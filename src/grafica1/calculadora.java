package grafica1;

import javax.swing.JOptionPane;

public class calculadora {

	public static void main(String[] args) throws NumberFormatException {

		int valorA = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor A: "));
		int valorB = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor B: "));

		int resultado1 = valorA + valorB;
		int resultado2 = valorA - valorB;
		int resultado3 = valorA * valorB;
		int resultado4 = valorA / valorB;
		

		JOptionPane.showMessageDialog(null,"Resultado da soma foi: "+resultado1,"Resultado",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,"Resultado da subtracao foi: "+resultado2,"Resultado",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,"Resultado da multiplicacao foi: "+resultado3,"Resultado",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,"Resultado da divisao foi: "+resultado4,"Resultado",JOptionPane.INFORMATION_MESSAGE);


	}
}