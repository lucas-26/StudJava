package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository  extends JpaRepository<Topico, Long>{
	
	public Page<Topico> findByCurso_Nome(String nomeCurso, Pageable paginacao);// seguindo essa nomenclatura o spring sabe que a propriedade curso se trata de um relacionamento com a entity Curso, ao usar essa nomenclatura findByCurso_Nome com o "_" o spring entra na entity curso e lá pega a propriedade nome

}
