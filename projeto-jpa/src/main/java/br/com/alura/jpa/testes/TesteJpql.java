package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJpql {

	public static void main(String[] args) {
		//jpql query de mais alto nivel, do jpa 
		
		//String querysql = "select * from movimentacao where conta_id =2"; <- query sql
		
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");
		EntityManager entityManager =  emf.createEntityManager();		
		
		String queryjpql = "select m from Movimentacao m where m.conta = :parametroConta order by m.valor desc"; //<- isso é um queri jpql
		 
		Conta conta = new Conta();
		conta.setId(2L);
		TypedQuery<Movimentacao> query = entityManager.createQuery(queryjpql, Movimentacao.class);
		query.setParameter("parametroConta", conta);
		
		List<Movimentacao> result = query.getResultList();
		for (Movimentacao movimentacao : result) {
			 System.out.println("Descrição"+ movimentacao.getDescricao());
			 System.out.println("Valor"+ movimentacao.getValor());
			 System.out.println("Tipo"+ movimentacao.getTipoMovimentacao());
		}

	}

}
