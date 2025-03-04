package dio.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //uma classe de configuração
@EnableWebSecurity //habilitando uma segurança web de forma manual (vamos gerenciar a partir desta classe)
@EnableGlobalMethodSecurity(prePostEnabled = true)	// garantir alguns recursos globais da validação das requisições exemplo: PreAuthorize.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception { // Configuração das permissões:
	
		http.authorizeRequests()
				.antMatchers("/").permitAll()	// antMatchers("/") e antMatchers("/login") → Permitem acesso irrestrito a essas rotas, mas o login apenas para POST.
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers("/users").hasAnyRole("USERS", "MANAGERS")	//Acessível para "USERS" e "MANAGERS".
				.antMatchers("/managers").hasAnyRole("MANAGERS")	//antMatchers("/managers") → Acessível apenas para usuários com a role "MANAGERS".
				.anyRequest().authenticated()	// Qualquer outra requisição exige autenticação.
				.and()
//				.formLogin();	//Habilita autenticação via formulário.
				.httpBasic(); //Habilita autenticação basica
	}
	
	
	// configuração básica de autenticação sobrescrevendo o metodo configure do Adapter
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// aqui vai criar uma cadeia de usuarios em memoria
		auth.inMemoryAuthentication()
				.withUser("user")
				//entre bigodinhos{} é o metodo de encrypt
				.password("{noop}user123")
				.roles("USERS")
				.and()
				.withUser("admin")
				.password("{noop}master123")
				.roles("MANAGERS");
	}
	
}
