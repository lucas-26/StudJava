package br.com.alura.rh.service;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidacaoReajuste {//Interface Segregation Principle. Classes não devem ser obrigadas a implementar métodos que não irão precisar.

	public void validar(Funcionario funcionario, BigDecimal aumento);
	
}
