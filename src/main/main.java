package main;

import java.util.ArrayList;

import modelo.Banco;
import modelo.Moeda;
import modelo.Nota;
import modelo.Pessoa;

public class main {

	public static void main(String[] args) {
		 
		Banco cedula = new Banco();
		ArrayList<Nota> notas  = new ArrayList<>();
		notas.add(new Nota(100));
		notas.add(new Nota(50));
		notas.add(new Nota(20));
		notas.add(new Nota(10));
		notas.add(new Nota(5));
		notas.add(new Nota(2));
		
		
		ArrayList<Moeda> moedas = new ArrayList<>();
		moedas.add(new Moeda(1.0));
		moedas.add(new Moeda(0.50));
		moedas.add(new Moeda(0.25));
		moedas.add(new Moeda(0.10));
		moedas.add(new Moeda(0.05));
		moedas.add(new Moeda(0.01));
		
		Pessoa pessoa1 = new Pessoa("Lucas","109.129.039-37",100);
		
//		System.out.println(cedula.TrocoComNotasDisponiveis(notas, pessoa1, 50));
		cedula.TrocoComNotasEMoedasDisponiveis(notas ,moedas,pessoa1 ,10.13);
	
	}
}
