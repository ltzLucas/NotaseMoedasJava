package modelo;

public class Moeda extends Banco  {
	
	private double valor;

	public Moeda(Double valor) {
		if (!(valor == 1 || valor == 0.50 || valor == 0.25 || valor == 0.10 || valor == 0.05 || valor == 0.01)) {
			throw new IllegalArgumentException("Valor deve ser 1.0, 0.50 , 0.25 , 0.10 ,0.05 ou 0.01");
		}
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
}
