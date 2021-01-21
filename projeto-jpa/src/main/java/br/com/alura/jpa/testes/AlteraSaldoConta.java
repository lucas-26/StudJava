package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");
		EntityManager entityManager =  emf.createEntityManager();
		
		Conta contaLucas = entityManager.find(Conta.class, 2L);
		
		entityManager.getTransaction().begin();
		
		contaLucas.setSaldo(50.0); //nesse momento a "contaLucas" est� no estado de managed ou seja o jpa sabe os dados dela e consegue fazer altera��es como quiser. 
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		contaLucas.setSaldo(2550.0);//aqui nesse momento est� no estado de detached, o jpa se lembra dos dados dessa conta mas, n�o consegue fazer mais nenhuma altera��o
		
		EntityManager entityManager2 =  emf.createEntityManager();
		
		entityManager2.getTransaction().begin();
		entityManager2.merge(contaLucas); //fazendo isso o conta lucas passa do estado detached para o estados managed, ou seja o jpa consegue manipular e fazer altera��es novamente.
										//o merge � mais lento que o "persistence()" pq o merge primeiro faz o select de dps o update ou insert, no caso o persist j� insere. 
		entityManager2.getTransaction().commit();
		
		entityManager2.close();
		
	}

}
