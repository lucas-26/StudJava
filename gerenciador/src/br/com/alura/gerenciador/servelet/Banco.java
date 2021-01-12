package br.com.alura.gerenciador.servelet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		
		Empresa empresa3 = new Empresa();
		empresa3.setNome("EY");
		lista.add(empresa);
		lista.add(empresa2);
		lista.add(empresa3);
	}
	

	public void adicionar(Empresa empresa) {
		lista.add(empresa);
	}
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

}
