package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cedula {
	private double valor;
	
	public Cedula() {
	}
	
	public Cedula(Double valor) {
		if(!(valor == 1 || valor == 0.50 || valor == 0.25 || valor == 0.10 || valor == 0.05 || valor == 0.01)) {
			throw new IllegalArgumentException("Valor deve ser 1.0, 0.50 , 0.25 , 0.10 ,0.05 ou 0.01");
		}
		this.valor = valor;
	}
	
	public Cedula(Integer valor){
		if(!(valor == 100 || valor == 50 || valor == 20 || valor == 10 || valor == 5 || valor == 2)) {
			throw new IllegalArgumentException("Valor deve ser 100, 50 , 20 , 10 ,5 ou 2");
		}
		this.valor = valor.doubleValue();
	}
	
	public String TrocoComNotasDisponiveis(ArrayList<Nota>notas,double input) {
		Double aux = 0.0;
		int cont = 0;
		
		int[] vetor = new int[7];
		for (Nota nota : notas) {
			aux = input / nota.getValor();
			for (;;) {
				vetor[cont]=aux.intValue();
				break;
			}
			input = input - (vetor[cont] * nota.getValor());
			cont++;
		}
		
		return ""
		+"NOTAS:\n"
		+ vetor[0] + " nota(s) de R$ 100.00\n" 
    	+ vetor[1] + " nota(s) de R$ 50.00\n"
    	+ vetor[2] + " nota(s) de R$ 20.00\n"
    	+ vetor[3] + " nota(s) de R$ 10.00\n"
    	+ vetor[4] + " nota(s) de R$ 5.00\n"
    	+ vetor[5] + " nota(s) de R$ 2.00\n"
    	+"";
	}
	
	public String TrocoComMoedasDisponiveis(ArrayList<Moeda>moedas,double input) {
		Double aux = 0.0;
		int cont = 0;
		
		int[] vetor = new int[7];
		for (Moeda moeda : moedas) {
			aux = input / moeda.getValor();
//			System.out.println("aux: "+ aux);
			for (;;) {
				vetor[cont]=aux.intValue();
//			System.out.println("vetor: "+vetor[cont]);
				break;
			}
			
			System.out.println("Valor da moeda: "+moeda.getValor());
//			System.out.println("input antes: "+input);
			input = input - (vetor[cont] * moeda.getValor());
//			System.out.println("input depois: "+input);
			cont++;
		}
		return ""
		+"MOEDAS:\n"
		+ vetor[0] + " moeda(s) de R$ 1.00\n" 
    	+ vetor[1] + " moeda(s) de R$ 0.50\n"
    	+ vetor[2] + " moeda(s) de R$ 0.25\n"
    	+ vetor[3] + " moeda(s) de R$ 0.10\n"
    	+ vetor[4] + " moeda(s) de R$ 0.05\n"
    	+ vetor[5] + " moeda(s) de R$ 0.01\n"
    	+"";
	}
	
	public String TrocoComNotasEMoedasDisponiveis(ArrayList<Nota>notas,ArrayList<Moeda>moedas,double input) {
		//Calculo das Notas
		
		Double aux =0.0;
		int cont = 0;
		
		int[] vetor = new int[7];
		for (Nota nota : notas) {
			aux = input / nota.getValor();
			for (;;) {
				vetor[cont]=aux.intValue();
				break;
			}
			input = input - (vetor[cont] * nota.getValor());
			cont++;
		}
		
		//Calculo das Moedas
		aux = 0.0;
		cont = 0;
		int[] vetor_moeda = new int[7];
		for (Moeda moeda : moedas) {
			aux = input / moeda.getValor();
			for (;;) {
				vetor_moeda[cont] = aux.intValue();
				break;
			}
			input = input - (vetor_moeda[cont] * moeda.getValor());
			cont++;
		}
		
		return ""
		+"NOTAS:\n"
		+ vetor[0] + " nota(s) de R$ 100.00\n" 
    	+ vetor[1] + " nota(s) de R$ 50.00\n"
    	+ vetor[2] + " nota(s) de R$ 20.00\n"
    	+ vetor[3] + " nota(s) de R$ 10.00\n"
    	+ vetor[4] + " nota(s) de R$ 5.00\n"
    	+ vetor[5] + " nota(s) de R$ 2.00\n"
    	+"MOEDAS:\n"
    	+ vetor_moeda[0] + " moeda(s) de R$ 1.00\n" 
    	+ vetor_moeda[1] + " moeda(s) de R$ 0.50\n"
    	+ vetor_moeda[2] + " moeda(s) de R$ 0.25\n"
    	+ vetor_moeda[3] + " moeda(s) de R$ 0.10\n"
    	+ vetor_moeda[4] + " moeda(s) de R$ 0.05\n"
    	+ vetor_moeda[5] + " moeda(s) de R$ 0.01\n"
    	+"";
	}
	public Double getValor() {
		return valor;
	}
}
