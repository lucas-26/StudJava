package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}") //pegando do aplication properties, o tempo de expiração do token
	private String expiration;
	
	@Value("${forum.jwt.secret}") //pegando do aplication properties, o segredo do token
	private String secret;

	public String geraToken(Authentication aut) {
		Usuario logado = (Usuario) aut.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		
		return Jwts.builder()//Método que seta as informações para construir um token
		.setIssuer("Api do Fórum da Alura")//quem está gerando esse token?
		.setSubject(logado.getId().toString())//que é o dono desse token, o usuário
		.setIssuedAt(hoje)//data que o token é gerado
		.setExpiration(dataExpiracao)//quanto tempo o token vale, uma validade
		.signWith(SignatureAlgorithm.HS256, secret)//primeiro parametro é qual algoritmo que vai gerar esse token e a string secrete
		.compact();//compacta e transforma em uma string
		
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	public Long getIdUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return  Long.parseLong(body.getSubject());
	}
	
	

}
