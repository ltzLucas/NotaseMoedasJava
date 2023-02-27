package modelo;

public class Nota extends Banco {
		private int valor;
		
	public Nota(int valor) {
		if (!(valor == 100 || valor == 50 || valor == 20 || valor == 10 || valor == 5 || valor == 2)) {
			throw new IllegalArgumentException("Valor deve ser 100, 50 , 20 , 10 ,5 ou 2");
		}
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
}
