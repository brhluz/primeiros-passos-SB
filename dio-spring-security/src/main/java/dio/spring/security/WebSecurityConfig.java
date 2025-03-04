package dio.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@Configuration //uma classe de configuração
@EnableWebFluxSecurity //habilitando uma segurança web de forma manual (vamos gerenciar a partir desta classe)
@EnableGlobalMethodSecurity(prePostEnabled = true)	// garantir alguns recursos globais da validação das requisições.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	// configuração básica de autenticação sobrescrevendo o metodo configure do Adapter
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// aqui vai criar uma cadeia de usuarios em memoria
		auth.inMemoryAuthentication()
				.withUser("user")
				//entre bigodinhos é o metodo de encrypt
				.password("{noop}user123")
				.roles("USERS")
				.and()
				.withUser("admin")
				.password("{noop}master123")
				.roles("MANAGERS");
	}
	
}
