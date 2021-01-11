package br.com.alura.gerenciador.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/oi") //Não basta estender a classe HttpServlet, também devemos configurar a URL através da anotação @WebServlet.
public class OiMundoServelet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, meu primeiro Servlet!!");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("o servlet foi chamado");
		
	}
	
}
