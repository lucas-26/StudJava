package br.com.alura.gerenciador.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listaEmpresasServlet
 */
@WebServlet("/listaEmpresasServlet")
public class listaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");
		
		for (Empresa empresa : lista) {
			out.println("Empresa " + empresa.getNome()  + " cadastrada com sucesso <br>");
		}
		
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
