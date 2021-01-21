package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Os estados de uma entidade são: 
//Managed -> o jpa consegue manusear e alterar o recurso se a estiver nesse estado, ou seja está em sincronização automática com o banco.
//Detached -> o jpa se lembra desse recurso, se lembra do seu id mas, é impossivél fazer alguma alteração se estiver nesse estado.
//Transient -> Ainda não está no estado de Managed mas, o jpa sabe que existe uma grande possíblidade de vir a se tornar Managed.
//Removed -> É uma entidade que é removida do contexto da jpa, ou seja apagada pelo banco está em estado de Removed.

@Entity //Informando ao jpa que isso é uma entidade como uma tabela do banco de dados
public class Conta {//Classe java bean é uma classe comum, com getters e setters
	@Id													//Aqui estou informando que é o Id da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // aqui estou informando a estratedia de criação desse id
	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private Double saldo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double d) {
		this.saldo = d;
	}
}
