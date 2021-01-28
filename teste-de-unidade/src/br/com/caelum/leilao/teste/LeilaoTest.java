package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook pro retina");
		Assert.assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Paul walker"), 2000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void deveReceberVariosLances() {
		
		Leilao leilao = new Leilao("Macbook pro retina");
		
		leilao.propoe(new Lance(new Usuario("Paul walker"), 2000));
		leilao.propoe(new Lance(new Usuario("Luinha"), 3000));
		leilao.propoe(new Lance(new Usuario("Eren jagger"), 4000));
		
		Assert.assertEquals(3, leilao.getLances().size());
		Assert.assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		Assert.assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
		Assert.assertEquals(4000.0, leilao.getLances().get(2).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		
		Leilao leilao = new Leilao("Macbook pro retina");
		Usuario paulWalker = new Usuario("Paul walker");
		
		leilao.propoe(new Lance(paulWalker , 2000));
		leilao.propoe(new Lance(paulWalker , 3000));
		
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisQueCincoLancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook pro retina");
		Usuario paulWalker = new Usuario("Paul walker");
		Usuario Caio = new Usuario("Caio");
		
		leilao.propoe(new Lance(paulWalker , 2000.0));
		leilao.propoe(new Lance(Caio , 3000.0));
		
		leilao.propoe(new Lance(paulWalker , 4000.0));
		leilao.propoe(new Lance(Caio , 5000.0));
		
		leilao.propoe(new Lance(paulWalker , 6000.0));
		leilao.propoe(new Lance(Caio , 7000.0));

		leilao.propoe(new Lance(paulWalker , 8000.0));
		leilao.propoe(new Lance(Caio , 9000.0));

		leilao.propoe(new Lance(paulWalker , 10000.0));
		leilao.propoe(new Lance(Caio , 11000.0));
		
		leilao.propoe(new Lance(paulWalker , 10000.0));

		Assert.assertEquals(10, leilao.getLances().size());
		Assert.assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}
}
