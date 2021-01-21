package br.com.alura.rh.service;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidacaoReajuste {//Interface Segregation Principle. Classes n�o devem ser obrigadas a implementar m�todos que n�o ir�o precisar.

	public void validar(Funcionario funcionario, BigDecimal aumento);
	
}
