package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {

	public static void main(String[] args) {

		 Conta conta = new Conta();
		 conta.setAgencia(854862);
		 conta.setNumero(658415);
		 conta.setSaldo(300.0);
		 conta.setTitular("leonardo");
		 
		 Movimentacao movimentacao = new Movimentacao();
		 movimentacao.setData(LocalDateTime.now());
		 movimentacao.setDescricao("churrascaria");
		 movimentacao.setValor(new BigDecimal(200.0));
		 movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		 movimentacao.setConta(conta);
		 
		 EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");//ira até o persistence.xml e vai procurar pelo campo <persistence-unit name="contas"> por isso o nome do parametro e o do persistence unit devem ser os mesmos.
		 EntityManager entityManager =  emf.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 entityManager.persist(conta);
		 entityManager.persist(movimentacao);
		 entityManager.getTransaction().commit();
		 
		 entityManager.close();
	}

}
