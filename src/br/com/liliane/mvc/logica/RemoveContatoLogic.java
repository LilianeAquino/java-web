package br.com.liliane.mvc.logica;

import java.sql.Connection;
//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.liliane.dao.ContatoDao;
import br.com.liliane.modelo.Contato;

public class RemoveContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
						
			long id = Long.parseLong(req.getParameter("id"));
			
			Contato contato = new Contato();
			contato.setId(id);
			
			Connection connection = (Connection) req.getAttribute("conexao");
			ContatoDao dao = new ContatoDao(connection);
			dao.remove(contato);
			
			/*RequestDispatcher rs = req.getRequestDispatcher("mvc?logica=ListaContatosLogic");
			rs.forward(req, res);*/
			
			System.out.println("Excluindo contato id: "+contato.getId());
			return "mvc?logica=ListaContatosLogic";
                    
	}

}
