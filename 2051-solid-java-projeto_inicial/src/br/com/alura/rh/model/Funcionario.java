package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.alura.rh.ValidacaoException;

public class Funcionario { //Single-responsibility principle - principio da responsbilidade unica, foi aplicado nessa classe ao tirar o método reajustarSalario pois assim, essa classe só cuida de funcionario 
							//Uma classe (ou módulo, função, etc) deve ter um e apenas um motivo para mudar
	private DadosPessoais dadosPessoais;
	private LocalDate dataUltimoReajuste;

	

//	public void reajustarSalario(BigDecimal aumento) { //esse código foi colocado na classe reajuste service, pois isso já está além do que a classe funcionario deve fazer.
//		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP); //Ao retirar essa método a classe se tornou mais coesa
//		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
//			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
//		}
//		this.salario = this.salario.add(aumento);
//		this.dataUltimoReajuste = LocalDate.now();
//	}

	public void atualizarSalario(BigDecimal novoSalario) {
		BigDecimal salarioAtual = this.dadosPessoais.getSalario(); 
		salarioAtual = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}

//	public void setSalario(BigDecimal salario) { esse método foi retirado pois é um problema se tratando de encapsulamento
//		this.salario = salario;
//	}
	
	

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void promover(Cargo novoCargo) {
		Cargo cargoAtual = this.dadosPessoais.getCargo();
		cargoAtual = novoCargo;
		
	}


}
