package entidade1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		int op = 0;
		Scanner entrada = new Scanner(System.in);
		
		do {
			try {	
				Livro livro = new Livro();

				

				System.out.println("Titulo do livro: ");
				String titulo = entrada.nextLine();


				System.out.println("Ano");
				livro.setAno(entrada.nextInt());

				System.out.println("Autor");
				livro.setAutor(entrada.nextLine());

				entrada.close();
			}catch (InputMismatchException e) {
				System.out.println("Dado incompativel " +
					e.toString());
			}
			System.out.println("Digite 2 para sair ou " + "0 para continuar");
			
		}while(op != 2);
		
		
	}
}
