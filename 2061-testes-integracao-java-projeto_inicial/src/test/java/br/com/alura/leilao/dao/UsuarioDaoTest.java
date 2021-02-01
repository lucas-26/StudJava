package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class UsuarioDaoTest {

	private UsuarioDao usudao;
	private EntityManager em;

	@BeforeEach	
	public void beforeach() {
		this.em = JPAUtil.getEntityManager();
		this.usudao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void AfterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveriaEcontrarUsuarioCadastrado() {
		Usuario usuario = new UsuarioBuilder().
				comNome("Fulano").
				comEmail("fulano@email.com").
				comSenha("12345678").criar();
				em.persist(usuario);
		Usuario buscarPorUsername = usudao.buscarPorUsername(usuario.getNome());
		Assert.assertNotNull(buscarPorUsername);
	}

	@Test
	public void naoDeveriaEncontrarUsuarioNaoCadastrado() {
		Usuario usuario = new UsuarioBuilder().
		comNome("Fulano").
		comEmail("fulano@email.com").
		comSenha("12345678").criar();
		em.persist(usuario);
		Assert.assertThrows(NoResultException.class, () -> this.usudao.buscarPorUsername("ciclano"));
	}
	
	@Test
	public void deveriaRemoverUmUsuario() {
		Usuario usuario = new UsuarioBuilder().
				comNome("Fulano").
				comEmail("fulano@email.com").
				comSenha("12345678").criar();
		
		em.persist(usuario);
		usudao.deletar(usuario);
		
		Assert.assertThrows(NoResultException.class, () -> this.usudao.buscarPorUsername(usuario.getNome()));
	}

}
