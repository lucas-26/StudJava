package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.alura.forum.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
@Profile("prod")
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{ // spring security configurado mas, só com isso todos os endPoints ficam bloqueados.
	
	
	@Autowired
	private autenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean//usando o @bean o spring saber que esse objeto retorna um autenticarion manager, assim poderemos injetar ele na nossa classe autentication controller
		protected AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
		}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { //esse método serve para configurar a parte de autenticação, ou seja... parte de controle de acesso por exemplo  
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {//confirações de autorização, ou seja quem pode acessar cada url, perfil de acesso e etc
			
			http.authorizeRequests()
						.antMatchers(HttpMethod.GET, "/Topicos").permitAll() //informando ao spring que eu quero deixar liberado para qualquer um o endPoint "/Topicos" mas só no método get
						.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
						.antMatchers(HttpMethod.POST, "/auth").permitAll()
						.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
						.antMatchers(HttpMethod.DELETE, "/topicos/*").hasRole("MODERADOR")//INFORMANDO ao spring que só quem tem o perfil de moderador pode acesar essa url
						.anyRequest().authenticated().//informando ao spring que qualquer outro endpoint tem que estar  autenticado.
						and().csrf().disable().//disabilitando o validação do token do csrf
						sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//informando ao spring que o nosso login vai ser stateless
						.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);//aqui euy= estou falando para o spring rodar o filtro de token AutenticacaoViaTokenFilter antes de rodar o filtro UsernamePasswordAuthenticationFilter que é do proprio spring  
	}	
	
	@Override
		public void configure(WebSecurity web) throws Exception { //configuração de recursos estáticos ou seja arquivos js, css, imagens e etc
		web.ignoring()
        		.antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
		}
}
