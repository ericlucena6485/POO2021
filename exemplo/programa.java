package exemplo;

import java.util.ArrayList;

public class programa {

	public static void main(String[] args) {
		
		aluno a1 = new aluno();
		a1.setNome("Eric");
		a1.setIdade(19);
		
		aluno a2 = new aluno();
		a2.setNome("Erickk");
		a2.setIdade(20);
	
		aluno a3 = new aluno();
		a3.setNome("Erick");
		a3.setIdade(12);
		
		ArrayList<aluno> lista = new ArrayList<aluno>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}
