package dio.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration //uma classe de configuracaoo
@EnableWebSecurity //habilitando uma seguranca web de forma manual (vamos gerenciar a partir desta classe)
@EnableGlobalMethodSecurity(prePostEnabled = true)	// garantir alguns recursos globais da validação das requisicoes exemplo: PreAuthorize.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	SecurityDataBaseService securityService;
	
	// injetar uma autenticação de um gerenciador de autenticações que usara nosso securityService
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityService)
				.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { // Configuração das permissoes:
	
		http.authorizeRequests()
				.antMatchers("/").permitAll()	// antMatchers("/") e antMatchers("/login") Permitem acesso irrestrito a essas rotas, mas o login apenas para POST.
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers("/users").hasAnyRole("USERS", "MANAGERS")	//Acessivel para "USERS" e "MANAGERS".
				.antMatchers("/managers").hasAnyRole("MANAGERS")	//antMatchers("/managers") Acessivel apenas para usuarios com a role "MANAGERS".
				.anyRequest().authenticated()	// Qualquer outra requisicao exige autenticacao.
				.and()
//				.formLogin();	//Habilita autenticacao via formulario.
				.httpBasic(); //Habilita autenticacao basica
	}
	
	
	// configuracao basica de autenticacao sobrescrevendo o metodo configure do Adapter
	// classe comentada porque agora não é mais guardado em memoria e sim no banco h2
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// aqui vai criar uma cadeia de usuarios em memoria
//		auth.inMemoryAuthentication()
//				.withUser("user")
//				//entre bigodinhos{} e o metodo de encrypt
//				.password("{noop}user123")
//				.roles("USERS")
//				.and()
//				.withUser("admin")
//				.password("{noop}master123")
//				.roles("MANAGERS");
//	}
//	
}
