package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;

public class ClienteDao {
	private Connection conexao;
	
	public ClienteDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void insere(Cliente cliente) throws SQLException{
		
		String sql = "INSERT INTO cliente (nome,cpf)"
					+ "VALUES"
					+ "(?,?)";
		
		String[] colunaParaRetornar = {"id"};
		
		try(PreparedStatement comando = conexao.prepareStatement(sql,colunaParaRetornar)){
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getCpf());
			comando.execute();
			
			ResultSet rs = comando.getGeneratedKeys();
			rs.next();
			
			cliente.setId(rs.getInt(1));
			
		}
	}
	
}
