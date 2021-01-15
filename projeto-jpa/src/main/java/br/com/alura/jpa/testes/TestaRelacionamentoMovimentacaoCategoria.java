package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");
        
        Conta conta = new Conta();
        conta.setId(2l);
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("Viagem a São Paulo");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal(300.0));
        movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
        
        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setDescricao("Viagem ao Rio de janeiro");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setValor(new BigDecimal(400.0));
        movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
        
        EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");//ira até o persistence.xml e vai procurar pelo campo <persistence-unit name="contas"> por isso o nome do parametro e o do persistence unit devem ser os mesmos.
		EntityManager entityManager =  emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.persist(categoria2);
		entityManager.persist(movimentacao);
		entityManager.persist(movimentacao2);
        
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
