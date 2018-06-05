package br.com.liliane;

import java.sql.*;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useSSL=false", "root", "84959154");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}