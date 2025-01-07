package dio.springboot.Aula6SpringData.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.springboot.Aula6SpringData.domain.User;
import dio.springboot.Aula6SpringData.repository.interfaces.UserRepository;

@Component
public class StartApp implements CommandLineRunner{

	@Autowired
	private UserRepository repository;

	
	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setName("Bruno Testes");
//		user.setPassword("Teste123");
//		user.setUsername("brunotestinhas123");
//		
//		repository.save(user);
//		
//		repository.findAll().forEach(t -> System.out.println(t));
		System.out.println("Diretório atual: " + System.getProperty("user.dir"));
	}

}
