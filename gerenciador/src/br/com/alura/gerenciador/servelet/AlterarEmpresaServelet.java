package br.com.alura.gerenciador.servelet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AlterarEmpresaServelet")
public class AlterarEmpresaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} 
		catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaPeloId(id);
		emp.setNome(nomeEmpresa);
		emp.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listaEmpresasServlet");
		
	}

}
