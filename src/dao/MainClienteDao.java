package dao;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionFactory;
import modelo.Cliente;

public class MainClienteDao {

	public static void main(String[] args) throws SQLException {

		Cliente c1 = new Cliente("Adriana","111.222.333-44");
		Connection conexao = new ConnectionFactory().getConnection();
		ClienteDao clienteDao = new ClienteDao(conexao);
		 
		clienteDao.insere(c1);
		
	} 
}
