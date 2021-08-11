package tarefaoito;

public class executando {


	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.setAno(2021);
		carro.setModelo("Fiesta");
		carro.setMarca("Ford");
		System.out.println(carro.toString());
		System.out.println(carro.emMovimento());

				Moto moto = new Moto();
				moto.setAno(2021);
				moto.setModelo("fan");
				moto.setMarca("honda");
				System.out.println(moto.toString());
				System.out.println(moto.emMovimento());
				
				Bicicleta bicicleta = new Bicicleta();
				bicicleta.setAno(2021);
				bicicleta.setModelo("Monark");
			bicicleta.setMarca("Monark");
				System.out.println(bicicleta.toString());
		
				System.out.println(bicicleta.emMovimento());
	}
}
