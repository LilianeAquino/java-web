package br.com.liliane.dao;

@SuppressWarnings("serial")
public class DAOException extends RuntimeException {
	
	//construtores da classe Runtime
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DAOException() {
	}
	
	public DAOException(Throwable cause) {
		super(cause);
	}
}