package br.com.caelum.leilao.teste;


import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.Servico.Avaliador;
import br.com.caelum.leilao.build.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class Teste {

	private Avaliador leiloeiro;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;

	@Before
	public void CriaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.usuario1 = new Usuario("Lucas");
		this.usuario2 = new Usuario("Aline");
		this.usuario3 = new Usuario("Caio");
	}

	@Test
	public void deveTerLancesEmOrdemCrescente() {
		// parte 1: Cenario

		Leilao leilao = new Leilao("Notebook");

		leilao.propoe(new Lance(usuario1, 300.0));
		leilao.propoe(new Lance(usuario2, 400.0));
		leilao.propoe(new Lance(usuario3, 500.0));

		// parte 2: Ação
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
		Leilao leilao = new Leilao("Notebook");

		leilao.propoe(new Lance(usuario1, 1000.0));

		leiloeiro.avalia(leilao);

		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
	}

	@Test
	public void deveEncontrarTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Notebook").lance(usuario1, 100.0).lance(usuario2, 200.0)
				.lance(usuario3, 300.0).constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());

		
		assertEquals(100.0, maiores.get(2).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(0).getValor(), 0.00001);
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Notebook").constroi();

		leiloeiro.avalia(leilao);
	}

}
