package br.com.liliane.mvc.logica;

import java.util.Date;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.liliane.dao.ContatoDao;
import br.com.liliane.modelo.Contato;

public class AdicionaContatoLogic implements Logica{
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		
		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		

		String dataEmTexto = req.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		
		dao.adiciona(contato);
		
		System.out.println("contato foi adicionado!");
		
		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos.jsp");
		rd.forward(req, res);
		
		return "mvc?logica=ListaContatosLogic";

	}
}
