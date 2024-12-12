package dio.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dio.springboot.Aula2.ConversorJson;
import dio.springboot.Aula2.ViaCepResponse;

@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirosPassosApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ConversorJson conversor) throws Exception{
		return args -> {
			String json = "{\"cep\": \"81350-260\",\"logradouro\": \"Praça da Sé\",\"localidade\": \"Curitiba-PR\"}";
			ViaCepResponse response = conversor.converter(json);
			System.out.println("Dados do CEP: " + response);
		};
	}
}
