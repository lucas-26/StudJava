package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");//ira até o persistence.xml e vai procurar pelo campo <persistence-unit name="contas"> por isso o nome do parametro e o do persistence unit devem ser os mesmos.
		 EntityManager entityManager =  emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setNumero(26152);
		conta.setAgencia(12345);
		conta.setSaldo(20.0);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		emf.close();
	}

}
