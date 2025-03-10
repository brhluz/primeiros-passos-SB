package JWTEstudo.Estudos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import JWTEstudo.Estudos.Model.User;
import JWTEstudo.Estudos.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void createUser(User user){
		String password = user.getPassword();
		
		user.setPassword(encoder.encode(password));
		userRepository.save(user);
	}
	
}
