package br.com.tudo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoJDBC {
	private static final String URL = "jdbc:postgresql://localhost/Estudo";
	private static final String USER = "postgres";
	private static final String SENHA = "masterkey";
	
	public static Connection obterConexao() throws SQLException{
		
		try{
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, SENHA);
		
	}
	
}
