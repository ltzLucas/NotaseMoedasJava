package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Banco;
import modelo.Cliente;

public class BancoDao {

private Connection conexao;
	
	public BancoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void insere(Banco banco) throws SQLException {
		conexao.setAutoCommit(false);
		
		String sql = "INSERT INTO banco"
					+"(id_cliente,senha,saldo)"
					+"VALUES"
					+"(?,?,?)";
		
		String[]colunaParaRetornar = {"id"};
		
		try(PreparedStatement comando = conexao.prepareStatement(sql,colunaParaRetornar)){
			comando.setInt(1, banco.getCliente().getId());
			comando.setInt(2, banco.getSenha());
			comando.setDouble(3, banco.getSaldo());
			comando.execute();
			
			ResultSet rs = comando.getGeneratedKeys();
			rs.next();
			
			banco.setId(rs.getInt(1));
			conexao.commit();
		}
	}
	
	public List<Banco> listarTodos() throws SQLException{
		String sql = "select * from banco";
		
		try (PreparedStatement comando = conexao.prepareStatement(sql)){
			
			List<Banco> contas = new ArrayList<>();
			
			try (ResultSet registros = comando.executeQuery()){
				ClienteDao cDao = new ClienteDao(conexao);
				while(registros.next()) {
					Cliente cliente = cDao.buscaPorId(registros.getInt("id_cliente"));
					Banco conta = new Banco(cliente,registros.getInt("senha"),registros.getInt("saldo"));
					conta.setId(registros.getInt("id"));
					contas.add(conta);
				}
			}
			return contas;
		}
	}
	
	public void saque(double valorSaque,double saldo,Banco conta) throws SQLException {
		if( conta.getSaldo() < valorSaque ) {
			throw new IllegalArgumentException(" Valor disponivel menor que o saque desejado ");
		}
		double valorFinal = saldo - valorSaque;
		
		String sql = "update banco set saldo = ? where id = ?";
			try(PreparedStatement comando = conexao.prepareStatement(sql)){
				comando.setDouble(1, valorFinal);
				comando.setInt(2, conta.getId());
				comando.execute();
			}
	}
	
	public void deposito(double valorDep,double saldo,Banco conta) throws SQLException {
		double valorFinal = saldo + valorDep;
		
		String sql = "UPDATE banco SET saldo = ? where id = ?";
			try(PreparedStatement comando = conexao.prepareStatement(sql)){
				comando.setDouble(1, valorFinal);
				comando.setInt(2, conta.getId());
				comando.execute();
			}
	}
	
	
	
	public void listarContasInnerJoin()  throws SQLException {
		conexao.setAutoCommit(false);
		String sql = "SELECT c.id,c.nome,c.cpf,b.saldo FROM banco b"
				+ "    INNER JOIN cliente c"
				+ "    ON c.id = b.id_cliente"
				+ " ORDER BY c.nome";
		try(PreparedStatement comando = conexao.prepareStatement(sql)){
			try(ResultSet registros = comando.executeQuery()){
				while(registros.next()) {
					System.out.println("ID: "+registros.getInt("id")+" Nome: " +registros.getString("nome")+" CPF: " +registros.getString("cpf") 
					+" Saldo: "+ registros.getDouble("saldo")+"\n");
				}
			}
		}
	}
	
	public double saldoConta(Banco conta) throws SQLException {
		String sql = "SELECT saldo FROM banco "
					+"where id = " + conta.getId();
		try(PreparedStatement comando = conexao.prepareStatement(sql)){
			try(ResultSet registros = comando.executeQuery()){
				while(registros.next()) {
					return registros.getDouble("saldo");
				}
			}
		}
		return 0.0;
		
	}
	
}
