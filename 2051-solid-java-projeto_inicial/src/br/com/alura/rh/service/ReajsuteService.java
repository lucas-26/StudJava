package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajsuteService {
	
		private List<ValidacaoReajuste> validacoes;
	
		public ReajsuteService(List<ValidacaoReajuste> validacoes) {
			this.validacoes = validacoes;
		}
		
		public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
			this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));
			BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
			funcionario.atualizarSalario(salarioReajustado);
		}
}
