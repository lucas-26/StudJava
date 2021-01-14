package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		//Transiet estado pre managed, ainda não é mas o jpa sabe que ele é um grande candidato a ir pare o estado managed
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(321321);
		conta.setAgencia(123123);
		
		EntityManagerFactory emf = new Persistence().createEntityManagerFactory("contas");//ira até o persistence.xml e vai procurar pelo campo <persistence-unit name="contas"> por isso o nome do parametro e o do persistence unit devem ser os mesmos.
		 EntityManager entityManager =  emf.createEntityManager();
		 
		 entityManager.getTransaction().begin();
		 
		 //Transiet -> Managed onde o jpa tem todos os valores mapeados e se quiser, pode fazer operações de sql nesse registro
		 entityManager.persist(conta);
		 
		  //Managed -> Removed aqui a conta está sendo removida do banco e do contexto do jpa. essa entidade nesse estado possui um ID, apesar de não existir sincronização automática e não possuir registro no banco
		 entityManager.remove(conta);
		 
		 entityManager.getTransaction().commit();
	}

}
