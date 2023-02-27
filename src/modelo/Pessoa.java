package modelo;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private double valorTotal;
	
	public Pessoa(String nome, String cpf, double valorTotal) {
		this.nome = nome;
		this.cpf = cpf;
		this.valorTotal = valorTotal;
	}

	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Nome = " + nome + " Cpf = " + cpf + " Valor = " + "]";
	}

	

	
	
}
