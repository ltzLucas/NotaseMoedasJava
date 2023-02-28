package modelo;

public class Cliente {
	
	private String nome;
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		boolean valido = cpf.matches("\\d\\d\\d.\\d\\d\\d.\\d\\d\\d-\\d\\d");
		if (valido == false) {
			throw new IllegalArgumentException("Preencha o cpf nesse formato: 000.000.000-00");
		} 
		
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Nome = " + nome + " Cpf = " + cpf + " Valor = " + "]";
	}

	

	
	
}
