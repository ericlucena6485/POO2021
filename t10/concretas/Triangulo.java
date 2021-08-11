package concretas;

import inter.calcula.CalculaArea;

public class Triangulo implements CalculaArea {
	private Double base;
	private Double altura;
	
	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public double calcArea() {
		return (base*altura)/2;
	}

	@Override
	public void exibeArea() {
		
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Triangulo [getBase()=" + getBase() + ", getAltura()=" + getAltura() + ", calcArea()=" + calcArea()
				+ "]";
	}


}
