package br.com.liliane.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.print("Executando a lógica...");
		System.out.print("Retornando o nome da página jsp...");
		return "primeira-logica.jsp";
	}
	

}
