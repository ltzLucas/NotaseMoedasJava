package modelo;

import java.util.ArrayList;

public class Banco {
	private Pessoa pessoa;

	public Banco() {
	}


	public String TrocoComNotasDisponiveis(ArrayList<Nota> notas,Pessoa pessoa ,Integer input) {
		if( pessoa.getValorTotal() < input.doubleValue()) {
			throw new IllegalArgumentException(" Valor disponivel menor que o saque desejado ");
		}
		pessoa.setValorTotal((pessoa.getValorTotal() - input));
		
		int aux = 0;
		Double aux2 = 0.0;
		int cont = 0;

		int[] vetor = new int[7];
		for (Nota nota : notas) {
			aux = input / nota.getValor();
			for (;;) {
				vetor[cont] = aux;
				break;
			}
			aux2 = input.doubleValue();
			aux2 = aux2 - (vetor[cont] * nota.getValor());
			input = aux2.intValue();
			cont++;
		}

		return "" + "NOTAS:\n" 
			+ vetor[0] + " nota(s) de R$ 100.00\n" 
			+ vetor[1] + " nota(s) de R$ 50.00\n" 
			+ vetor[2] + " nota(s) de R$ 20.00\n" 
			+ vetor[3] + " nota(s) de R$ 10.00\n" 
			+ vetor[4] + " nota(s) de R$ 5.00\n"
			+ vetor[5] + " nota(s) de R$ 2.00\n"
			+ "";
	}

	public String TrocoComMoedasDisponiveis(ArrayList<Moeda> moedas,Pessoa pessoa, Double input) {
		if( pessoa.getValorTotal() < input) {
			throw new IllegalArgumentException(" Valor disponivel menor que o saque desejado ");
		}
		pessoa.setValorTotal((pessoa.getValorTotal() - input));
		
		Double aux = 0.0;
		int cont = 0;

		int[] vetor = new int[7];
		for (Moeda moeda : moedas) {
			aux = input / moeda.getValor();
			for (;;) {
				vetor[cont] = aux.intValue();
				break;
			}
			input = input - (vetor[cont] * moeda.getValor());
			cont++;
		}
		
		return "" + "MOEDAS:\n" 
			+ vetor[0] + " moeda(s) de R$ 1.00\n" 
			+ vetor[1] + " moeda(s) de R$ 0.50\n" 
			+ vetor[2] + " moeda(s) de R$ 0.25\n" 
			+ vetor[3] + " moeda(s) de R$ 0.10\n" 
			+ vetor[4] + " moeda(s) de R$ 0.05\n"
			+ vetor[5] + " moeda(s) de R$ 0.01\n" 
			+ "";
	}

	public void TrocoComNotasEMoedasDisponiveis(ArrayList<Nota> notas, ArrayList<Moeda> moedas,Pessoa pessoa, Double input) {
		String aux = input.toString() + '1';
		int numeroInteiro = input.intValue();

		for (int i = 0; i < aux.length(); i++) {
			if (aux.charAt(i) == '.') {
				if (aux.charAt(i-1) == '1' || aux.charAt(i-1) == '3' || aux.charAt(i-1) == '6' || aux.charAt(i-1) == '8') {
					aux = "1." + aux.charAt(i + 1) + aux.charAt(i + 2);
				}else {
					aux = "0." + aux.charAt(i + 1) + aux.charAt(i + 2);
				}
			}
		}
		double numeroDecimal = Double.valueOf(aux).doubleValue();
		
		System.out.println(TrocoComNotasDisponiveis(notas, pessoa ,numeroInteiro));
		System.out.println(TrocoComMoedasDisponiveis(moedas,pessoa ,numeroDecimal));

	}
}
