package br.com.liliane.teste;

import java.sql.*;

import br.com.liliane.ConnectionFactory;



public class TestaConexao {
	public static void main(String[]args) throws Exception {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
	}
}