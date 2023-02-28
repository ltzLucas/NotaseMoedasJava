package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDao {
	private Connection conexao;
	
	public ClienteDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void insere(Cliente cliente) throws SQLException{
		conexao.setAutoCommit(false);
		
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
			conexao.commit();
		}
	}
	
	public List<Cliente> listarTodos() throws SQLException{
		
		String sql = "select * from cliente";
		
		try (PreparedStatement comando = conexao.prepareStatement(sql)){
			List<Cliente> clientes = new ArrayList<>();
			try (ResultSet registros = comando.executeQuery()){
				while(registros.next()) {
					Cliente cliente = new Cliente(registros.getString("nome"),registros.getString("cpf"));
					cliente.setId(registros.getInt("id"));
					clientes.add(cliente);
				}
			}
			return clientes;
		}
	}
	
	public Cliente buscaPorId(int id) throws SQLException{
		String sql = "select * from cliente where id = ?";
		
		try(PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.setInt(1, id);
			try(ResultSet registros = comando.executeQuery()){
				if(registros.next()) {
					Cliente cliente = new Cliente(registros.getString("nome"),registros.getString("cpf"));
					cliente.setId(registros.getInt("id"));
					return cliente;
				}
				return null;
			}
		}
	}
	public Cliente buscaPorCPF(String cpf) throws SQLException{
		String sql = "select * from cliente where cpf = ?";
		
		try(PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.setString(1,cpf);
			try(ResultSet registros = comando.executeQuery()){
				if(registros.next()) {
					Cliente cliente = new Cliente(registros.getString("nome"),registros.getString("cpf"));
					cliente.setId(registros.getInt("id"));
					return cliente;
				}
				return null;
			}
		}
	}
}
