package br.com.liliane.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.liliane.dao.ContatoDao;
import br.com.liliane.modelo.Contato;



public class TestaLista {

	public static void main(String[] args) throws Exception {
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
	      for (Contato contato : contatos) {
	          System.out.println("Nome: " + contato.getNome());
	          System.out.println("Email: " + contato.getEmail());
	          System.out.println("Endereço: " + contato.getEndereco());

	          
	          final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	          System.out.println("Data de Nascimento: " + df.format(contato.getDataNascimento().getTime())+ "\n");
	      }
	      
	    /*  Contato contato1 = dao.Pesquisar(1);
          System.out.println("Nome: " + contato1.getNome());
          System.out.println("Email: " + contato1.getEmail());
          System.out.println("Endereço: " + contato1.getEndereco());*/

          

          

	}
}