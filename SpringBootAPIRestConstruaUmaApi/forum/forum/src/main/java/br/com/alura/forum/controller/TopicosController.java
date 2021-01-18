package br.com.alura.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController// para não repetir a anotação @ResponseBody em todos os métodos do controller, devemos utilizar a anotação @RestController;
@RequestMapping(value = "/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	//@ResponseBody //@ResponseBody, indica que o retorno do método deve ser serializado e devolvido no corpo da resposta.
	@GetMapping
	@Cacheable(value = "listaDeTopicos")//informando ao spring que esse metodo deve ter os dados guardados em cache 
	public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso,
		@PageableDefault(sort = "id", direction = Direction.DESC) Pageable paginacao){//@PageableDefault informando qual a paginação default caso o cliente não passe como ele deseja fazer a paginação.
		//Pageable paginacao = PageRequest.of(pagina, qtd, Direction.DESC, ordenacao); //fazendo paginação
		
		if(nomeCurso == null) {
		Page<Topico> topicos =  topicoRepository.findAll(paginacao);
		return TopicoDto.converter(topicos);
		} else {
			Page<Topico> topicos =  topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
			return TopicoDto.converter(topicos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) { //informando ao spring que é uma variavel da url com @PathVariable
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true) //informando ao spring que quando o método cadastrar for utilizado ele deve limpar o cache, assim evitando passar para o cliente a informação desatualizada.  
											 //o objetivo da anotação @Valid Indicar ao Spring para executar as validações do Bean Validation no parâmetro do método
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody  @Valid TopicoForm topicoform, UriComponentsBuilder uriBuilder) {//	essa anotação @RequestBody informa para o spring que o parametro vai vir no corpo da requisição
		Topico topico = topicoform.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}	
	
	@PutMapping("/{id}")
	@Transactional //informando ao spring que ao final desse método aqui ele deve commitar essa transação
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody  @Valid AtualizacaoTopicoForm topicoform){
		
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			Topico topicoformVar = topicoform.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDto(topicoformVar));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
