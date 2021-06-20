package br.com.mvc.util;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection  getConnection() throws Exception {
		try {
			//qual é o banco e o driver
			Class.forName("com.mysql.jdbc.Driver");
			String login = "root";
			String senha = "zl8064";		
			String url="jdbc:mysql://localhost:3306/cadaluno?characterEncoding=latin1";
			return DriverManager.getConnection(url,login,senha);
		}
		catch(Exception e) {
			// imprime o erro
			throw new Exception(e.getMessage());
		}
	}

}
	
