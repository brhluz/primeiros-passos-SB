package dio.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.gson.Gson;

import dio.springboot.Aula3.Remetente;

@Configuration
public class Bean {
	
	@org.springframework.context.annotation.Bean
	public Gson gson() {
		return new Gson();
	}
	
//	Aula3
//	@org.springframework.context.annotation.Bean
////	@Scope("prototype")
//	public Remetente remetente() {
//		System.out.println("CRIANDO UM OBJETO REMETENTE");
//		Remetente remetente = new Remetente();
//		remetente.setEmail("noreply@teste.com.br");
//		remetente.setNome("Testando as testas na testada");
//		
//		return remetente;
//	}
}
