package br.com.alura.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//ao marcar essa classe com a anotação @RestControllerAdvice estou informando para o sprign que essa classe é que vai fazer o tratamento de resposta de erro em qualquer controller.
public class ErroDeValidacaoHandler { 
	
	@Autowired
	private MessageSource messageSource;//essa classe é do spring, ajuda a pegar mensagens de erro e ajuda na resposta, ao responder para o cliente, a menssagem será lançada no idioma do servidor
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)//informando o spring que a resposta deve ser um bad request
	@ExceptionHandler(MethodArgumentNotValidException.class)//informando para o string que se essa exception  MethodArgumentNotValidException  for lançada, esse método handler deve ser chamado
	public List<ErroFormularioDto> handler(MethodArgumentNotValidException exception) {
		List<ErroFormularioDto> dto = new ArrayList<>();//modelo de resposta de erro
		
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors(); //pegando todos os erros de campos do formulario que aconteceram ao usuário fazer a requisição
		fieldErros.forEach(e -> { //para cada erro, um valor "campo" e "erro" vai ser criado nesse foreach
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); //pegando a mensagem de erro e usando o LocaleContextHolder que pega o idioma que aplicação está sendo executada e forma a resposta.  
			ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);//colocando dentro da classe que é o modelo de resposta de erro e passando como parametro o nome do campo que o erro aconteceu e a mensagem de erro
			dto.add(erro);//adicionando ao dto 
		});
		return dto; //retornando a resposta para o usuário.
	}
	
	

}