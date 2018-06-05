package br.com.liliane.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.liliane.dao.ContatoDao;
import br.com.liliane.modelo.Contato;

public class ListaContatosLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Contato> contatos = new ContatoDao().getLista();
		
		req.setAttribute("contatos", contatos);
		
		return "lista-contatos.jsp";
	}

}
