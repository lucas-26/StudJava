package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.Servico.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class Teste {

	@Test
	public void deveTerLancesEmOrdemCrescente() {
		// parte 1: Cenario
		Usuario usuario1 = new Usuario("Lucas");
		Usuario usuario2 = new Usuario("Aline");
		Usuario usuario3 = new Usuario("Caio");

		Leilao leilao = new Leilao("Notebook");

		leilao.propoe(new Lance(usuario1, 300.0));
		leilao.propoe(new Lance(usuario2, 400.0));
		leilao.propoe(new Lance(usuario3, 500.0));

		// parte 2: Ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// parte 3: Validacao
		System.out.println(leiloeiro.getMaiorLance());
		System.out.println(leiloeiro.getMenorLance());

		int maiorValor = 500;
		int menorValor = 300;

		assertEquals(maiorValor, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorValor, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario usuario = new Usuario("Carlos");
		
		Leilao leilao = new Leilao("Notebook");
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		leilao.propoe(new Lance(usuario, 1000.0));
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);		
	}
	
	@Test
	public void deveEncontrarTresMaioresLances() {
		
		Usuario usuario1 = new Usuario("Lucas");
		Usuario usuario2 = new Usuario("Aline");
		Usuario usuario3 = new Usuario("Caio");
		
		Leilao leilao = new Leilao("Notebook");
		
		leilao.propoe(new Lance(usuario1, 100.0));
		leilao.propoe(new Lance(usuario2, 200.0));
		leilao.propoe(new Lance(usuario3, 300.0));
		leilao.propoe(new Lance(usuario1, 400.0));
		leilao.propoe(new Lance(usuario2, 500.0));
		leilao.propoe(new Lance(usuario3, 600.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		
		assertEquals(100.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(1).getValor(), 0.00001);	
		assertEquals(300.0, maiores.get(2).getValor(), 0.00001);
		
	}

}
