package dio.spring.security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.spring.security.model.User;
import dio.spring.security.repository.UserRepository;

@Component
public class StartApplication implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {

		User user = repository.findByUsername("admin");
		if(user == null) {
			user = new User();
			user.setName("ADMIN");
			user.setPassword("master123");
			user.setUsername("admin");
			user.getRoles().add("MANAGERS");
			repository.save(user);
		}
		user = repository.findByUsername("user");
		if(user == null) {
			user = new User();
			user.setName("USER");
			user.setPassword("user123");
			user.setUsername("user");
			user.getRoles().add("USERS");
			repository.save(user);
		}
		
	}

}
