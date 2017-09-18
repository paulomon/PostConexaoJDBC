package projeto.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	/* Armazena nossa conex�o com o banco de dados */
	private static Connection connection;

	/* M�todo que retorna uma conex�o com o banco */
	public static Connection getConnection() throws SQLException {

		/*
		 * Caso a conex�o j� exista, ent�o n�o � necess�rio criar uma nova,
		 * dessa forma retorna ela mesma
		 */
		if (connection != null) {
			return connection;
		}

		/* 
		 * Utiliza a classe DriverManager auxiliar para criar uma nova conex�o com base nos par�metros de url, usu�rio e senha
		 * */
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
		return connection;
	}

}
