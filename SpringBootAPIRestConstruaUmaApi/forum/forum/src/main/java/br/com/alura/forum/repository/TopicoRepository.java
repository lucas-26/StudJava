package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository  extends JpaRepository<Topico, Long>{
	
	public List<Topico> findByCurso_Nome(String nomeCurso);// seguindo essa nomenclatura o spring sabe que a propriedade curso se trata de um relacionamento do a entity Curso, ao usar essa nomenclatura o spring entra na entity curso e lá pega a propriedade nome

}
