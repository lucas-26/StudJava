package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class LeilaoDaoTest2 {

	private LeilaoDao leilaoDao;
	private EntityManager em;

	@BeforeEach	
	public void beforeach() {
		this.em = JPAUtil.getEntityManager();
		this.leilaoDao = new LeilaoDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void AfterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	public void deveriaCadastarUmLeilao() {
		Leilao leilao = new LeilaoBuilder().
							comNome("Mochila").
							comValorInicial("500").
							comData(LocalDate.now()).
							comUsuario(new UsuarioBuilder().
											comNome("Fulano").
											comEmail("fulano@email.com").
											comSenha("12345678").criar()).
											criar();
				
				new Leilao("mochila", new BigDecimal("70"), LocalDate.now());
		
		leilao = leilaoDao.salvar(leilao);
		
		Leilao salvo = leilaoDao.buscarPorId(leilao.getId());
		Assert.assertNotNull(salvo);
	}
	
	@Test
	public void deveriaAtualizarUmLeilao() {
		Usuario usuario = CriarUsuario();
		Leilao leilao = new Leilao("mochila", new BigDecimal("70"), LocalDate.now(), usuario);
		
		leilao = leilaoDao.salvar(leilao);
		
		leilao.setNome("Celular");
		leilao.setValorInicial(new BigDecimal("400"));
		
		leilao = leilaoDao.salvar(leilao);
		
		Leilao salvo = leilaoDao.buscarPorId(leilao.getId());
		Assert.assertEquals("Celular", salvo.getNome());
		Assert.assertEquals(new BigDecimal("400"), salvo.getValorInicial());
	}
	
	private Usuario CriarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}
}
