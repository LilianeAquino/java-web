package br.com.liliane.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.liliane.modelo.Contato;
import br.com.liliane.calendario.CalendarFormat;
import br.com.liliane.dao.ContatoDao;

public class AlteraContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tipo = req.getParameter("paramAltera");
		if(tipo.equals("altera")) {
			this.altera(req, res);
		}else {
			this.popula(req, res);
		}
		return "mvc?logica=ListaContatosLogic";	
}
	
	
	
	public void popula(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
	
		System.out.println("buscando o contato:" + id);
		Connection connection = (Connection) req.getAttribute("conexao");

		ContatoDao dao = new ContatoDao(connection);
		contato = dao.Pesquisar(id);

		req.setAttribute("nome", contato.getNome());
		req.setAttribute("endereco", contato.getEndereco());
		req.setAttribute("email", contato.getEmail());
		
		String data = new CalendarFormat().formatCalendar(contato.getDataNascimento());
		req.setAttribute("dataNascimento", data);

		RequestDispatcher rd = req.getRequestDispatcher("/altera-contato.jsp");
		rd.forward(req, res);	

		System.out.println("buscando o contato:" + contato.getNome());
	}
	
	

	public void altera(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		
		contato.setId(id);
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
		dao.altera(contato);

		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos.jsp");
		rd.forward(req, res);

		System.out.println("Alterando contato... " + contato.getNome());

	}

}
