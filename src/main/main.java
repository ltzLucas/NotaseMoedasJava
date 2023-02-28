package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BancoDao;
import dao.ClienteDao;
import jdbc.ConnectionFactory;
import modelo.Banco;
import modelo.Moeda;
import modelo.Nota;
import modelo.Cliente;

public class main {

	public static void main(String[] args) throws SQLException {
		
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
		
		Connection conexao = new ConnectionFactory().getConnection();
		ClienteDao cDao = new ClienteDao(conexao);
		BancoDao bDao = new BancoDao(conexao);
		
		Scanner entrada = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		int opcaoCadastro;
		
		do {
			menuCadastro();
			opcaoCadastro = entrada.nextInt();
			switch (opcaoCadastro) {
			
			case 1:
				
				System.out.println("Informe seu nome");
				String nome = scanner1.next();
				System.out.println("Informe o seu CPF");
				String cpf = scanner2.next();
				cDao.insere(new Cliente(nome,cpf));
				
				System.out.println("Cliente Criado com sucesso, use o CPF para Cadastrar uma conta: ");
				System.out.println(cDao.buscaPorCPF(cpf));
				break;
			case 2:
				System.out.println("Informe o seu CPF, a senha, e o valor de deposito inicial"); 
				String cpf1 = scanner1.next();
				int senha = scanner2.nextInt();
				double valor = scanner1.nextDouble();
				
				bDao.insere(new Banco(cDao.buscaPorCPF(cpf1),senha,valor));
				break;
			case 3:
				bDao.listarContasInnerJoin();
				break;
			case 4:
				int opcao;
				double valor1;
				
				System.out.println("Digite sua senha para entrar na sua conta: ");
				int senha1 = scanner1.nextInt();
				
				for (Banco conta : bDao.listarTodos()) {
					if(senha1 == conta.getSenha()) {
						System.out.println("  Seja bem Vindo!!");
						do {
							menu();
							opcao = entrada.nextInt();
							switch (opcao) {
								case 1: {
									System.out.print("\n\n\n\n\n\n Informe a quantia que deseja retirar: ");
									valor1 = scanner1.nextDouble();
									conta.TrocoComNotasEMoedasDisponiveis(notas, moedas, valor1);
									bDao.saque(valor1,bDao.saldoConta(conta) ,conta);
								break;
							}
								case 2: {
									System.out.print("\n\n\n\n\n\n Informe o valor de deseja depositar: ");
									valor1 = scanner1.nextDouble();
									bDao.deposito(valor1,bDao.saldoConta(conta) ,conta);
								break;
							}
								case 3: {
									System.out.println("\n\n\n\n\n Saldo Disponivel: " + bDao.saldoConta(conta));
								break;
							}
								case 4: {
									opcao = 4;
									break;
								}
							}
						} while (opcao != 4 );
					}
				}
				break;
			case 5:
				opcaoCadastro = 5;
				break;
			}
		} while (opcaoCadastro != 5);
	
	}
	
	public static void menu() {
		
		System.out.println("\n\n\n1. Saque");
		System.out.println("2. Deposito");
		System.out.println("3. Saldo");
		System.out.println("4. Sair");
	}
	public static void menuCadastro() {
		System.out.println("Bem Vindo a area de Cadastro!");
		System.out.println("1. Cadastrar Cliente");
		System.out.println("2. Cadastrar Conta");
		System.out.println("3. Visualizar Contas Cadastradas");
		System.out.println("4. Entrar na Conta");
		System.out.println("5. Sair");
	
	}
	
}
