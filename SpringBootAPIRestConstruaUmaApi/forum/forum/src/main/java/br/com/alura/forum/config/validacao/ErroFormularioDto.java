package br.com.alura.forum.config.validacao;

public class ErroFormularioDto { //modelo de como deve ser a resposta de erro.	
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
