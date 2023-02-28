package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","ASSAAS","oracle");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
