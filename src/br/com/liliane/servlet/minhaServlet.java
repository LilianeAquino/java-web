package br.com.liliane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minhaServlet")
public class minhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int contador = 0; //variavel de instância

        public void init(ServletConfig config) throws ServletException {
            super.init(config);
            log("Iniciando a servlet");
        }

        public void destroy() {
            super.destroy();
            log("Destruindo a servlet");
        }

        protected void service(HttpServletRequest request,HttpServletResponse response)
                            throws IOException, ServletException {
          
            contador++; // a cada requisição a mesma variável é incrementada

            // recebe o writer
            PrintWriter out = response.getWriter();

            // escreve o texto
            out.println("<html>");
            out.println("<body>");
            out.println("Contador agora é: " + contador);
            out.println("</body>");
            out.println("</html>");
        	
        }
}


