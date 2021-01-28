package br.com.alura.forum.config.validacao;

public class ErroFormularioDto { //modelo de como deve ser a resposta de erro que é chamado na classe Erro de Validacao handler.	
	private String campo;
	private String erro;
	
	
	public ErroFormularioDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
