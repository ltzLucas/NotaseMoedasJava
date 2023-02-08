package main;

import java.util.ArrayList;

import modelo.Cedula;
import modelo.Moeda;
import modelo.Nota;

public class main {

	public static void main(String[] args) {
		
		Cedula cedula = new Cedula();
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
		
//		System.out.println(cedula.TrocoComNotasDisponiveis(notas,172));
//		System.out.println(cedula.TrocoComMoedasDisponiveis(moedas, 1.05));
		System.out.println(cedula.TrocoComNotasEMoedasDisponiveis(notas, moedas, 139.62));
	}
}
