package main;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Banco;
import modelo.Moeda;
import modelo.Nota;
import modelo.Cliente;

public class main {

	public static void main(String[] args) {
		 
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
		
		Cliente pessoa1 = new Cliente("Lucas","222.222.222-02");
		Cliente pessoa2 = new Cliente("Ingrid","111.111.111-01");
		
		ArrayList<Banco> contas = new ArrayList<>();
		contas.add(new Banco(pessoa1,1234,500));
		contas.add(new Banco(pessoa2,007,1000));
		
		int opcao;
		double valor;
		Scanner entrada = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		
		int senha;
		
		System.out.println("Digite sua senha para entrar na sua conta: ");
		senha = scanner.nextInt();
		
		for (Banco conta : contas) {
			if(senha == conta.getSenha()) {
				System.out.println("  Seja bem Vindo!!");
				do {
					menu();
					opcao = entrada.nextInt();
					
					switch (opcao) {
						case 1: {
							System.out.print("\n\n\n\n\n\n Informe a quantia que deseja retirar: ");
							valor = scanner.nextDouble();
							conta.TrocoComNotasEMoedasDisponiveis(notas, moedas, valor);
							break;
						}
						
						case 2: {
							System.out.print("\n\n\n\n\n\n Informe o valor de deseja depositar: ");
							valor = scanner.nextDouble();
							conta.Deposito(valor);
							break;
						}
						case 3: {
							System.out.println("\n\n\n\n\n Saldo Disponivel: " +conta.getSaldo());
							break;
						}
						case 4: {
							opcao = 4;
						}
					}
				} while (opcao != 4 );
			}
		}
	}
	
	public static void menu() {
		
		System.out.println("\n\n\n1. Saque");
		System.out.println("2. Deposito");
		System.out.println("3. Saldo");
		System.out.println("4. Sair");
	}
	
}
