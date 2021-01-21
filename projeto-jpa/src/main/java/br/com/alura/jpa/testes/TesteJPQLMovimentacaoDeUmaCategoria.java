package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");
		EntityManager entityManager =  emf.createEntityManager();		
		
		String queryjpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria"; //<- isso � um queri jpql :pCategoria é o nome do parametro, aqui também é feito o join
		 
		String queryjpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria desc"; //<- Query que retorna os registros na ordem decressente

		Categoria categoria = new Categoria();
		categoria.setId(2L);
		TypedQuery<Movimentacao> query = entityManager.createQuery(queryjpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> result = query.getResultList();
		for (Movimentacao movimentacao : result) {
			System.out.println("Categorias: "+ movimentacao.getCategoria());
			 System.out.println("Descri��o: "+ movimentacao.getDescricao());
			 System.out.println("Valor: "+ movimentacao.getValor());
			 System.out.println("Tipo: "+ movimentacao.getTipoMovimentacao());

		}
	}
}
