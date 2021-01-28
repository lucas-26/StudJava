package br.com.alura.forum.controller;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotEmpty @Length(min = 5) //usando o bean validation informando que o campo não pode ser nulo, não pode ser vazio e tem que tem no minimo 5 caracteres
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 5)
	
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico  atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id); // esse método getOne diferente do FIndById Considera que exista esse registro no banco de dados e por isso quando ele não encontra ele não retorna null e sim uma exception
		
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}
	
	
}
