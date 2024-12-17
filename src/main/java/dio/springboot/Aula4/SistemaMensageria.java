package dio.springboot.Aula4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class SistemaMensageria implements CommandLineRunner{

	@Value("${nome:Teste123}")
	private String nome;
	@Value("${email:ue}")
	private String email;
	@Value("${empresa:ue2}")
	private String empresa;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enviando mensagem para " + nome);
		System.out.println(empresa);
		System.out.println(email);
	}

}
