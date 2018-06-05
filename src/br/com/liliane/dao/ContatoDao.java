package br.com.liliane.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import br.com.liliane.ConnectionFactory;
import br.com.liliane.modelo.Contato;



@SuppressWarnings("serial")
public class ContatoDao extends DAOException{
	
    private Connection connection;

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
	public	ContatoDao(Connection	connection)	{
		this.connection	=	connection;
    }
    
    public void adiciona(Contato contato) {
    	
        String sql = "INSERT INTO contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

        try {
	
	            PreparedStatement stmt = connection.prepareStatement(sql);
	
	            stmt.setString(1,contato.getNome());
	            stmt.setString(2,contato.getEmail());
	            stmt.setString(3,contato.getEndereco());
	            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
	
	            stmt.execute();
	            stmt.close();
	            
       }catch (SQLException e) {
    	   
    	   throw new DAOException(e);
       }
    }
    

	public List<Contato> getLista() {
		
		try {
			
			List<Contato> contatos = new ArrayList<Contato>();
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			rs.close();
			stmt.close();
			return contatos;
			
		}catch(SQLException e) {
			
			throw new DAOException(e);
		}
	}
  
    
    public Contato Pesquisar(long id) {
    	
		try {
			
			Contato contato = new Contato();
	        PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = "+id);
	        ResultSet rs = stmt.executeQuery();
	        
	        while(rs.next()) {
	      	
	            contato.setId(rs.getLong("id"));
	            contato.setNome(rs.getString("nome"));
	            contato.setEmail(rs.getString("email"));
	            contato.setEndereco(rs.getString("endereco"));
	            
	            Calendar data = Calendar.getInstance();
	            data.setTime(rs.getDate("dataNascimento"));
	            contato.setDataNascimento(data);
	            
	           
	        }
	                
	        rs.close();
	        stmt.close();
	        return contato;
	       
		}catch (SQLException e) {
    		
    		throw new DAOException(e);
        }     
    }
    
    
 
    public void altera(Contato contato) {
    	
        String sql = "update contatos set nome=?, email=?, endereco=?," + "dataNascimento=? where id=1";
        
        try {
        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));            
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
        	
            throw new RuntimeException(e);
        }
    }
    
    
    
    
    public void remove(Contato contato) {
    	
        try {
        	
            PreparedStatement stmt = connection.prepareStatement("delete " + "from contatos where id=?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Excluido");
            
        } catch (SQLException e) {
        	
        	throw new DAOException();
            
        }
    }
}