package concretas;

import inter.calcula.CalculaArea;

public class Retangulo implements CalculaArea {
	private Double largura;
	private Double altura;
	
	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public double calcArea() {
		
		return largura*altura;
	}

	@Override
	public void exibeArea() {
		System.out.println(toString());
		
	}

	@Override
	public String toString() {
		return "Retangulo [getLargura()=" + getLargura() + ", getAltura()=" + getAltura() + ", calcArea()=" + calcArea()
				+ "]";
	}

}
