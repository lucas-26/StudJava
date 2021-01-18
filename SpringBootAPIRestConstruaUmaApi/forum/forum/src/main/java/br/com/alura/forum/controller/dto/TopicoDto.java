package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.*;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto { //DATA TRANSFER OBJECT - Usamos as classes desse tipo para fazer o "response" pois aqui só tem as informações que queremos mostrar, é uma classe bin, diferente da classe tópico que é uma entity, ou seja... usamos a classe dto para expor os dados que nós queremos mostrar nesse caso é um dto para pegar os dados, tratar e mostrar na resposta 
	private long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public static Page<TopicoDto> converter(Page<Topico> topico) {
		return topico.map(TopicoDto::new);
	}
	
}
