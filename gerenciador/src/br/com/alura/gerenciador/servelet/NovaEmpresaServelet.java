package br.com.alura.gerenciador.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServelet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adicionar(empresa); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");//preparando para enviar a requisição para o meu jsp
		request.setAttribute("empresa", empresa.getNome());//empresa é o apelido que vai ser usado no jsp quando formos pegar o valor lá, o empresa.getnome é o valor
		rd.forward(request, response);//enviando de fato essa requisição
	}

}
