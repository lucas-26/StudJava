package br.com.alura.forum.controller.form;



import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

public class TopicoForm { //DATA TRANSFER OBJECT também é um arquivo dto mas, nesse caso são tratados os dados que chegam para a api 
	
	@NotNull @NotEmpty @Length(min = 5) //usando o bean validation informando que o campo não pode ser nulo,
	private String titulo;				// não pode ser vazio e tem que tem no minimo 5 caracteres
	@NotNull @NotEmpty @Length(min = 5)
	private String mensagem;
	@NotNull @NotEmpty @Length(min = 5)
	private String nomeCurso;
	
	
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
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursorepository) {
		Curso curso = cursorepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
	
}
