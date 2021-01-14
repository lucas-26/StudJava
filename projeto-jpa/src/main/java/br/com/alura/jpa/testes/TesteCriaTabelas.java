package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {
	public static void main(String[] args) {
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");//ira até o persistence.xml e vai procurar pelo campo <persistence-unit name="contas"> por isso o nome do parametro e o do persistence unit devem ser os mesmos.
		 EntityManager entityManager =  emf.createEntityManager();
		 emf.close();
	}

}
