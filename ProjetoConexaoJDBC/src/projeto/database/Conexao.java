package projeto.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	/* Armazena nossa conexão com o banco de dados */
	private static Connection connection;

	/* Método que retorna uma conexão com o banco */
	public static Connection getConnection() throws SQLException {

		/*
		 * Caso a conexão já exista, então não é necessário criar uma nova,
		 * dessa forma retorna ela mesma
		 */
		if (connection != null) {
			return connection;
		}

		/* 
		 * Utiliza a classe DriverManager auxiliar para criar uma nova conexão com base nos parâmetros de url, usuário e senha
		 * */
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
		return connection;
	}

}
